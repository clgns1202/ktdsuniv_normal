package com.ktdsuniv.normalpage.room.service.impl;

import com.ktdsuniv.normalpage.room.biz.SeatBiz;
import com.ktdsuniv.normalpage.room.service.SeatService;

public class SeatServiceImpl implements SeatService {

	private SeatBiz seatBiz;
	
	public void setSeatBiz(SeatBiz seatBiz) {
		this.seatBiz = seatBiz;
	}
	
}
