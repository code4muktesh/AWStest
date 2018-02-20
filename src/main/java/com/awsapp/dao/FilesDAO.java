package com.awsapp.dao;

import java.util.List;

import com.awsapp.model.Files;

public interface FilesDAO {

	public void addFile(Files file);
	
	public List<Files> listFiles();
	
	
}
