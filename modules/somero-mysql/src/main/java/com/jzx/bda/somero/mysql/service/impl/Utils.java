package com.jzx.bda.somero.mysql.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jzx.bda.somero.Annotation;
import com.jzx.bda.somero.Span;

public class Utils {

	public static boolean isTopAnntation(Span span) {
		List<Annotation> alist = span.getAnnotations();
		boolean isfirst = false;
		for (Annotation a : alist) {
			if (StringUtils.endsWithIgnoreCase("cs", a.getValue())) {
				isfirst = true;
			}
		}
		return isfirst;
	}

	public static Annotation getCsAnnotation(List<Annotation> alist) {
		for (Annotation a : alist) {
			if (StringUtils.endsWithIgnoreCase("cs", a.getValue())) {
				return a;
			}
		}
		return null;
	}

	public static Annotation getCrAnnotation(List<Annotation> alist) {
		for (Annotation a : alist) {
			if (StringUtils.endsWithIgnoreCase("cr", a.getValue())) {
				return a;
			}
		}
		return null;
	}

	public static boolean isRoot(Span span) {
		return span.getParentId() == null;
	}
}
