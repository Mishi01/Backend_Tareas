package com.backend.app.mouse.models.service;

import java.util.List;

import com.backend.app.mouse.models.entity.Mouse;

public interface MouseService {
	
	/**
	 * Este metodo retorna todo un listado de computadoras
	 * @return
	 */
	public List<Mouse> findAll();
	
	public Mouse findById(Long id);
}
