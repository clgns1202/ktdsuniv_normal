package com.ktdsuniv.normalpage.attendance.vo;

import java.util.ArrayList;
import java.util.List;

public class CheckTime{
	private List<String> checkTime;

	public List<String> getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(List<String> checkTime2) {
		checkTime = new ArrayList<String>();
		checkTime = checkTime2;
	}
}	