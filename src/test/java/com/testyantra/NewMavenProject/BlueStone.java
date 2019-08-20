package com.testyantra.NewMavenProject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import multiScreenShot.MultiScreenShot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class BlueStone {
	
	@Test
    public void TakeScreenShot() throws Exception{
		
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 MultiScreenShot mShot=new MultiScreenShot("/home/tyss/eclipse-workspace","TestMultiScreenShot");
    	driver.get("https://www.bluestone.com/");
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//a[contains(text(),'Visit Our Stores')]")).click();
//    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
    	Thread.sleep(15000);
    	mShot.multiScreenShot(driver);
    	WebElement ele=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"));
    	mShot.multiScreenShot(driver);
    	
    	
//    	mShot.multiScreenShot(driver);
//    	WebElement ele=driver.findElement(By.xpath("//*[@id='usernameId']"));
    	
}
}