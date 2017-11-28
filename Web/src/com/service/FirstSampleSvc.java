package com.service;

public class FirstSampleSvc {
	/*
	 * int num;
	 * 
	 * public FirstSampleSvc(int num) { this.num = num; }
	 */

	public int sum(int endNum) {
		int totalSum = 0;
		for (int i = 1; i <= endNum; i++) {
			totalSum += i;
		}
		return totalSum;
	}
}
