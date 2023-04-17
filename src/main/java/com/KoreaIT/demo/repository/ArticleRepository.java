package com.KoreaIT.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KoreaIT.demo.vo.Article;

@Mapper
public interface ArticleRepository {



	// 서비스 메서드

	public Article writeArticle(String title, String body);
	
	public int getLastInsertId();

	public Article getArticleById(int id) ;

	public List<Article> getArticles();

	public void modifyArticle(int id, String title, String body);

	public void deleteArticle(int id);

}