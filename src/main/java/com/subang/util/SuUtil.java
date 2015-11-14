package com.subang.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLEncoder;

import com.support.client.HttpConst;

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

	// 用户绑定手机号时，产生验证码
	public static String getUserAuthcode() {
		StringBuffer authcode = new StringBuffer();
		for (int i = 0; i < WebConst.AUTHCODE_LENGTH; i++) {
			authcode.append(ComUtil.random.nextInt(10));
		}
		return authcode.toString();
	}

}
