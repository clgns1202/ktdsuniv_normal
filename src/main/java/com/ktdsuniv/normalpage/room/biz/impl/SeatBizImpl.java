package com.ktdsuniv.normalpage.room.biz.impl;

import com.ktdsuniv.normalpage.room.biz.SeatBiz;
import com.ktdsuniv.normalpage.room.dao.SeatDao;

public class SeatBizImpl implements SeatBiz {

	private SeatDao seatDao;
	
	public void setSeatDao(SeatDao seatDao) {
		this.seatDao = seatDao;
	}
	
}
