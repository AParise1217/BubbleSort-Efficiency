package com.parisesoftware.algorithm;

import com.parisesoftware.output.ConsoleArrayPrinter;
import com.parisesoftware.output.IConsoleArrayPrinter;

import java.util.ArrayList;
import java.util.List;

/*
 * Andrew Parise
 * 4/24/16
 * Assignment 9.1
 * BubbleSortImplTest.java
 * 
 * Class Overview:
 *  Test class to test the functionality of BubbleSortImpl.java before it is further used
 *  
 */
public class BubbleSortImplTest {

	private static void printArr(List<Integer> intList){
		IConsoleArrayPrinter printer = new ConsoleArrayPrinter();
		printer.printIntArray(intList);
	}
	
	public static void main(String[] args) {
		List<Integer> testData = new ArrayList<>();
		testData.add(12312);
		testData.add(12233);
		testData.add(4554);
		testData.add(532);
		testData.add(744);

		BubbleSortImpl bs = new BubbleSortImpl(testData, false);
		bs.sort();
		printArr(bs.getSortedArr());
		
		
	}

}
