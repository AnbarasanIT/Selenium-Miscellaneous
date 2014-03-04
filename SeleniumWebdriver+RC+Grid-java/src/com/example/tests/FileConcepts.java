package com.java.practice.run;

import java.io.*;

import java.math.MathContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



 

public class FileConcepts {
	 public static String  path="C:\\test.txt";
	// public static  boolean text="null";
	 public static void main(String[] args) throws IOException
	    {	
	    try{	
		 FileReader f=new FileReader(path);
		 @SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(f);
		 String text;
		 String dot="\\.";
		 
		 while((text=br.readLine())!=null)
		 {
			for(String retval: text.split(dot))
	         
			 System.out.println("Ip Address:"+retval);
	      
			
		
		 }}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
			 
		 
	 
	    }
	}