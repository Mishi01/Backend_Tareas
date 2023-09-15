package com.backend.app.mouse.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<String> detailD(@PathVariable Long id) {
		service.deleteTodo(id);
		return ResponseEntity.ok("Se ha eliminado correctamente!");
	}
	
	@PostMapping("/mouse")
	public ResponseEntity<String> detailP(@RequestBody Mouse mouse) {
		service.postTodo(mouse);
		return ResponseEntity.ok("Se ha agregado correctamente!");
	}
	
	@PutMapping("/mouse/{id}")
	public ResponseEntity<String> detailPut(@PathVariable Long id, @RequestBody Mouse mouse) {
		Mouse nuevoMouse = service.findById(id);
		if (nuevoMouse==null) {
			return ResponseEntity.notFound().build();
		}
		nuevoMouse.setName(mouse.getName());
		nuevoMouse.setMarca(mouse.getMarca());
		service.putTodo(nuevoMouse);
		return ResponseEntity.ok("Se ha actualizado correctamente!");
	}
}

