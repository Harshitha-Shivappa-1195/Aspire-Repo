package com.atmecs.aspire.testscript;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.aspire.dataprovider.TestDataProvider;
import com.atmecs.aspire.helpers.WaitForElement;
import com.atmecs.aspire.testBase.TestBase;
import com.atmecs.aspire.testcases.TestCaseOne;

public class TestAspire extends TestBase {
	TestCaseOne testcaseOne;

	@BeforeClass
	public void invokeBrowser() throws IOException {
		driver.get("http://14.98.116.9/aspire_qa/login");
		driver.manage().window().maximize();
		WaitForElement waitObject = new WaitForElement();
		waitObject.waitForPageLoadTime(driver);
		waitObject.waitForImplicit(driver);
		testcaseOne=new TestCaseOne(driver);
	}
	
	@Test(priority=0, dataProvider="headerData",dataProviderClass = TestDataProvider.class)
	public void loginEmployee(String locator, String testData)
	{
		testcaseOne.loginEmployee(locator, testData);
	}
	
	@Test(priority=1)
	public void timeSheet() {
		testcaseOne.applyTimesheet();
	} 
}
