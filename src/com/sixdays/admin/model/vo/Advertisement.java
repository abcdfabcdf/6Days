package com.sixdays.admin.model.vo;

import java.sql.Date;

public class Advertisement {
	private String adimg;
	
	public Advertisement() {
		super();
	}
	

	public Advertisement(String adimg) {
		super();
		this.adimg = adimg;
	}


	public String getAdimg() {
		return adimg;
	}

	public void setAdimg(String adimg) {
		this.adimg = adimg;
	}

	@Override
	public String toString() {
		return "Advertisement [adimg=" + adimg + "]";
	}



	

	
	
	
}
