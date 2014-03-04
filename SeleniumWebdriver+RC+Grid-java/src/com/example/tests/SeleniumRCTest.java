/** Add JUnit framework to your classpath if not already there
 *  for this example to work
 */
package com.example.tests;

import bsh.classpath.BshClassPath.AmbiguousName;
import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

import com.sun.jna.platform.win32.Netapi32Util.User;
import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

import mx4j.log.Log;

import java.io.File;
import java.io.IOException;
import java.io.File.*;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.condition.*;
import java.lang.Object;
import org.apache.commons.io.FileUtils;
@SuppressWarnings("deprecation")

public class SeleniumRCTest extends SeleneseTestCase{
	public static final String URL="http://www.google.com/";
	public static final String FIREFOX="*firefox";
	public static final String CHROME="*chrome";
	public static final String SAFARI="*safari"; 
	private static  String filePath="";
	public static File fileName;
	public boolean newFile;
	String curentDirectoty;
	public Log log;
	public File file;
	public  static String screen;

	public static String targetDirectory ="/ScreenShots";
	public static String currentdir;
	public static String screenShotFolder;

	public static String targetPath;


	public void setUp() throws Exception {
		setUp(URL,FIREFOX);

	}
	public void testNew() throws Exception {
		windowMaxmaize();
		selenium.open("/");
		selenium.type("q", "selenium rc");
		selenium.click("btnG");
		screenShorts();
		
	}
	public void windowMaxmaize() throws SeleniumException{
		System.out.println("-----*******ENTERING WINDOW MAXMAIZE***-----");
		selenium.windowMaximize();

	}


	
	public void screenShorts()
                     throws Exception{
	    screen=selenium.captureEntirePageScreenshotToString(getName());
	    String scrFile=screen;
	   String currentDir=getCurrentDirectory();
		try {
			
			FileUtils.copyFile(scrFile,
					new File(currentDir + "/" + ".png"));
		
		} catch (Exception e1) {
			System.out.println("failureTestMethod" + e1.getMessage());
		}
		
	}

	public static String getCurrentDirectory() throws Exception {
		currentdir = System.getProperty("user.dir");
		screenShotFolder = currentdir + targetDirectory;
		fileName = new File(screenShotFolder);
		if(fileName.exists()){
			System.out.println("folder structure "+fileName+"exists");	
		}else{
			fileName.mkdir();
			System.out.println("folder structure "+fileName+"created");
		}
		targetPath = fileName.getAbsolutePath();
		return targetPath;
	}}
