#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscript;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ${package}.dataprovider.TestDataProvider;
import ${package}.helpers.WaitForElement;
import ${package}.pages.HomePage;
import ${package}.testBase.TestBase;

public class TestHomePage extends TestBase {
	HomePage homepageObject;

	@BeforeClass
	public void invokeBrowser() throws IOException {
		driver.get("https://www.atmecs.com/");
		driver.manage().window().maximize();
		WaitForElement waitObject = new WaitForElement();
		waitObject.waitForPageLoadTime(driver);
		waitObject.waitForImplicit(driver);
	}
	
	@Test(priority=1, dataProvider="headerData",dataProviderClass = TestDataProvider.class)
	public void validateHeader(String expectedHeaderName)
	{
		homepageObject=new HomePage(driver);
		homepageObject.validateHeaders(expectedHeaderName);
	}
	
}
