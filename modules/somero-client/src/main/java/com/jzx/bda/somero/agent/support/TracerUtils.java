package com.jzx.bda.somero.agent.support;

import com.alibaba.dubbo.common.utils.StringUtils;

public class TracerUtils {
	public static final String TID = "traceId";
	public static final String SID = "spanId";
	public static final String PID = "parentId";
	public static final String SAMPLE = "isSample";

	public static final String EXCEPTION = "dubbo.exception";

	public static Long getAttachmentLong(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		return Long.valueOf(value);
	}

	public static Boolean getAttachmentBoolean(String value) {
		if (value == null) {
			return false;
		}
		return Boolean.valueOf(value);
	}
}
