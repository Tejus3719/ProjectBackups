package com.testyantra.NewMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {
	
	public static void main(String[] args) {
		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("http://www.bookmyshow.com/");
		  driver.manage().window().maximize();
		  System.out.println(driver.getTitle());
		  driver.findElement(By.linkText("Bengaluru")).click();
		  driver.findElement(By.linkText("Kurukshetra (Kannada)")).click();
//		  driver.findElement(By.xpath("//h4[@class='title'][contains(text(),'Kurukshetra (Kannada)')]")).click();
		  driver.quit();
		 }
}