package com.backend.app.mouse.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.mouse.models.entity.Mouse;
import com.backend.app.mouse.models.service.MouseService;

@RestController
public class MouseController {
	
	@Autowired
	private MouseService service;
	
	@GetMapping("/list")
	public List<Mouse> list(){
		return service.findAll();
	}
	
	@GetMapping("/mouse/{id}")
	public Mouse detail(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/mouse/{id}")
	public Mouse detailD(@PathVariable Long id) {
		return service.findById(id);
	}
}

