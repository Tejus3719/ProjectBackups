package com.testyantra.NewMavenProject;

import java.util.List;
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
		  driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Mumbai");
		  Thread.sleep(10000);
		  //Clicking Onward calender icon
		  driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		  //Selecting the Date in date picker
		  List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
			for(WebElement ele:allDates)
			{
				String date=ele.getText();	
				if(date.equalsIgnoreCase("28"))
				{
					ele.click();
					break;
				}
			}
			//Clicking Return calendar icon
			driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-return-calendar icon']")).click();
			//Selecting the Date in Date picker
			List<WebElement> allDates1=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
			for(WebElement ele:allDates1)
			{
				String date=ele.getText();	
				if(date.equalsIgnoreCase("30"))
				{
					ele.click();
					break;
				}
			}
		  Thread.sleep(10000);
		  driver.findElement(By.id("search_btn")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//li[@id='12330061']//div[@class='button view-seats fr'][contains(text(),'View Seats')]")).click();	
	}

}