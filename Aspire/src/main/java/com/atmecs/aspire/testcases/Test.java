package com.atmecs.aspire.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://14.98.116.9/aspire_qa/login");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("employee@atmecs.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("atmecs@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Timesheet')]")).click();
		String flag = "False";

		while (flag == "False") {
			if (driver.findElements(By.xpath("//div[@class='ontimesubmit']/span[contains(text(),'Pending')]")).size() > 0) {
				flag = "True";
			} else {
				driver.findElement(By.xpath("//span[@class='fa fa-caret-right']")).click();
			}
		}

		Select activity = new Select(driver.findElement(By.xpath("//table[@id='table_0']/tbody/tr/td/select")));
		activity.selectByVisibleText("Internal Meeting");
		for (int i = 2; i < 7; i++) {
			driver.findElement(By.xpath("//tbody/tr[@id='tr_8']/td[" + i + "]/input[1]")).sendKeys("9:00");
		}
	}
}