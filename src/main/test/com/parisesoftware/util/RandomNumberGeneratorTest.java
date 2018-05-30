package com.parisesoftware.util;

import com.parisesoftware.algorithm.BubbleSortImpl;

import java.util.List;

/*
 * Andrew Parise
 * 4/24/16
 * Assignment 9.1
 * BubbleSortImplTest.java
 * 
 * Class Overview:
 * 	Solves the problem defined in the assignment overview
 * 
 */
public class RandomNumberGeneratorTest {

	private static void printAnalyticData(List<Integer> analyticData){
		System.out.println("Number of Statements: " + analyticData.get(0));
		System.out.println("Number of Conditionals: " + analyticData.get(1));
		System.out.println("Number of Loops: " + analyticData.get(2));
		System.out.println("Number of Nested Loops: " + analyticData.get(3));
		if(analyticData.get(3) > 0){
			//When there is a nested loop, it becomes O(n^2) efficiency, this occurs when the array is even slightly unsorted
			System.out.println("Efficiency of this execution: O(n^2)");
		}
		else{
			//When there are no nested loops called, the efficiency is O(n), this occurs when the array is sorted
			System.out.println("Efficiency of this execution: O(n)");
		}
	}
	
	public static void main(String[] args) {
		IRandomNumberGenerator generateArr = new RandomNumberGenerator();
		List<Integer> numList = generateArr.getNumberList(5000);
		BubbleSortImpl bs = new BubbleSortImpl(numList, true);
		bs.sort();
		List<Integer> analyticData = bs.getAnalyticData();
		printAnalyticData(analyticData);
	}

}
