package com.example.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOccurances {
	
	
public static void main(String[] args) {
	        int occurrence = 0;

	        Map <Integer, String> m = new HashMap<Integer, String>();
	        List <Integer> nos = new LinkedList<Integer>();
	        nos.add(1);
	        nos.add(1);
	        nos.add(2);
	        nos.add(3);
	        nos.add(4);
	        nos.add(3);
	        nos.add(2);
	        nos.add(4);
	        nos.add(5);
	        nos.add(100);

	        Set <Integer>uniqueNos = new HashSet<Integer>(nos);

	        for(int temp:uniqueNos) { // 1,2,3,4,5,100
	            for(int tempList:nos) { // 1,1,2,3,4,3,2,4,5,,100
	                if(temp == tempList) {
	                    occurrence++;
	                }
	            }
	            m.put(temp, "Appears "+occurrence +" times" +"\n");
	            occurrence = 0;
	        }

	        System.out.println(m);
	    }

}
