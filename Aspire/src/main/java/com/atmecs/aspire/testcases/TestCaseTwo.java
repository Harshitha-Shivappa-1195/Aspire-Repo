package com.atmecs.aspire.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.atmecs.aspire.constants.FileConstant;
import com.atmecs.aspire.helpers.CommonUtility;
import com.atmecs.aspire.utils.ReadPropertiesFile;

public class TestCaseTwo{
	Properties locators;
	CommonUtility commonUtility;

	public TestCaseOne(WebDriver driver) {
		try {
			locators = ReadPropertiesFile.loadProperty(FileConstant.lOCATORS_FILE);
			commonUtility = new CommonUtility(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loginEmployee(String locator, String testData) {
		if(locator.contains("submit")) {
			commonUtility.clickTheElement(locators.getProperty("loc_input_name").replace("[xxxx]", locator));
			commonUtility.clickTheElement(locators.getProperty("loc_timesheet").replace("[xxxx]", testData));
		}
		else
			commonUtility.clickAndSendText(testData, locators.getProperty("loc_input_name").replace("[xxxx]", locator));
	}
}
