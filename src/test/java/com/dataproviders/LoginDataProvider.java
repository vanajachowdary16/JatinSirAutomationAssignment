package com.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	
	
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		try {
			FileReader fileReader= new FileReader(testDataFile);
			TestData data=gson.fromJson(fileReader, TestData.class);
			
			
			for(User user : data.getData()) {
				dataToReturn.add(new Object[] {user});
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataToReturn.iterator();
		
	}
	
	@DataProvider(name ="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
		
	}
	@DataProvider(name ="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFileData("loginData.xlsx");
		
	}

}
