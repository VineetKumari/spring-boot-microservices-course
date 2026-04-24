package com.in28minutes.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limits_service.bean.Limit;

@RestController
public class LimitsController {
	
	private Limit limit;
	
	@Autowired
	public LimitsController(Limit limit) {
		super();
		this.limit = limit;
	}


	@GetMapping(path = "/limits")
	public Limit getLimits() {
		//return new Limit(1, 999);
		return limit;
	}

}
