package com.anbj.test.java;

import java.util.Scanner;

public class PalindromeString {

	   public static void main(String args[])
	   {
	      String /*original*/ reverse="";
	      int aryLenth,j=0;
	     /// Scanner in = new Scanner(System.in);
	 
	      //System.out.println("Enter a string to check if it is a palindrome");
	     // original = in.nextLine();
	 
	      String original[]={"anbj", "madam"};
	        for (j=0;j<=original.length-1;j++){
	    	  aryLenth=original[j].length();
	    	
	    	  for ( int i = aryLenth - 1 ; i >= 0 ; i-- )
	    		  reverse = reverse + original[j].charAt(i);
	 
	      if (original[j].equals(reverse)){
	    	  reverse.replace(original[j],"");
	         System.out.println("Entered string is a palindrome.");}
	      
	      else {
	    	 reverse.replace(original[j],"");
	         System.out.println("Entered string is not a palindrome.");}
	     
	   }
	      
	   }
}
