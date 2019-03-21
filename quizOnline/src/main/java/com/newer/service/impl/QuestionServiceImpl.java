package com.newer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.dao.QuestionRepository;
import com.newer.entity.Question;
import com.newer.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
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
		
//		List<Question> list = new ArrayList<>();
//		List<Question> insert = questionRepository.insert(list);
		questionRepository.insert(q1);
		questionRepository.insert(q2);
		questionRepository.insert(q3);
		
		return 1;
	}

	@Override
	public List<Question> getAll() {
		return questionRepository.findAll();
	}

}
