package com.jzx.bda.somero.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtils {

	/**
	 * 对象格式化成byte数据
	 * @param list
	 * @return
	 */
	public static byte[] toPBBytes(List list) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 构造一个字节输出流
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(list); // 写这个对象
			byte[] buf = baos.toByteArray(); // 从这个地层字节流中把传输的数组给一个新的数组
			oos.flush();
			return buf;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List parsePBBytes(byte[] bytes) {
		try {
			// 构建一个类输入流，地层用字节输入流实现
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			String str = (String) ois.readObject();
			ArrayList msgList = (ArrayList) ois.readObject(); // 读取类
			return msgList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
