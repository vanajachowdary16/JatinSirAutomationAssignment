package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JsonUtility {
	
	public static String readJson(Env env)  {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config=gson.fromJson(fileReader, Config.class);
		System.out.println("Config parsed: " + config);
		System.out.println("Environments map: " + config.getEnvironments());
		Environment environment=config.getEnvironments().get("QA");
		System.out.println(environment.getUrl());
		return environment.getUrl();
	}
}
