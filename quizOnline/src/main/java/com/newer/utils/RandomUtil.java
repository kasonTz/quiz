package com.newer.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

	private RandomUtil() {
	}
	
	/**
	 * 3 5  2 3
	 * 	取小于a的随机数取b个
	 * @return
	 */
	public static List<Integer> randomForLevel(int maxValue, int count) {
		List<Integer> list  = new ArrayList<Integer>();
		while(list.size() < count) {
			int num = (int) ((Math.random()*maxValue)+1);
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		return list;
	}
	
}
