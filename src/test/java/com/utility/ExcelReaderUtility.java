package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;


public class ExcelReaderUtility {
	public static Iterator<User> readExcelFileData(String fileName) {
		
		File xlsxFile = new File(System.getProperty("user.dir")+"//testdata//"+fileName);
		List<User> userList= new ArrayList<User>();
		User user;
		//xlsx file -->XSSFWorkBook
		Cell emailAddressCell;
		Cell passwordCell;
		Row row;
		XSSFWorkbook xssfworkbook;
		XSSFSheet xsssfSheet;
		try {
			xssfworkbook = new XSSFWorkbook(xlsxFile);
			xsssfSheet = xssfworkbook.getSheet("loginData");			
			Iterator<Row> rowIterator = xsssfSheet.iterator();
			rowIterator.next();
			while(rowIterator.hasNext()) {
				 row=rowIterator.next();
				emailAddressCell=row.getCell(0);
				passwordCell=row.getCell(1);
				System.out.println(emailAddressCell.toString());
				System.out.println(passwordCell.toString());
				user= new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
			}
			xssfworkbook.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();	}

}
