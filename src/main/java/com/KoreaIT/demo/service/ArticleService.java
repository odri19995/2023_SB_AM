package com.KoreaIT.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoreaIT.demo.repository.ArticleRepository;
import com.KoreaIT.demo.vo.Article;

@Service
public class ArticleService {
	
	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	public void writeArticle(int memberId, String title, String body) {
		articleRepository.writeArticle(memberId, title, body);
	}
	
	public int getLastInsertId() {
		return articleRepository.getLastInsertId();
	}
	
	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}
	
	public List<Article> getArticles(){
		return articleRepository.getArticles();
	}
	
	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}
	
	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}
	
}