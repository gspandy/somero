package com.jzx.bda.somero.store.inter;

import com.jzx.bda.somero.Span;


/**
  * User: yfliuyu
 * Date: 13-4-16
 * Time: 上午11:04
  */
public interface InsertService {
    void addSpan(Span span);

    void addAnnotation(Span span);

    void addTrace(Span span);
}
