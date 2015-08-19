package com.anbj.test.java;

public class AmstrongNumber {


	public static int isAmstrong(int number){
		int sum = 0;
		while(number>0){

			int mod=number%10;
			int rem=number/10;
			sum=sum+(mod*mod*mod);
			number=rem;
		}
		return sum;
	}
	public static  void printAmstrongNum()
	{  for(int findAmstrong=0;findAmstrong<=1000;findAmstrong++){
		int num=AmstrongNumber.isAmstrong(findAmstrong);
		if(num==findAmstrong){
			System.out.println(num+" is a Amrong number");	 
		}
	}
	}
	public static void main(String a[]){
		AmstrongNumber.printAmstrongNum();

	}
}

