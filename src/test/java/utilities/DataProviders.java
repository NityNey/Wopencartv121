package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name= "LoginData")
	public String [][] getData() throws IOException{
		
		String path = ".//testdata//OpenCart.xlsx";// taking xl file from testdata,.// represent the current project location
		
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility
		
		int totalrows = xlutil.getRowCount("sheet1");
		
		int totalcols = xlutil.getCellCount("sheet1", 1);

		String logindata[][]= new String[totalrows][totalcols];
		
		for (int i=1; i<=totalrows; i++) //read the data from xl storing into two dimension array
		{
			
			for(int j=0; j<totalcols; j++) // i row, j cols
			{
			
			logindata [i-1][j]=  xlutil.getCellData("sheet1", i, j);
			
		}
					
	}
		return logindata;//  // returning two dimension array
		
	}


}
