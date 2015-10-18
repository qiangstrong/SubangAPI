package com.subang.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * @author Qiang 与业务相关的公用函数
 */
public class SuUtil extends BaseUtil {

	// desPath 绝对路径
	public static void saveUrl(String url, String desPath) {
		try {
			BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
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

}
