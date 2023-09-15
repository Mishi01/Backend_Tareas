package com.backend.app.mouse.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.app.mouse.models.dao.MouseDao;
import com.backend.app.mouse.models.entity.Mouse;

@Service
public class MouseServiceImpl implements MouseService {
	@Autowired
	private MouseDao mouseDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Mouse> findAll() {
		return (List<Mouse>) mouseDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Mouse findById(Long id) {
		return mouseDao.findById(id).orElse(null);
	}

}
