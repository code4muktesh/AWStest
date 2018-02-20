package com.awsapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.awsapp.model.Files;

@Repository
public class FilesDAOImpl implements FilesDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(FilesDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addFile(Files file) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(file);
		logger.info("Files saved successfully, Files Details="+file);
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Files> listFiles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Files> filesList = session.createQuery("from Files").list();
		for(Files files : filesList){
			logger.info("Files List::"+files);
		}
		return filesList;
	}

	

}
