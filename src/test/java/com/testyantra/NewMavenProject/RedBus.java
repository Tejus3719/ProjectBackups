package com.testyantra.NewMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("https://www.redbus.com/");
		  driver.manage().window().maximize();
		  System.out.println(driver.getTitle());
		  
		  driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[4]/div[4]/div[2]")).click();
		  driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/main[1]/section[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("Mumbai");
		  Thread.sleep(10000);
		  WebElement webelement=driver.findElement(By.id("onward_cal"));
		  webelement.sendKeys("30-Aug-2019");
		  Thread.sleep(10000);
		  driver.close();
		  	
		
	}

}
