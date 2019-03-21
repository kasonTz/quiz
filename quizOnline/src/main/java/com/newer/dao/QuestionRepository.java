package com.newer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.newer.entity.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer>{

}
