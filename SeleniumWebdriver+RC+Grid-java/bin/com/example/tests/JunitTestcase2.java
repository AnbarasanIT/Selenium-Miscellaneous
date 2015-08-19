package com.anbj.test.java;
import org.junit.Test;
import junit.framework.TestCase;
public class JunitTestcase2 extends TestCase {
	@Test
	public void testReverseString(){
		 StringRecursiveReversal srr = new StringRecursiveReversal();
		 assertTrue(srr.reverseString("junit").contains("tinuj"));
		 MyPrimeNumCheck prime =new MyPrimeNumCheck();
		 assertTrue(prime.isPrimeNumber(2));
	}
	@Test
	public void testPrimeNumber(){
		 MyPrimeNumCheck prime =new MyPrimeNumCheck();
		 assertTrue(prime.isPrimeNumber(2));
	}
	
}
