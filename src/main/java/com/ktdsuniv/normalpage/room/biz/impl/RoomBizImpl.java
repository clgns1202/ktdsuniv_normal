package com.ktdsuniv.normalpage.room.biz.impl;

import com.ktdsuniv.normalpage.room.biz.RoomBiz;
import com.ktdsuniv.normalpage.room.dao.RoomDao;

public class RoomBizImpl implements RoomBiz {

	private RoomDao roomDao;

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

}
