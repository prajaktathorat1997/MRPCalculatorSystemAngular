package com.materialrequirementsplanning.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.materialrequirementsplanning.model.MRPRequest;
import com.materialrequirementsplanning.service.MRPService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mrp")
public class MRPController {
	@Autowired
	private MRPService service;

	@PostMapping("/calculate")
	public Map<String, Object> calculateMRP(@RequestBody MRPRequest request) {
		return service.calculateRequirements(request);
	}

}
