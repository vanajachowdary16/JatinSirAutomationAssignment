package com.ui.pojo;

public class Environment {
	private String url;
	private int  MAXIMUM_ATTEMPTS;
	
	
	public int getMAXIMUM_ATTEMPTS() {
		return MAXIMUM_ATTEMPTS;
	}

	public void setMAXIMUM_ATTEMPTS(int mAXIMUM_ATTEMPTS) {
		MAXIMUM_ATTEMPTS = mAXIMUM_ATTEMPTS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
