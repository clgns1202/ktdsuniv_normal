package com.ktdsuniv.normalpage.room.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.normalpage.room.service.impl.SeatServiceImpl;

@Controller
public class SeatController {

	private SeatServiceImpl seatService;

	public void setSeatService(SeatServiceImpl seatService) {
		this.seatService = seatService;
	}

}
