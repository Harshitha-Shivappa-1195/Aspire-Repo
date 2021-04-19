#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dataprovider;

import org.testng.annotations.DataProvider;

import ${package}.constants.FileConstant;
import ${package}.utils.ProvideData;

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
