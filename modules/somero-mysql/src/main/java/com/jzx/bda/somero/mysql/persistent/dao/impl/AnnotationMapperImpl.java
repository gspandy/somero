package com.jzx.bda.somero.mysql.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.mysql.persistent.dao.AnnotationMapper;
import com.jzx.bda.somero.mysql.persistent.entity.Absannotation;

public class AnnotationMapperImpl implements AnnotationMapper {

	@Override
	public void addAnnotation(Absannotation absannotation) {
		sqlSession.insert("addAnnotation", absannotation);
	}

	@Override
	public List<Absannotation> getAnnotations(List<Span> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("spans", list);
		return sqlSession.selectList("getAnnotations", map);
	}

	@Override
	public void deleteAllAnnotation() {
		sqlSession.delete("deleteAllAnnotation");
	}

	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
