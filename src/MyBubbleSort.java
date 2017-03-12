/*
 * Andrew Parise
 * 4/24/16
 * Assignment 9.1
 * MyBubbleSortTest.java
 * 
 * Class Overview:
 * 	My implementation of the Bubble Sort algorithm
 * 
 */
public class MyBubbleSort {
	//init
	private int[] _preSort; 
	private int[] _postSort;
	private boolean _hasSorted;
	public static boolean _DEBUG = true;
	//used for calculating the efficiency
	private boolean _performAnalytics;
	private int numStatements;
	private int numConditionals;
	private int numLoops;
	private int numNestedLoops;
	
	public MyBubbleSort(int[] preSortList, boolean performAnalytics){
		//default constructor, input is a list to be sorted
		_preSort = preSortList;
		_postSort = new int[preSortList.length]; //creates a new array of the same length as the preSorted array
		_hasSorted = false;
		if(performAnalytics){
			//Used to track data for analytics performed
			_performAnalytics = true;
			numStatements = 0;
			numConditionals = 0;
			numLoops = 0;
			numNestedLoops = 0;
		}
	}
	
	private void sortRegular(){
		//performs the bubble sort algorithm on the list
		int[] intArr = _preSort;

		boolean isSwap = true;
		int tempVar = 0;
		
		while(isSwap){
			isSwap = false;
			for(int i = 0; i < (intArr.length - 1); i++){
				if(intArr[i] > intArr[i+1]){
					tempVar = intArr[i];
					intArr[i] = intArr[i+1];
					intArr[i+1] = tempVar;
					isSwap = true;
				}
			}
		}
		_hasSorted = true;
		_postSort = intArr;
		return;
	}
	private void sortAnalytics(){
		//same as regular version, this one just tracks the number of statements used to calc efficiency
		//performs the bubble sort algorithm on the list
				int[] intArr = _preSort;
				numStatements++;
				boolean isSwap = true;
				numStatements++;
				int tempVar = 0;
				numStatements++;
				while(isSwap){
					numLoops++;
					isSwap = false;
					numStatements++;
					for(int i = 0; i < (intArr.length - 1); i++){
						numNestedLoops++;
						if(intArr[i] > intArr[i+1]){
							numConditionals++;
							tempVar = intArr[i];
							numStatements++;
							intArr[i] = intArr[i+1];
							numStatements++;
							intArr[i+1] = tempVar;
							numStatements++;
							isSwap = true;
							numStatements++;
						}
					}
				}
				_hasSorted = true;
				_postSort = intArr;
				numStatements++;
				return;
	}
	public int[] getAnalyticData(){
		//returns a list of the data collected in performing the bubble sort algorithm
		//format is [numStatements, numConditionals, numLoops, numNestedLoops]
		if(_performAnalytics && (_hasSorted)){
			int[] data = new int[4];
			data[0] = numStatements;
			data[1] = numConditionals;
			data[2] = numLoops;
			data[3] = numNestedLoops;
			
			return data;
		}
		return null;
	}
	public int[] getSortedArr(){
		//returns the sorted array
		if(_hasSorted){
			return _postSort;
		}
		return null;
	}
	public void sort(){
		//Determines which version of bubble sort to call
		if(_performAnalytics){
			sortAnalytics();
		}
		else{
			sortRegular();
		}
	}
}
