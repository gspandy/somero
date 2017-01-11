package com.jzx.bda.somero.wrapper;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.agent.Tracer;

public class TraceRunnable implements Runnable {
	private final Span parent;
	private final Runnable runnable;
	private Tracer tracer = Tracer.getTracer();

	public TraceRunnable(Runnable r) {
		this.parent = tracer.getParentSpan();
		this.runnable = r;
	}

	public TraceRunnable(Runnable r, Span p) {
		this.runnable = r;
		this.parent = p;
	}

	@Override
	public void run() {
		if (parent != null) {
			tracer.setParentSpan(parent);
		}
		runnable.run();
	}
}
