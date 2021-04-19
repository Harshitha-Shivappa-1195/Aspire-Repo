package com.atmecs.aspire.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.atmecs.aspire.constants.FileConstant;
import com.atmecs.aspire.helpers.CommonUtility;
import com.atmecs.aspire.utils.ReadPropertiesFile;

public class TestCaseOne {
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
	
	public void applyTimesheet() {
		String flag = "False";
		while (flag.equals("False")) {
			if (commonUtility.getElementCount(locators.getProperty("loc_pending")) > 0) {
				flag = "True";
			} else {
				commonUtility.clickTheElement(locators.getProperty("loc_navigate"));
			}
		}
		for (int i = 2; i < 7; i++) {
			String s = String.valueOf(i);
			commonUtility.clickAndSendText("9:00", locators.getProperty("loc_hours").replace("xxxx", s));
		}
		
	}

}
