package com.awsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.BufferedOutputStream;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;


import com.awsapp.model.Files;
import com.awsapp.service.FilesService;
import com.awsapp.util.*;

import com.awsapp.configs.AWS;

@Controller
public class FileController {
	
	private FilesService filesService;
	
	@Autowired(required=true)
	@Qualifier(value="filesService")
	public void setFilesService(FilesService fs){
		this.filesService = fs;
	}
	
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public String listFiless(Model model) {
		model.addAttribute("file", new Files());
		model.addAttribute("listFiles", this.filesService.listFiles());
		return "file";
	}
	
	@RequestMapping(value= "/file/add/**", method = RequestMethod.GET)
	public String redirectToFileList(){
		return "redirect:/files";
	}
	
	//For add and update person both
	@RequestMapping(value= "/file/add", method = RequestMethod.POST)
	public String addFile(@ModelAttribute("file") MultipartFile file,Model model){
		
		String msg=null;
    	String fileName = null;
    	if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                String path=AWS.uploadPath + fileName;
                BufferedOutputStream buffStream = 
                        new BufferedOutputStream(new FileOutputStream(new File(path)));
                buffStream.write(bytes);
                buffStream.close();
                
                
                AwsS3 aws=new AwsS3();
                String s3accesUri=aws.s3Upload(path, fileName);
            Files newFile=new Files();
        	newFile.setFileUri(s3accesUri);	
        	newFile.setCreatedAt(com.awsapp.util.DateTime.getCurrentDateTimeForMySQL());
        	this.filesService.addFile(newFile);
        	
        	// msg= "You have successfully uploaded " + fileName;
        	 return "redirect:/files";
            } catch (Exception e) {
            	msg= "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
        	msg= "Unable to upload. File is empty.";
        }
    	model.addAttribute("msg", msg);
    	
    	System.out.print(msg);
    	model.addAttribute("file", new Files());
		model.addAttribute("listFiles", this.filesService.listFiles());
		return "file";
    	
		
		
		
		
	}
	
	
}
