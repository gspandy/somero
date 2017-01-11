package com.jzx.bda.somero.mysql.persistent.dao;

import java.util.List;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.mysql.persistent.entity.Absannotation;

public interface AnnotationMapper {
	public void addAnnotation(Absannotation absannotation);

	List<Absannotation> getAnnotations(List<Span> list);

	// 测试用
	void deleteAllAnnotation();
}
