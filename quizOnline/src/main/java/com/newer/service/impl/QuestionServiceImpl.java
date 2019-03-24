package com.newer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.newer.dao.QuestionRepository;
import com.newer.entity.Question;
import com.newer.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public int addQuestion() {
		String[] items1 = {"C","C++","Java","TypeScript"};
		String[] answers1 = {"A"};
		Question q1 = new Question("最好的程序设计语言", items1, answers1, "我是这道题的解析。。。。测试1", 1);
		
		String[] items2 = {"可口可乐","Google","Apple","中石油"};
		String[] answers2 = {"C"};
		Question q2 = new Question("市值最高的公司", items2, answers2, "我是这道题的解析。。。。测试2", 1);
		
		String[] items3 = {"黄河","尼罗河","亚马逊","多瑙河"};
		String[] answers3 = {"C"};
		Question q3 = new Question("最长的河", items3, answers3, "我是这道题的解析。。。。测试3", 1);
		
		String[] items4 = {"刘阳","刘阳河","浏阳","浏阳河"};
		String[] answers4 = {"C","D"};
		Question q4 = new Question("这是一道多选题", items4, answers4, "我是这道题的解析。。。。测试4", 2);
		
		String[] items5 = {"刘阳","刘阳河","浏阳","浏阳河"};
		String[] answers5 = {"A","B"};
		Question q5 = new Question("这是一道多选题2", items5, answers5, "我是这道题的解析。。。。测试5", 2);
		
		String[] answers6 = {"填空题1"};
		Question q6 = new Question("我是一道填空题1", null, answers6, "我是这道题的解析。。。。测试6", 3);
		
		String[] answers7 = {"填空题2"};
		Question q7 = new Question("我是一道填空题2", null, answers7, "我是这道题的解析。。。。测试7", 3);
//		List<Question> list = new ArrayList<>();
//		List<Question> insert = questionRepository.insert(list);
//		questionRepository.insert(q1);
//		questionRepository.insert(q2);
//		questionRepository.insert(q3);
//		questionRepository.insert(q4);
//		questionRepository.insert(q5);
		questionRepository.insert(q6);
		questionRepository.insert(q7);
		return 1;
	}

	@Override
	public List<Question> getAll() {
		return questionRepository.findAll();
	}

	/**
	 * 通过级别查询
	 */
	@Override
	public List<Question> getByLevel(int level) {
		return questionRepository.findByLevel(level);
	}

	@Override
	public List<Question> getRandomQuestion() {
		mongoTemplate.save(new Question());
		return null;
	}

}
