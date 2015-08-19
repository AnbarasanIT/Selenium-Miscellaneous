package com.anbj.test.java;

public class PrimeNumbers2 {
	public static void primeNumberchk(int limit){
		int i =0, num =0;
		String  primeNumbers = "";
		for (i = 1; i <= limit; i++)  	   
		{ 		 		  
			int counter=0; 		  
			for(num =i; num>=1; num--)
			{
				if(i%num==0)
				{
					counter +=1;
				}
			}
			if (counter ==2)
			{

				primeNumbers = primeNumbers + i + " ";
			}	
		}	
		System.out.println("Prime numbers from 1 to 100 are :");
		System.out.println(primeNumbers);
	}
	public static void main (String[] args)
	   {	primeNumberchk(100);	
	   
	   }
	}

