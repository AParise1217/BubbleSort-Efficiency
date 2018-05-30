package com.parisesoftware.output;

import java.util.List;

public class ConsoleArrayPrinter implements IConsoleArrayPrinter {

    public ConsoleArrayPrinter(){}

    public void printIntArray(List<Integer> intList) {
        for (Integer anIntList : intList) {
            System.out.println(anIntList);
        }
    }
}
