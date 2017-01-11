package com.jzx.bda.somero.mysql.persistent.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.mysql.persistent.dao.SpanMapper;

public class SpanMapperImpl implements SpanMapper {

	private SqlSessionTemplate sqlSession;

	@Override
	public void addSpan(Span span) {
		sqlSession.insert("addSpan", span);
	}

	@Override
	public List<Span> findSpanByTraceId(Long traceId) {
		return sqlSession.selectList("findSpanByTraceId", traceId);
	}

	@Override
	public void deleteAllSpans() {
		sqlSession.delete("deleteAllSpan");
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
