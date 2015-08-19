package com.anbj.test.java;

import java.util.Arrays;

public class RemoveDupArraysort {
	 public static void removeDuplicates(int[] input){
		 int i=0 ,j=0;
		 Arrays.sort(input);
		 for(i=0;i<input.length;i++)
		 {
			 for(j=0;j<i;j++){
				 if(input[i]==input[j])
				 {
					 break;
				 }
				 else{
					 System.out.println(input[i]);
				 }
			 }
		 }
	     
}
public static void main(String a[]){
    int[] input1 = {2,10,10,6,8,9,3,6,10,12,12};
     removeDuplicates(input1);
   
    }
}
