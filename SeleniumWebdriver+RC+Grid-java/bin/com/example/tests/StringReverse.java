package com.anbj.test.java;

public class StringReverse {
	
	public static String reverse(String str){
		String reverse ="";
	
		for(int i=str.length()-1;i>=0;i--){
			reverse+=str.charAt(i);
		}
		return reverse;
		
	}
	
	public static void main(String a[]){
		String Original="madam";
		String reverse=StringReverse.reverse(Original);
		System.out.println("Reversed string is:: "+reverse);
		if(Original.equals(reverse)){
			System.out.println("Palindrome");
		}else{
			System.out.println("Not a palindrom");
		}
	}
}


