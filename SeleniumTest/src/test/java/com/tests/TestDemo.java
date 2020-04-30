package com.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDemo {

	@Test
	public void scrollUpAndDown() {
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		driver = new ChromeDriver();
		Dimension d = new Dimension(300,700);
		driver.manage().window().setSize(d);
		
		driver.get("https://www.amazon.in/");
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		 js.executeScript("window.scrollBy(1000,0)");
		 driver.quit();
	}
}
