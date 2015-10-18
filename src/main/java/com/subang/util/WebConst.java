package com.subang.util;

public interface WebConst {

	int USER = 0;
	int WORKER = 1;
	int OTHER = 2;

	int SEARCH_NULL = 0;
	int SEARCH_ALL = 1;
	int SEARCH_NAME = 2; // 按用户昵称，商家名称等进行搜索
	int SEARCH_CELLNUM = 3;
	int SEARCH_AREA = 4;
	int SEARCH_INCOMPLETE = 5;

	int SEARCH_ORDER_STATE = 2;
	int SEARCH_ORDER_ORDERNO = 3;
	int SEARCH_ORDER_USER_NICKNAME = 4;
	int SEARCH_ORDER_USER_CELLNUM = 5;
	int SEARCH_ORDER_LAUNDRY_NAME = 6;
	int SEARCH_ORDER_USERID = 7;
	int SEARCH_ORDER_WORKERID = 8;
	int SEARCH_ORDER_LAUNDRYID = 9;

	int STAT_NULL = 0;
	int STAT_AREA = 1;
	int STAT_USER = 2;

	int STAT_AREA_ORDER = 0;
	int STAT_AREA_USER = 1;

	int STAT_USER_ORDER = 0;
	int STAT_USER_PRICE = 1;

	int AREA_CITY = 0;
	int AREA_DISTRICT = 1;
	int AREA_REGION = 2;

	// 前台部分
	int ORDER_STATE_UNDONE = 2;
	int ORDER_STATE_DONE = 3;

	int ORDER_STATE_WORKER = 1;
	int ORDER_STATE_FETCH = 2;
	int ORDER_STATE_DELIVER = 3;

	int EXPIRED_INTERVAL = 60; // 重复通知过滤 时效60秒
}
