package com.awsapp.service;

import java.util.List;

import com.awsapp.model.Files;

public interface FilesService {

	public void addFile(Files file);
	
	public List<Files> listFiles();
	
	
}
