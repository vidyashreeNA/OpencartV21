package utilities;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	//DataProvider 1
	
	@DataProvider (name="LoginData")
	public String [] [] getData() throws Exception 
	{
		String path=".\\testdata\\Opencart_Testdata.xlsx";//taking excel file from testdata
		
		Excelutility xlutil=new Excelutility(path);//creating an object for xlutil
		
		int totalrows=xlutil.getRowCount("Sheet1");  //sheet name
		int totalcols=xlutil.getCellCount("Sheet1",1);   //sheet name and row number

		String logindata [] [] =new String[totalrows][totalcols];//created for 2 dimensional array which can store
		
		for(int i=1;i<=totalrows;i++)//1 //read the data from excel storing in 2 dimensional array
		{
			for(int j=0;j<totalcols;j++)// 0  //i is rows j is coloumn
			{
				logindata [i-1] [j]=xlutil.getCellData("Sheet1", i, j); //1,0 array starts from O so i-1
			}

		}
		
		return logindata;// returning 2 dimensional array
	}

}
