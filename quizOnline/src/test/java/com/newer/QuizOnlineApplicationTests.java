package com.newer;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.newer.utils.RandomUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizOnlineApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("我是test");
		List<Integer> list = RandomUtil.randomForLevel(5, 4);
		System.out.println(list.toString());
	}
	

}
