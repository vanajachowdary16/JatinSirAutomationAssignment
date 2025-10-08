package com.ui.listeners;

import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.PropertiesUtil;

public class RetryAnalyzer implements IRetryAnalyzer{
	//private static final int max_no_of_attempts=Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAXIMUM_ATTEMPTS"));
	private static final int max_no_of_attempts=JsonUtility.readJson(Env.QA).getMAXIMUM_ATTEMPTS();

	private static int currentAttempt=1;
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=max_no_of_attempts) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
