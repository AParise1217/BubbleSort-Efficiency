package com.parisesoftware.util;

import java.util.ArrayList;
import java.util.List;

/*
 * @author	Andrew Parise
 * @since	4/24/16
 * @version	5/30/18
 *
 * Generates Lists of random numbers
 */
public class RandomNumberGenerator implements IRandomNumberGenerator {
	private List<Integer> _numberList;

	/**
	 * Default Constructor
	 */
	public RandomNumberGenerator(){
		//default constructor, provide the size of the array to be constructed/generated
		_numberList = new ArrayList<Integer>();
	}

	public List<Integer> getNumberList(int listLength){
		populateNumList(listLength);
		return _numberList;
	}

	private void populateNumList(int howMany){
		//populates the number list with [listSize] number of elements
		for(int i = 0; i < howMany; i++){
			_numberList.set(i, fetchRandNum());
		}
	}

	private int fetchRandNum(){
		//generates and then returns a random number of [numDigits] digits
		return (int)(Math.random()*Math.pow(10, (7)));
	}

}
