/*
 * Andrew Parise
 * 4/24/16
 * Assignment 9.1
 * MyBubbleSortTest.java
 * 
 * Class Overview:
 * 	Solves the problem defined in the assignment overview
 * 
 */
public class EfficiencyCalcTest {

	public static void printAnalyticData(int[] analyticData){
		System.out.println("Number of Statements: " + analyticData[0]);
		System.out.println("Number of Conditionals: " + analyticData[1]);
		System.out.println("Number of Loops: " + analyticData[2]);
		System.out.println("Number of Nested Loops: " + analyticData[3]);
		if(analyticData[3] > 0){
			//When there is a nested loop, it becomes O(n^2) efficiency, this occurs when the array is even slightly unsorted
			System.out.println("Efficiency of this execution: O(n^2)");
		}
		else{
			//When there are no nested loops called, the efficiency is O(n), this occurs when the array is sorted
			System.out.println("Efficiency of this execution: O(n)");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EfficiencyCalc generateArr = new EfficiencyCalc(5000);
		int[] numList = generateArr.getNumList();
		MyBubbleSort bs = new MyBubbleSort(numList, true);
		bs.sort();
		int[] analyticData = bs.getAnalyticData();
		printAnalyticData(analyticData);
	}

}
