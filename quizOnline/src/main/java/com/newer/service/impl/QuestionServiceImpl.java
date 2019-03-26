package com.newer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.newer.dao.QuestionRepository;
import com.newer.entity.Question;
import com.newer.service.QuestionService;
import com.newer.utils.RandomUtil;

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
		
		String[] items8 = {"可口可乐","Google","Apple","中石油"};
		String[] answers8 = {"A"};
		Question q8 = new Question("单选题，随便选", items8, answers8, "我是这道题的解析。。。。测试8", 1);
		
		String[] items9 = {"可口可乐","Google","Apple","中石油"};
		String[] answers9 = {"D"};
		Question q9 = new Question("是单选吗", items9, answers9, "我是这道题的解析。。。。测试9", 1);
		
		String[] items10 = {"刘阳","刘阳河","浏阳","浏阳河"};
		String[] answers10 = {"A","B"};
		Question q10 = new Question("这是一道多选题3", items10, answers10, "我是这道题的解析。。。。测试5", 2);
//		List<Question> list = new ArrayList<>();
//		List<Question> insert = questionRepository.insert(list);
//		questionRepository.insert(q1);
//		questionRepository.insert(q2);
//		questionRepository.insert(q3);
//		questionRepository.insert(q4);
//		questionRepository.insert(q5);
//		questionRepository.insert(q6);
//		questionRepository.insert(q7);
		questionRepository.insert(q8);
		questionRepository.insert(q9);
		questionRepository.insert(q10);
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

	/**
	 * 	根据level查询题目数量
	 */
	@Override
	public int getCountByLevel(int level) {
		int i = questionRepository.countByLevel(level);
		return i;
	}
	
	public void test(int c1, int c2, int c3) {

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
//		List<Question> listLevelOne = questionService.getByLevel(1);
//		List<Question> listLevelTwo = questionService.getByLevel(2);
//		List<Question> listLevelThree = questionService.getByLevel(3);
		// 总题目数
		int total = 10;
		// 各个级别所占题目数量
		int t1 = (total * 5/10);
		int t2 = (total * 3/10);
		int t3 = (total * 2/10);
		
		System.out.println("------------------");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		List<Integer> list1 = RandomUtil.randomForLevel(c1, t1); //3 5
		List<Integer> list2 = RandomUtil.randomForLevel(c2, t2); //2 3
		List<Integer> list3 = RandomUtil.randomForLevel(c3, t3);
		
		System.out.println("--------qq---------");
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		System.out.println(list3.toString());
	}

}
