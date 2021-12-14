package com.jas.poc.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jas.poc.demo.Entity.User;
import com.jas.poc.demo.services.UserService;


@RestController
public class Login {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth")
	public HashMap<String, String> authetnticate(@RequestBody Map<String, Object> payload) {

		
		User nameResult = userService.findByName((String) payload.get("uname"));
		
		HashMap<String, String> hm = new HashMap<>();
		if(nameResult!=null && nameResult.getPassword()!=null && 
				nameResult.getPassword().equals((String) payload.get("password"))) {
			hm.put("data", "success");
			return hm;
		}
		hm.put("data", "failed");
		return hm;
	}
	
	@GetMapping("/auth")
	public HashMap<String, String> authetnticate2(@RequestParam(name="uname") String uname, @RequestParam(name="password") String password) {
			
			User nameResult = userService.findByName(uname);
			
			HashMap<String, String> hm = new HashMap<>();
			if(nameResult.getPassword().equals(password)) {
				hm.put("data", "success");
				return hm;
			}
			hm.put("data", "failed");
			return hm;
		}
}
