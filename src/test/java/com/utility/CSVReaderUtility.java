package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + "//testdata//"+fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		User user;
		List<User> userList = new ArrayList<User>();
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();

			while ((line = csvReader.readNext()) != null) {
				user = new User(line[0], line[1]);
				userList.add(user);

			}
			/*for (User userData : userList) {
				System.out.println(userData);
			}*/
			//System.out.println(Arrays.toString(line));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();

	}

}
