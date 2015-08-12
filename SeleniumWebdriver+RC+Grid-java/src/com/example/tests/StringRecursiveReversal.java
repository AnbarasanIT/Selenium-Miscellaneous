package com.example.tests;

public class StringRecursiveReversal {
	 String reverse = "",test2;
	 char test;
     
	    public String reverseString(String str){
	         
	        if(str.length() == 1){
	            return str;
	        } else {
	            reverse += str.charAt(str.length()-1) +reverseString(str.substring(0,str.length()-1));
	            return reverse;
	        }
	    }
	     
	    public static void main(String a[]){
	        StringRecursiveReversal srr = new StringRecursiveReversal();
	        System.out.println("Result: "+srr.reverseString("T"));
	    }
}
