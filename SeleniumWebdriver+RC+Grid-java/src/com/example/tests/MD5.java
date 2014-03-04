package com.java.practice.run;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	  public static void main(String args[]) throws NoSuchAlgorithmException {
	
		  String password = "A18dec90";

		    MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(password.getBytes());

		    byte byteData[] = md.digest();

		    StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < byteData.length; i++)
		        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

		    System.out.println("Digest(in hex format):: " + sb.toString());

	}
}
