package com.parisesoftware.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * @author	Andrew Parise
 * @since	4/24/16
 * @version	5/30/18
 *
 * Implementation of the Bubble Sort algorithm
 */
public class BubbleSortImpl {

    private List<Integer> _preSort;
    private List<Integer> _postSort;
    private boolean _hasSorted;

    //used for calculating the efficiency
    private boolean _performAnalytics;
    private int numStatements;
    private int numConditionals;
    private int numLoops;
    private int numNestedLoops;

    public BubbleSortImpl(List<Integer> preSortList, boolean performAnalytics){
        //default constructor, input is a list to be sorted
        _preSort = preSortList;
        _postSort = new ArrayList<Integer>(); //creates a new array of the same length as the preSorted array
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
        List<Integer> intArr = _preSort;

        boolean isSwap = true;
        int tempVar;

        while(isSwap){
            isSwap = false;
            for(int i = 0; i < (intArr.size() - 1); i++){
                if(intArr.get(i) > intArr.get(i + 1)){
                    tempVar = intArr.get(i);
                    intArr.set(i, intArr.get(i + 1));
                    intArr.set(i + 1, tempVar);
                    isSwap = true;
                }
            }
        }
        _hasSorted = true;
        _postSort = intArr;
    }

    private void sortAnalytics(){
        //same as regular version, this one just tracks the number of statements used to calc efficiency
        //performs the bubble sort algorithm on the list
        List<Integer> intArr = _preSort;
        numStatements++;
        boolean isSwap = true;
        numStatements++;
        int tempVar;
        numStatements++;
        while(isSwap){
            numLoops++;
            isSwap = false;
            numStatements++;
            for(int i = 0; i < (intArr.size() - 1); i++){
                numNestedLoops++;
                if(intArr.get(i) > intArr.get(i + 1)){
                    numConditionals++;
                    tempVar = intArr.get(i);
                    numStatements++;
                    intArr.set(i, intArr.get(i + 1));
                    numStatements++;
                    intArr.set(i + 1, tempVar);
                    numStatements++;
                    isSwap = true;
                    numStatements++;
                }
            }
        }
        _hasSorted = true;
        _postSort = intArr;
        numStatements++;
    }

    public List<Integer> getAnalyticData(){
        //returns a list of the data collected in performing the bubble sort algorithm
        //format is [numStatements, numConditionals, numLoops, numNestedLoops]
        if(_performAnalytics && (_hasSorted)){
            List<Integer> data = new ArrayList<>();
            data.set(0, numStatements);
            data.set(1, numConditionals);
            data.set(2, numLoops);
            data.set(3, numNestedLoops);

            return data;
        }
        return null;
    }

    public List<Integer> getSortedArr(){
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
