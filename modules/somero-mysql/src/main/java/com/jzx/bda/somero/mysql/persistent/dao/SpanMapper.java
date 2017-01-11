package com.jzx.bda.somero.mysql.persistent.dao;

import java.util.List;

import com.jzx.bda.somero.Span;

public interface SpanMapper {
	public void addSpan(Span span);

	List<Span> findSpanByTraceId(Long traceId);

	// 测试用
	void deleteAllSpans();
}
