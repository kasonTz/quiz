package com.newer.controller.listener;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import com.newer.controller.annotation.AutoIncKey;
import com.newer.entity.SeqInfo;

@Component
public class SaveEventListener extends AbstractMongoEventListener<Object>{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		// 获取事件最初发生的对象
		Object source = event.getSource();
		if(source != null) {
			// 使用反射工具类：实现回调接口的方法，对成员进行操作	ReflectionUtils：spring对反射的一个包装
			ReflectionUtils.doWithFields(source.getClass(), new FieldCallback() {
				
				@Override
				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
					// 使操作的成员可访问
					ReflectionUtils.makeAccessible(field);
					// 字段添加了自定义AutoIncKey注解的
					if(field.isAnnotationPresent(AutoIncKey.class)) {
						// 设置自增
						field.set(source, getNextId(source.getClass().getSimpleName()));
					}
				}
			});
		}
	}
	
	/**
	 * 获取下一个自增ID
	 * 
	 * @param collName	集合（这里用类名，就唯一性来说最好还是放长类名）
	 * @return 序列值
	 */
	private Long getNextId(String collName) {
		Query query = new Query(Criteria.where("collName").is(collName));
		Update update = new Update();
		update.inc("seqId", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.upsert(true);
		options.returnNew(true);
		SeqInfo seqInfo = mongoTemplate.findAndModify(query, update, options, SeqInfo.class);
		return seqInfo.getSeqId();
	}
}