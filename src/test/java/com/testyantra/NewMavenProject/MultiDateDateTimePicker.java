package com.testyantra.NewMavenProject;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiDateDateTimePicker {

	private String demosite = "https://www.redbus.com/";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void startTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(demosite);
	}

	@Test
	public void jQueryCalendarMultipleMonths() throws InterruptedException {

		driver.navigate().to(demosite);

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[4]/div[4]/div[2]")).click();
		  driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Mumbai");
		  Thread.sleep(2000);
		
		WebElement calElement = driver.findElement(By.xpath("//label[@class='db text-trans-uc tal']"));
		calElement.click();

		// Provide the day of the month to select the date.
		SelectDayFromMultiDateCalendar("28");
	}

	// Function to select the day of month in the date picker.
	public void SelectDayFromMultiDateCalendar(String day)
			throws InterruptedException {

		// We are using a special XPath style to select the day of current
		// month.
		// It will ignore the previous or next month day and pick the correct
		// one.
		By calendarXpath = By.xpath("//td[not(contains(@class,'db text-trans-uc move-up'))]/a[text()='"+ day + "']");
		driver.findElement(calendarXpath).click();

		// Intentional pause for 2 seconds.
		Thread.sleep(2000);
	}

	@AfterTest
	public void endTest() {
		driver.quit();
	}
}