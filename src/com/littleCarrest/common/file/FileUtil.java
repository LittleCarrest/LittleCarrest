package com.littleCarrest.common.file;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.littleCarrest.common.code.Config;
import com.littleCarrest.common.code.ErrorCode;
import com.littleCarrest.common.exception.HandleableException;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;


public class FileUtil {
	
	private static final int MAX_SIZE = 1024*1024*10;
	
	//multipart 요청 도착 
	// -> multipartParser를 사용해 파일업로드 + 요청파라미터 저장 + FileDTO 생성
	public MultiPartParams fileUpload(HttpServletRequest request){
		
		Map<String,List> res = new HashMap<String, List>();
		List<FileDTO> fileDTOs = new ArrayList<FileDTO>();
		
		try {
			MultipartParser parser = new MultipartParser(request, MAX_SIZE);
			parser.setEncoding("UTF-8");
			Part part = null;
			
			while((part = parser.readNextPart()) != null) {
				System.out.println(part.isFile());
				if(part.isFile()) {
					FilePart filePart = (FilePart) part;
					
					if(filePart.getFileName() != null) {
						FileDTO fileDTO = createFileDTO(filePart);
						filePart.writeTo(new File(getSavePath() + fileDTO.getRenameFileName()));
						fileDTOs.add(fileDTO);
					}
					
				}else if(part.isParam()) {
					ParamPart paramPart = (ParamPart) part;
					setParameterMap(paramPart, res);
					System.out.println("paramPart: " + paramPart);
					System.out.println("res: " + res);
				}
			}
			System.out.println(fileDTOs);
			res.put("com.littleCarrest.files",fileDTOs);
			
		} catch (IOException e) {
			throw new HandleableException(ErrorCode.FAILED_FILE_UPLOAD_ERROR,e);
		}
		
		return new MultiPartParams(res);
	}
	
	public Map<String,FileDTO> profileUpload(HttpServletRequest request){
		
		Map<String,FileDTO> res = new HashMap<String, FileDTO>();
		FileDTO fileDTO = new FileDTO();
		
		try {
			MultipartParser parser = new MultipartParser(request, MAX_SIZE);
			parser.setEncoding("UTF-8");
			Part part = null;
			
			while((part = parser.readNextPart()) != null) {
				if(part.isFile()) {
					FilePart filePart = (FilePart) part;
					fileDTO = createFileDTO(filePart);
					filePart.writeTo(new File(getSavePath() + fileDTO.getRenameFileName())); //파일저장
				}
			}
					
			res.put("com.littleCarrest.files",fileDTO);
			
		} catch (IOException e) {
			throw new HandleableException(ErrorCode.FAILED_FILE_UPLOAD_ERROR,e);
		}
		
		return res;
	}
	


	private String getSavePath() {
		
		//2. 저장경로를 웹어플리케이션 외부로 지정
		//		 저장경로를  외부경로 + /연/월/일 형태로 작성
		String subPath = getSubPath();
		String savePath = Config.UPLOAD_PATH.DESC + subPath;
		
		File dir = new File(savePath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		return savePath;
	}
	
	private String getSubPath() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		return year + "\\" + month + "\\" + date + "\\";
	}
	
	private FileDTO createFileDTO(FilePart filePart) {
		FileDTO fileDTO = new FileDTO();
		String renameFileName = UUID.randomUUID().toString();
		String savePath = getSubPath();
		
		fileDTO.setOriginFileName(filePart.getFileName());
		fileDTO.setRenameFileName(renameFileName);
		fileDTO.setSavePath(savePath);
		
		return fileDTO;
	}
	
	private void setParameterMap(ParamPart paramPart, Map<String,List> res) throws UnsupportedEncodingException {
		if(res.containsKey(paramPart.getName())) {
			res.get(paramPart.getName()).add(paramPart.getStringValue());
		}else {
			List<String> param = new ArrayList<String>();
			param.add(paramPart.getStringValue());
			res.put(paramPart.getName(), param);
		}
	}
	
}
