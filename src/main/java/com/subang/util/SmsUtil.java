package com.subang.util;

import java.util.HashMap;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.subang.bean.OrderDetail;

public class SmsUtil extends BaseUtil {

	public interface SmsType {
		String authcode = "templateId_authcode";
		String accept = "templateId_accept";
		String cancel = "templateId_cancel";
	}

	private static String STATUS_SUCC = "000000";
	private static CCPRestSmsSDK restAPI;

	public static void init() {
		restAPI = new CCPRestSmsSDK();
		restAPI.init(AppConst.serverIP_sms, AppConst.serverPort_sms);
		restAPI.setAccount(AppConst.accountSid_sms, AppConst.accountToken_sms);
		restAPI.setAppId(AppConst.appId_sms);
	}

	public static boolean send(String cellnum, String templateId, String[] content) {
		HashMap<String, Object> result = restAPI.sendTemplateSMS(cellnum, templateId, content);
		if (result.get("statusCode").equals(STATUS_SUCC)) {
			return true;
		}
		return false;
	}

	public static String[] toWorkerContent(OrderDetail orderDetail) {
		String[] content = new String[5];
		content[0] = orderDetail.getOrderno();
		content[1] = orderDetail.getAddrname();
		content[2] = orderDetail.getDateDes() + " " + orderDetail.getTimeDes();
		content[3] = orderDetail.getCityname() + "," + orderDetail.getDistrictname() + ","
				+ orderDetail.getRegionname() + "," + orderDetail.getAddrdetail();
		content[4] = orderDetail.getAddrcellnum();
		return content;
	}

	public static String[] toUserContent(String authcode) {
		return new String[] { authcode };
	}
}
