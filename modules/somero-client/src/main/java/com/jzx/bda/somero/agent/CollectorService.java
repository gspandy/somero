package com.jzx.bda.somero.agent;

import java.util.List;

import com.jzx.bda.somero.Span;

/**
 * dubbo收集服务接口
 */
public interface CollectorService {
	public void sendSpan(List<Span> spanList);
}
