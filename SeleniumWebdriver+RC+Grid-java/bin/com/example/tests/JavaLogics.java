package com.anbj.test.java;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.test.java.controller.ContextManager;
import com.test.java.controller.Logging;
import com.test.java.driver.web.ScreenShot;
import com.test.java.driver.web.WebUXDriver;
import com.test.java.exception.WebSessionTerminatedException;
import com.test.java.helper.URLHelper;

public class JavaLogics {

	/**
	 * @author Anbarasan J
	 * <p> This method applicable for capturing the full page screenshots by Scrolling the browser
  		if page do not have the scroll option it will return the current page screenshots</p>
	 * @param messagePrefix
	 */
	public static void capturefullPageSnapshot(String messagePrefix) {
		if (ContextManager.getThreadContext() != null
				&& ContextManager.getThreadContext().isCaptureSnapshot()
				&& getOutputDirectory() != null) {
			String filename = URLHelper.getRandomHashCode("HtmlElement");
			StringBuffer sbMessage = new StringBuffer();
			try {
				byte[] byteArray = makeFullScreenshot(WebUXDriver.getWebDriver());;// KEEPME
				if (byteArray != null && byteArray.length > 0) {
					String imgFile = "/screenshots/" + filename + ".png";
					writeImage(getOutputDirectory() + imgFile,
							byteArray);
					ScreenShot screenShot = new ScreenShot();
					String imagePath = getSuiteName() + imgFile;
					screenShot.setImagePath(imagePath);
					ContextManager.getThreadContext().addScreenShot(screenShot);
					sbMessage.append(messagePrefix + ": <a href='" + imagePath
							+ "' class='lightbox'>screenshot</a>");
					Logging.logWebOutput(null, sbMessage.toString(), false);
					Logging.logScreenshot(screenShot); 
					sbMessage = null;
				}
			}catch(WebSessionTerminatedException ex){
				throw ex;
			}
			catch (Throwable e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @author Anbarasan J
	 * <p>This method applicable for capturing the screenshots by scrolling and adding it to existing image and returns an ByteArray Image</p>
	 * @throws AWTException 
	 */
	public static byte[] makeFullScreenshot(WebDriver driver) throws IOException, InterruptedException, AWTException {
		ByteArrayOutputStream baos= new ByteArrayOutputStream();
		byte[] bytes = ((org.openqa.selenium.TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
		int capturedWidth = image.getWidth();
		int capturedHeight = image.getHeight();
		long longScrollHeight = (Long)((org.openqa.selenium.JavascriptExecutor)driver).executeScript("return Math.max(" + 
				"document.body.scrollHeight, document.documentElement.scrollHeight," +
				"document.body.offsetHeight, document.documentElement.offsetHeight," +
				"document.body.clientHeight, document.documentElement.clientHeight);"
				);

		int scrollHeight = (int)longScrollHeight;
		if (Math.abs(capturedHeight - scrollHeight) > 40) {
			int scrollOffset = capturedHeight;

			int times = scrollHeight / capturedHeight;
			int leftover = scrollHeight % capturedHeight;

			BufferedImage tiledImage = new BufferedImage(capturedWidth, scrollHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2dTile = tiledImage.createGraphics();
			g2dTile.drawImage(image, 0,0, null);
			int scroll = 0;
			for (int i = 0; i < times - 1; i++) {
				scroll += scrollOffset;
				scrollVerticallyTo(driver, scroll);
				Thread.sleep(100);
				BufferedImage nextImage = ImageIO.read(new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
				g2dTile.drawImage(nextImage, 0, (i+1) * capturedHeight, null);
			}
			if (leftover > 0) {
				scroll += scrollOffset;
				scrollVerticallyTo(driver, scroll);
				BufferedImage nextImage = ImageIO.read(new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
				BufferedImage lastPart = nextImage.getSubimage(0, nextImage.getHeight() - leftover, nextImage.getWidth(), leftover);
				g2dTile.drawImage(lastPart, 0, scrollHeight - leftover, null);
			}
			scrollVerticallyTo(driver, 0);
			BufferedImage buff = printScreen();
			ImageIO.write(tiledImage, "png", baos);
			//ImageIO.write(buff, "png", baos);
			byte[] imageInByte = baos.toByteArray();
			return imageInByte;
		} 
		else {
			ImageIO.write(image, "png", baos);
			byte[] imageInByte = baos.toByteArray();
			return imageInByte;
		}
	}
	public static void scrollVerticallyTo(org.openqa.selenium.WebDriver driver, int scroll) {
		((org.openqa.selenium.JavascriptExecutor)driver).executeScript("window.scrollTo(0, " + scroll + ");");
	}

	/**
	 * Creates Image from bytes and stores it
	 * @param path
	 * @param screenShot
	 */
	public static synchronized void writeImage(String path, byte[] byteArray) {
		if (byteArray.length == 0)
			return;
		System.gc(); // KEEPME

		InputStream in = null;
		FileOutputStream fos = null;
		try {
			File parentDir = new File(path).getParentFile();
			if (!parentDir.exists())
				parentDir.mkdirs();
			in = new ByteArrayInputStream(byteArray);
			BufferedImage img = ImageIO.read(in);
			fos = new FileOutputStream(path);
			ImageIO.write(img, "png", fos);
			img = null;
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
		}
	}
	/**
	 * @author Anbarasan J
	 *<p> This method which captures the current screen using Print Screen option</p>
	 * @return
	 * @throws IOException
	 * @throws AWTException
	 */
	public static BufferedImage printScreen() throws IOException, AWTException{
		// Determine current screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension oScreenSize = toolkit.getScreenSize();
		Rectangle oScreen = new Rectangle(oScreenSize);

		// Create screen shot
		Robot robot = new Robot();
		BufferedImage oImage = robot.createScreenCapture(oScreen);
		return oImage;

	}

}
