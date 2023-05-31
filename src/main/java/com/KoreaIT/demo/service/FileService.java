package com.KoreaIT.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.KoreaIT.demo.repository.FileRepository;
import com.KoreaIT.demo.vo.FileVO;

@Service
public class FileService {
	
	@Value("${file.dir}")
	private String fileDir;
	
	private FileRepository fileRepository;

	@Autowired
	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}
	
	public void saveFile(MultipartFile file) throws IOException {
		
		if (file.isEmpty()) {
			return;
		}
		
		String orgName = file.getOriginalFilename();
		
		String uuid = UUID.randomUUID().toString();
		
		String extension = orgName.substring(orgName.lastIndexOf("."));
		
		String savedName = uuid + extension;
		
		String savedPath = fileDir + "/" + savedName;
		
		fileRepository.insertFileInfo(orgName, savedName, savedPath);
		
		file.transferTo(new File(savedPath));
	}

	public List<FileVO> getFiles() {
		return fileRepository.getFiles();
	}
	
	public FileVO getFileById(int fileId) {
		return fileRepository.getFileById(fileId);
	}
	
}