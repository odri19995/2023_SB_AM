package com.KoreaIT.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.KoreaIT.demo.vo.FileVO;

@Mapper
public interface FileRepository {

	@Insert("""
			INSERT INTO file
				SET regDate = NOW(),
					originName = #{orgName},
					savedName = #{savedName},
					savedPath = #{savedPath}
			""")
	void insertFileInfo(String orgName, String savedName, String savedPath);

	@Select("""
			SELECT *
				FROM file
				WHERE id = #{fileId}
			""")
	FileVO getFileById(int fileId);

	@Select("""
			SELECT *
				FROM file
			""")
	List<FileVO> getFiles();

}