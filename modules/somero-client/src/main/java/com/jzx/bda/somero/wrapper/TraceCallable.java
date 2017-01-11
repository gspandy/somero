package com.jzx.bda.somero.wrapper;

import java.util.concurrent.Callable;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.agent.Tracer;

public class TraceCallable<V> implements Callable<V> {

	private final Callable<V> impl;
	private final Span parent;
	private final Tracer tracer = Tracer.getTracer();

	public TraceCallable(Callable<V> impl) {
		this.parent = tracer.getParentSpan();
		this.impl = impl;
	}

	public TraceCallable(Span parent, Callable<V> impl) {
		this.impl = impl;
		this.parent = parent;
	}

	@Override
	public V call() throws Exception {
		if (parent != null) {
			tracer.setParentSpan(parent);
		}
		return impl.call();
	}

	public Callable<V> getImpl() {
		return impl;
	}
}
