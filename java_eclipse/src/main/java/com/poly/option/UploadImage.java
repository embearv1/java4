package com.poly.option;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadImage {
	public String upload(HttpServletRequest req, String param) {
		try {
			Part part =  req.getPart(param);
			//String fileName = part.getSubmittedFileName();
			String fileNameRandom = UUID.randomUUID() + ".png";
			
			String uploadFile = "/upload/" +  fileNameRandom;
			
			String realPathUploadFile = req.getRealPath(uploadFile);
			part.write(realPathUploadFile);
			
			return fileNameRandom;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "default_avatar.png";
	}
}
