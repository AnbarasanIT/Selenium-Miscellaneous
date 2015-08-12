package com.example.tests;
import java.util.Scanner;

public class RecursionReverseString {

	public static String reverse;
	   //A method for reverse
	   public static void reverseMethod(String str) {
	       if (str.length()==1) {
		   return;
	       }
	       else {
	    	   int length = str.length();
	 	      for ( int i = length - 1 ; i >= 0 ; i-- )
	 	         reverse = reverse + str.charAt(i);
	 	      	System.out.println(reverse);
	 	      	 reverseMethod(reverse);
	 	       
	 	       
	       }
	   }
	   public static void main(String args[])
	   {
		String orignal;
		System.out.println("Input your number and press enter: ");
		Scanner in = new Scanner(System.in);
		orignal = in.nextLine();
		System.out.print("Reverse of the input number is:");
		reverseMethod(orignal);
		System.out.println();
	   }
	}

