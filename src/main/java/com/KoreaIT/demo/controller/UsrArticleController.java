package com.KoreaIT.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.demo.vo.Article;

@Controller
public class UsrArticleController {
	
	private int lastArticleId;
	private List<Article> articles;
	
	public UsrArticleController() {
		this.lastArticleId = 0;
		this.articles = new ArrayList<>();
		
		makeTestData();
	}

	private void makeTestData() {
		for(int i =1 ; i <=10 ; i ++) {			
			String title = "제목" + i;
			String body = "내용" + i;
			
			writeArticle(title, body);
		}		
		
	}
	
	private Article getArticleById(int id) {
		
		for (Article article : articles) {  //articles의 article을 꺼내온다. 
			if(article.getId() == id) {
				return article;
			}
		}
		return null;	
	}
	
	
	private void deleteArticle(int id) {
		
		Article article = getArticleById(id);
		
		articles.remove(article);
		
	}
	
	
	private void modifyArticle(int id, String title, String body) {
		
		Article article = getArticleById(id);
		
		article.setTitle(title);
		article.setBody(body);
		
	}
	
	
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		
		Article article = writeArticle(title,body);
		
		return article;
	}
	
	private Article writeArticle(String title, String body) {
		int id = this.lastArticleId +1;
		this.lastArticleId = id;
		
		Article article = new Article(id, title, body);
		
		articles.add(article);
		return article;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		
		return this.articles;
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		

		Article article =getArticleById(id);
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
		
		deleteArticle(id);
		
		return id  + "번 게시물을 삭제했습니다. ";
		
		
	}
	
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		
		Article article =getArticleById(id);
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
		
		modifyArticle(id,title,body);
		
		return id  + "번 게시물을 수정했습니다. ";
	}
	
	

	
	
}
