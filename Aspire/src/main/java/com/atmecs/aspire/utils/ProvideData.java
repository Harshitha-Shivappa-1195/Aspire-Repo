package com.atmecs.aspire.utils;

/**
 * The class receives the data from Excel File and stores it in the 2-D object array.
 *
 */

public class ProvideData {
	Object[][] object;
 //   ReadExcelFile provider;
    ReadExcelData provider;
    /**
     * Constructor used for loading of the file
     * @param filepath
     */
    public ProvideData(String filepath ) {
	//	provider = new ReadExcelFile(filepath);
    	provider = new ReadExcelData(filepath);
	}
    
    /**
	 * methods takes parameter as
	 * @param excelSheetIndex
	 * @return the object array containing the cell data
	 */
    public Object[][] testData(String excelSheetName) {
		int rowNo= 1;
		int rowCount = provider.getRowCount(excelSheetName);
		int colCount = provider.getColumnCount(excelSheetName, rowNo);

		Object[][] data = new Object[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++) {
				data[rowIndex][colIndex] = provider.getData(excelSheetName, rowIndex+1, colIndex);
			}
		}
		return data;
	}
}
