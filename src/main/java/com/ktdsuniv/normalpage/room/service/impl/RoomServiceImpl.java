package com.ktdsuniv.normalpage.room.service.impl;

import com.ktdsuniv.normalpage.room.biz.RoomBiz;
import com.ktdsuniv.normalpage.room.service.RoomService;

public class RoomServiceImpl implements RoomService {

	private RoomBiz roomBiz;

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}
	
	
}
