package com.example.tests;

import java.util.Vector;


import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import com.example.tests.TestData1;

public class AdvancedSearch extends SeleneseTestBase {

	private static SeleniumServer seleniumServer;
	public static Vector  paramData=new Vector();
	public static Vector  testMethod=new Vector();

	TestData1 td = new TestData1("D:\\XLTestData.xlsx");
	@Before
	public void setUp() throws Exception {
	td.getDatafromXL();
	paramData=td.getParamData();
	testMethod=td.getTestMethods();
	selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.co.in/");
        seleniumServer = new SeleniumServer();
        seleniumServer.start();
		selenium.start();
	}

	@Test
	public void testAdvancedSearch() throws Exception {
		//selenium.open(paramData.get(0));
		selenium.click("link=Advanced search");
		selenium.waitForPageToLoad("30000");
		//selenium.type("as_q", paramData.get(1));
		selenium.select("num", "label=20 results");
		selenium.click("//input[@value='Advanced Search']");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
		seleniumServer.stop();
	}
}
