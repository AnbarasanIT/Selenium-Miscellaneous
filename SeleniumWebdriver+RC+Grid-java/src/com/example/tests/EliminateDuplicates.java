package com.example.tests;

import java.util.Scanner;

public class EliminateDuplicates {

	 public static void main(String args[])
	   {  
		 int[] a = new int[50] {"11,13,11,12,13"};
	    int i ,j,k,n; 
	    Scanner in = new Scanner(System.in);
	 // getting the all values one by one
	      n = in.nextInt();
	      for(i=0;i<n;i++)
	      {   Scanner ele =new Scanner(System.in);
	          int els=ele.nextInt();
	    	  a[i]=els;
	    	  System.out.println("Array is:"+a[i]);
	      }
	       	  
	      }
	  
}

