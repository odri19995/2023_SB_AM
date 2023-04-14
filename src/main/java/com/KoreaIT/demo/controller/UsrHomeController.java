package com.KoreaIT.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	int i;
	
	public UsrHomeController() {
		this.i = 0;
	}
	@RequestMapping("/usr/home/main1")
	@ResponseBody
	public int showMain() {
		return i++ ;
	}
}
