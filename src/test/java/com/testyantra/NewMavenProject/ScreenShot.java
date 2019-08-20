package com.testyantra.NewMavenProject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class ScreenShot {
	
	@Test
    public void TakeScreenShot() throws Exception{
		
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  	
    	driver.get("https://www.bluestone.com/");
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//a[contains(text(),'Visit Our Stores')]")).click();
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
    	Thread.sleep(15000);
    	String parentHandle = driver.getWindowHandle();
    	
    	for (String winHandle : driver.getWindowHandles()) {
    	    driver.switchTo().window(winHandle);
    	}
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("\\home\\tyss\\Desktop\\Selenium1\\SS\\screenshot2.png"));
    	driver.close();
    	driver.switchTo().window(parentHandle);
    	
    	Thread.sleep(15000);
    	
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
    	Thread.sleep(10000);
    	for (String winHandle : driver.getWindowHandles()) {
    	    driver.switchTo().window(winHandle);
    	}
    	
    	File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile2, new File("\\home\\tyss\\Desktop\\Selenium1\\SS\\screenshot3.png"));
    	
//    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//       FileUtils.copyFile(scrFile, new File(".\\Screenshots\\Mads_screenshot.png"));
         driver.quit();
     }
    	
}
//WebElement webElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/a[1]"));
//Screenshot screenshot = new AShot().takeScreenshot(driver,webElement);
//ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"\\ErrorScreenshots\\ElementScreenshot.png"));
//Thread.sleep(2000);
//driver.quit();

