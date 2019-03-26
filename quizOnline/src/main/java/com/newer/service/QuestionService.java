package com.newer.service;

import java.util.List;

import com.newer.entity.Question;

/**
 * 业务层接口
 * 
 * @author kai
 *
 */
public interface QuestionService {

	public int addQuestion();
	
	public List<Question> getAll();
	
	List<Question> getByLevel(int level);
	
	int getCountByLevel(int level);
	
	void test(int c1, int c2, int c3);
}
