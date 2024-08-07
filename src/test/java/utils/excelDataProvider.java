package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelDataProvider {
	
	@Test(dataProvider = "test1Data")
	public void test1(String username,String password){
		System.out.println(username + " | "+password);
	}
	
	@DataProvider(name = "test1Data")
	public Object[][] getTest1Data() {
		Object[][] data1 = testData( "C:\\Users\\lkaushal\\eclipse-workspace\\testngProject1\\Excel\\Data.xlsx", "Sheet1");
		return data1;
	}

	public Object[][] testData(String workbookpath, String sheetpath ) {
		excelData excel = new excelData(workbookpath,sheetpath);
		
		int rownum = excel.getRowCount();
		int colnum = excel.getColCount();
		
		System.out.println(rownum);
		System.out.println(colnum);
		
		Object[][] data = new Object[rownum-1][colnum];
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colnum;j++) {
				String cellData = excel.getRowDataString(i, j);
				data[i-1][j]=cellData;
			}
		}
		return data;

	}

}
