/** Add JUnit framework to your classpath if not already there
 *  for this example to work
 */
package com.example.tests;

import bsh.classpath.BshClassPath.AmbiguousName;




import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sun.jna.platform.win32.Netapi32Util.User;
import com.thoughtworks.selenium.*;

import java.util.jar.Attributes.Name;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.io.File.*;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.lang.Object;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import java.util.List;
import org.testng.annotations.*;
import org.testng.*;
import org.junit.Test;
@SuppressWarnings("deprecation")

public class SeleniumWebdriverTest{
	public static final String URL="http://www.google.com/";
	public static final String FIREFOX="*firefox";
	public static final String CHROME="*chrome";
	public static final String SAFARI="*safari"; 
	private static  String filePath="";
	public static File fileName;
	public boolean newFile;
	String curentDirectoty;
	public static Log log;
	public File file;
	public  static String screen;
	public static String targetDirectory ="/ScreenShots";
	public static String currentdir;
	public static String screenShotFolder;
	public static String targetPath;
	public static WebDriver driver;
	public static WebElement elemnet;
	public LogFactory LogFactory;
	
	@Test
	public void testNew() throws Exception 
	{
		WebDriver driver=new SafariDriver();
		driver.navigate().to(URL);
		elemnet=driver.findElement(By.name("q"));
		elemnet.click();
		screenShorts();
		elemnet.sendKeys("AnbarasanIT");
		elemnet=driver.findElement(By.name("btnG"));
		elemnet.click();
		screenShorts();
	}

	
	//Collection used 

	@Test
	public void testSecond() throws Exception
	{

		WebDriver driver = new SafariDriver();
		driver.get("http://www.google.com/webhp?complete=1&hl=en");
		WebElement query = driver.findElement(By.name("q"));
		query.sendKeys("Cheese");

		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
			if (resultsDiv.isDisplayed()) {
				break;
			}
		}
		// And now list the suggestions
		List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));

		for (WebElement suggestion : allSuggestions) {
			System.out.println(suggestion.getText());
		}
	}
	public static void windowMaxmaize() throws SeleniumException{
		System.out.println("-----*******ENTERING WINDOW MAXMAIZE***-----");
		driver.manage().window().maximize();

	}


	public static void  launchBrowser() throws Exception{
		log.info("------*******LAUNCHING BROWER****---------");
		WebDriver driver=new SafariDriver();
		driver.navigate().to(URL);
		windowMaxmaize();
	}

	public static void screenShorts()
			throws Exception{
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
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


