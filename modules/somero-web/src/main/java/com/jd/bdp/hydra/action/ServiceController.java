package com.jd.bdp.hydra.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzx.bda.somero.mysql.persistent.service.AppService;
import com.jzx.bda.somero.mysql.persistent.service.ServiceService;

@Controller
@RequestMapping("/service")
public class ServiceController {

	@RequestMapping("/appList")
	@ResponseBody
	public Object getAllApp() {
		return appService.getAll();
	}

	@RequestMapping("/getSeviceList")
	@ResponseBody
	public Object getSeviceList(int serviceId) {
		return serviceService.get(serviceId);
	}

	@Autowired
	private AppService appService;

	@Autowired
	private ServiceService serviceService;
}
