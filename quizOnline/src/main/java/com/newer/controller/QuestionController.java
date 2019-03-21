package com.newer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.entity.Question;
import com.newer.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/add")
	public String add() {
		int i = questionService.addQuestion();
		if (i == 1) {
			return "插入成功";
		} else {
			return "插入失败";
		}
	}
	
	@GetMapping("/list")
	public List<Question> getAll() {
		return questionService.getAll();
	}
}
