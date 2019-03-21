package com.newer.entity;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.newer.controller.annotation.AutoIncKey;

/**
 * 实体类
 * 
 * @author kai
 *
 */
@Document(collection="questions")
public class Question {

	/**
	 * MongoDB自动生成主键
	 */
	@Id
	private String _id;
	
	/**
	 * 自增长键
	 */
	@AutoIncKey
	private Long id = 0L;
	
	/**
	 * 题目内容
	 */
	@Field
	private String subject;
	
	/**
	 * 题目选项
	 */
	@Field
	private String[] items;
	
	/**
	 * 题目答案
	 */
	@Field
	private String[] answers;
	
	/**
	 * 答案解析
	 */
	@Field
	private String parse;
	
	/**
	 * 题目级别(1：单选，2：多选，3：填空)
	 */
	@Field
	private int level;
	
	public Question() {}

	public Question(String subject, String[] items, String[] answers, String parse, int level) {
		super();
		this.subject = subject;
		this.items = items;
		this.answers = answers;
		this.parse = parse;
		this.level = level;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public String getParse() {
		return parse;
	}

	public void setParse(String parse) {
		this.parse = parse;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Question [_id=" + _id + ", id=" + id + ", subject=" + subject + ", items=" + Arrays.toString(items)
				+ ", answers=" + Arrays.toString(answers) + ", parse=" + parse + ", level=" + level + "]";
	}
	
}
