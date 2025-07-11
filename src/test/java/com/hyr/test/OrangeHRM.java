package com.hyr.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void LaunchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		wait = new WebDriverWait(driver, 10);
		
	}
	
	@Test
	public void LoginDetails() {
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit' ]")).click();
	}
	
	@Test
	public void NavigateToMyInfo() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Info']"))).click();
		//driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}
	
	@Test
	public void VerifyMyInfo() {
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='oxd-form' and @data-v-d5bfe35b and @data-v-6653c066]"))).isDisplayed());
		//System.out.println(driver.findElement(By.xpath("//form[@class='oxd-form' and @data-v-d5bfe35b and @data-v-6653c066]")).isDisplayed());
	}
	
	@Test
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		driver.quit();
	}

}
