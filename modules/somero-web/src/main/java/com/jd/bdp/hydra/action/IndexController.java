package com.jd.bdp.hydra.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/index.html")
	public String index() {
		return "index";
	}

	@RequestMapping("/query.html")
	public String query() {
		return "query";
	}

	@RequestMapping("/traceinfo.html")
	public String trace() {
		return "traceinfo";
	}

}
