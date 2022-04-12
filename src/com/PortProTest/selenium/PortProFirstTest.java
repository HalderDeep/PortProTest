package com.PortProTest.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PortProFirstTest {
	public static void main(String[] args) throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/driver/chromedriver");

		//System.setProperty("webdriver.chrome.driver", "/Users/deephalder/Documents/Driver/chromedriver");
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("Starting test and Launching App");
		// Launching the Webpage
		driver.get("https://staging.app.portpro.io/");

		// Signing in-----------
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testport14@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[text()='Sign In ']")).click();
		Thread.sleep(3000);

		// Opening Dispatcher
		driver.findElement(By.xpath("//i[@class='uil uil-monitor']")).click();
		Thread.sleep(4000);

		// Add new Load Page
		driver.findElement(By.xpath("//button[@class='btn btn-success' and text()='Add New Load']")).click();

		// Selecting From Customer Dropdown
		driver.findElement(By.xpath("//label[text()=' Customer']/following-sibling::div")).click();
		List<WebElement> Cust = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		Cust.get(0).click();
		Thread.sleep(1000);

		// Selecting From Port Dropdown

		driver.findElement(By.xpath("//label[text()='Port']/following-sibling::div")).click();
		List<WebElement> Roles = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		Roles.get(0).click();
		Thread.sleep(1000);

		// Selecting From Consignee Dropdown
		driver.findElement(By.xpath("//label[text()='Consignee']/following-sibling::div")).click();
		List<WebElement> Consignees = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		Consignees.get(0).click();
		Thread.sleep(2000);

		// Clicking Create Load--------------------
		driver.findElement(By.xpath("//button[text()='Create Load']")).click();
		Thread.sleep(2000);
		System.out.println("Load Created");
		Thread.sleep(3000);

		// Load Created------------------------------------
		driver.quit();

		// Test Completed
		System.out.println("Test Completed");
		System.out.println("END");

	}
}
