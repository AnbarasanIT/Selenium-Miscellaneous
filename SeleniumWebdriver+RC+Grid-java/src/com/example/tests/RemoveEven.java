package com.example.tests;

public class RemoveEven {
	 public static void main(String[] args) {
	        int[] arr ={1,2,3,4,5};
	        int k=0;
	        for(int i=0;i<arr.length;i++) {
	            if(arr[i]%2!=0) {
	                arr[k]=arr[i];
	                k++;
	            }
	        }
	        for(;k<arr.length;k++)
	            arr[k]=0;
	        for(int i:arr) System.out.print(i+" ");
	    }
	}


