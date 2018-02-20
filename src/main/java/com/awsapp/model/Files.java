package com.awsapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="files")
public class Files {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="file_uri")
	private String fileUri;
	
	@Column(name="created_at")
	private String createAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileUri() {
		return this.fileUri;
	}

	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}

	public String getCreatedAt() {
		return this.createAt;
	}

	public void setCreatedAt(String createAt) {
		this.createAt = createAt;
	}
	
	
}
