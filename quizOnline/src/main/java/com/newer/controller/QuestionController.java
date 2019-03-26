package com.newer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.entity.Question;
import com.newer.service.QuestionService;
import com.newer.utils.RandomUtil;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/submit")
	public String add2() {
		return null;
	}
	
	/**
	 * 添加
	 * 
	 * @return
	 */
	@GetMapping("/add")
	public String add() {
		int i = questionService.addQuestion();
		if (i == 1) {
			return "插入成功";
		} else {
			return "插入失败";
		}
	}
	
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Question> getAll() {
		return questionService.getAll();
	}
	
	@GetMapping("/listByLevel")
	public List<Question> getByLevel(@RequestParam int level) {
		System.out.println("level: " + level);
		List<Question> listLevel = questionService.getByLevel(level);
		return listLevel;
	}
	
	@GetMapping("/online")
	public List<Question> getRandomQuestion() {
		int c1 = questionService.getCountByLevel(1);
		int c2 = questionService.getCountByLevel(2);
		int c3 = questionService.getCountByLevel(3);
		List<Question> listLevelOne = questionService.getByLevel(1);
		List<Question> listLevelTwo = questionService.getByLevel(2);
		List<Question> listLevelThree = questionService.getByLevel(3);
		// 总题目数
		int total = 10;
		// 各个级别所占题目数量
		int t1 = (total * 5/10);
		int t2 = (total * 3/10);
		int t3 = (total * 2/10);
		List<Integer> list1 = RandomUtil.randomForLevel(c1, t1);
		List<Integer> list2 = RandomUtil.randomForLevel(c2, t2);
		List<Integer> list3 = RandomUtil.randomForLevel(c3, t3);
		
		List<Question> list = new ArrayList<>();
		
		for (Integer integer : list1) {
			list.add(listLevelOne.get(integer-1));
		}
		for (Integer integer : list2) {
			list.add(listLevelTwo.get(integer-1));
		}
		for (Integer integer : list3) {
			list.add(listLevelThree.get(integer-1));
		}
		return list;
	}

	
}
