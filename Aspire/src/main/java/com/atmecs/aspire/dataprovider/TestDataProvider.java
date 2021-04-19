package com.atmecs.aspire.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.aspire.constants.FileConstant;
import com.atmecs.aspire.utils.ProvideData;

/**
 * The class is used for creating the data provider for receiving the value of excel file
 */

public class TestDataProvider {
	@DataProvider(name = "headerData")
	public Object[][] testData() {
		ProvideData provideData = new ProvideData(FileConstant.TESTDATA_FILE);
		Object[][] getData = provideData.testData("Sheet1");
		return getData;
	}
}
