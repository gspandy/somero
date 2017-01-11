package com.jzx.bda.somero.agent.support;

import java.util.concurrent.atomic.AtomicLong;

public class GenerateTraceId {
	private Long seed;
	private Long MAX_STEP = 0xffffffL;
	private AtomicLong plusId = new AtomicLong(0L);

	public GenerateTraceId(Long seed) {
		this.seed = seed;
	}

	public Long getTraceId() {
		return (seed << 40) | getPlusId();
	}

	private long getPlusId() {
		if (plusId.get() >= MAX_STEP) {
			plusId.set(0L);
		}
		return plusId.incrementAndGet();
	}

}
