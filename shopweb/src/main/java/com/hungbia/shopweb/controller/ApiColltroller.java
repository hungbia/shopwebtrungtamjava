package com.hungbia.shopweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/")
public class ApiColltroller {
	@GetMapping("kiem tra dang nhap")
	@ResponseBody
	public String KiemTraLoGin(@RequestParam String username, @RequestParam String password) {
		return "ok";
	}

}
