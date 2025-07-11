package com.hyr.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	@Test
	public void TestGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.topjobs.lk/");
		//driver.findElement(By.name("q")).sendKeys("cats", Keys.ENTER);
		String expectedTitle = "topjobs - Sri Lanka Job Network - jobs/vacancies, careers and employment";
		String actualTitle = driver.getTitle();
		//System.out.println(driver.getTitle());
		assertEquals(actualTitle,expectedTitle,"Title is mismatched");
		assertTrue(true);
		
		Thread.sleep(10);
		driver.quit();
	}
	
	@Test
	public void TestFacebook() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("HYR Tutorials", Keys.ENTER);
		Thread.sleep(10);
		
		SoftAssert softAssert = new SoftAssert();
		
		//Title Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook";
		softAssert.assertEquals(actualTitle,expectedTitle,"Title is missedmathced");
		
		
		
		
		
		System.out.println(driver.getTitle());
		driver.quit();
		softAssert.assertAll();
	}

}
