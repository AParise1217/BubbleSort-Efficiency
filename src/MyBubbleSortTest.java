/*
 * Andrew Parise
 * 4/24/16
 * Assignment 9.1
 * MyBubbleSortTest.java
 * 
 * Class Overview:
 *  Test class to test the functionality of MyBubbleSort.java before it is further used
 *  
 */
public class MyBubbleSortTest {

	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testData = {12312,12233,4554,532,1238,744};
		
		MyBubbleSort bs = new MyBubbleSort(testData, false);
		bs.sort();
		printArr(bs.getSortedArr());
		
		
	}

}
