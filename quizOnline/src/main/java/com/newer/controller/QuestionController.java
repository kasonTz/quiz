package com.newer.controller;

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

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
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
	
	@PostMapping("/test")
	public String postrequest(@RequestParam("id") int a) {
		System.out.println(a);
		return "post";
	}
}
