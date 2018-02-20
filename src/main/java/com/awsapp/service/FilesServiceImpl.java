package com.awsapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awsapp.dao.FilesDAO;
import com.awsapp.model.Files;

@Service
public class FilesServiceImpl implements FilesService {
	
	private FilesDAO filesDAO;

	public void setFilesDAO(FilesDAO filesDAO) {
		this.filesDAO = filesDAO;
	}

	@Override
	@Transactional
	public void addFile(Files file) {
		this.filesDAO.addFile(file);
	}

	

	@Override
	@Transactional
	public List<Files> listFiles() {
		return this.filesDAO.listFiles();
	}

	

}
