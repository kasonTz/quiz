package com.newer.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.CountQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.newer.entity.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer>{

	@Query("{'level':?0}")
	List<Question> findByLevel(int level);
	
	@CountQuery("{'level':?0}")
	int countByLevel(int level);
	
}
