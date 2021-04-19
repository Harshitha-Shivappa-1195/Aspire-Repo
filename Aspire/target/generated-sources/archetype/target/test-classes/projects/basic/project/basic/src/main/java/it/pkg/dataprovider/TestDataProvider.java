package it.pkg.dataprovider;

import org.testng.annotations.DataProvider;

import it.pkg.constants.FileConstant;
import it.pkg.utils.ProvideData;

/**
 * The class is used for creating the data provider for receiving the value of excel file
 */

public class TestDataProvider {
	@DataProvider(name = "headerData")
	public Object[][] testData() {
		ProvideData provideData = new ProvideData(FileConstant.TESTDATA_FILE);
		Object[][] getData = provideData.testData(0);
		return getData;
	}
}
