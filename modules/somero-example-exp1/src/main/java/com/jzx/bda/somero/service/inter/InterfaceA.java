package com.jzx.bda.somero.service.inter;

import com.jzx.bda.somero.service.inter.support.Service;

/**
 * 某个Dubbo服务
 */
public interface InterfaceA extends Service {
	Object functionA(Object... objects);
}
