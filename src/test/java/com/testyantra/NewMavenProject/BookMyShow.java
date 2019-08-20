package com.testyantra.NewMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {
	
	public static void main(String[] args) throws InterruptedException {
		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("http://www.bookmyshow.com/");
		  driver.manage().window().maximize();
		  System.out.println(driver.getTitle());
		  driver.findElement(By.linkText("Bengaluru")).click();
		  System.out.println(driver.getTitle());
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//h4[@class='title'][contains(text(),'Kurukshetra (Kannada)')]")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]")).click();
		  driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/a[2]")).click();
		  driver.quit();
		  
		 }
}