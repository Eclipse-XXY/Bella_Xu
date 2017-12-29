package com.bellar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
@RequestMapping("/goto_attr")
	
public String goto_attr() {
	return "manager_attr";
}
@RequestMapping("/goto_sku")

public String goto_sku() {
	return "manager_sku";
}
@RequestMapping("index")
public String index(String url, String title, ModelMap map) {
	map.put("url", url);
	map.put("title", title);
	return "index";
}
}
