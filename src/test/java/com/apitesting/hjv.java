package com.apitesting;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class hjv {

	public static void main(String[] args) {

		int[] num = {5,8,9,6,4,7,2};
		Arrays.sort(num);
		int size = num.length-1;
		System.out.println(num[size]);
		for(int i = 0;i<num.length;i++) {
			System.out.println(size-i);
			if(i==1)
				break;
		}
		
		//int[] numbers = { 5, 20, 30, 45, 70, 80, 95, 100, 105, 115, 200, 225, 300, 305 };
		int[] vowels = {5, 20, 30, 45, 90, 80, 95, 100, 105, 115, 200, 225, 300, 305 };
		int number = 75;
		
		int[] resultArray = ArrayUtils.add(vowels, number);
		// using simple iteration over the array elements
		for (int s : resultArray) {
			if (s == 75) {
				System.out.println(s);
				break;
			}
		}
		}}
