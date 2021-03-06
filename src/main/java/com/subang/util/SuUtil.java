package com.subang.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLEncoder;

import com.support.util.HttpConst;

/**
 * @author Qiang 与业务相关的公用函数
 */
public class SuUtil extends BaseUtil {

	// desPath 绝对路径
	public static void saveUrl(String url, String desPath) {
		try {
			BufferedInputStream in = new BufferedInputStream(new URL(urlEncode(url)).openStream());
			File file = new File(desPath);
			File parentFile = file.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			byte[] buf = new byte[2048];
			int length = in.read(buf);
			while (length != -1) {
				out.write(buf, 0, length);
				length = in.read(buf);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String urlEncode(String url) {
		int index = url.lastIndexOf('/') + 1;
		String url1 = url.substring(0, index);
		String url2 = url.substring(index, url.length());
		String url3 = null;
		try {
			url3 = URLEncoder.encode(url2, HttpConst.CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url1 + url3;
	}

	// desPath 绝对路径
	public static boolean fileExist(String path) {
		File file = new File(path);
		if (file.exists()) {
			return true;
		}
		return false;
	}

	public static void deleteFile(String path) {
		if (path != null) {
			File file = new File(path);
			file.delete();
		}
	}

	// 用户绑定手机号时，产生验证码
	public static String getAuthcode() {
		return ComUtil.getRandomStr(WebConst.AUTHCODE_LENGTH);
	}

	public static String getPromPath(String cellnum) {
		return WebConst.HOST_URI + "weixin/user/promote.html?cellnum=" + cellnum;
	}

	public static String getSharePath() {
		return WebConst.HOST_URI + "content/weixin/activity/share.htm";
	}
}
