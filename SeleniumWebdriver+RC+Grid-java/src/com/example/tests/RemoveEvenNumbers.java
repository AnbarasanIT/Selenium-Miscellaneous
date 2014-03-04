package com.java.practice.run;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class RemoveEvenNumbers {
    public static void main(String[] args) {
               int occurrence = 0;

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
    	        Map <Integer, Integer> uniqueNumberCount = new HashMap<Integer, Integer>();

    	        for(int datano:nos){
    	            int k=1;
    	            if(uniqueNumberCount.containsKey(datano)){
    	                k=uniqueNumberCount.get(datano);
    	            }
    	            uniqueNumberCount.put(datano, ++k);
    	        }

    	        for(Map.Entry<Integer, Integer> unique:uniqueNumberCount.entrySet()){

    	            System.out.println(unique.getKey()+" Unique Value --->"+unique.getValue());
    	        }

    	}
    	}