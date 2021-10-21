package com.sbs.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.demo.service.ArticleService;
import com.sbs.exam.demo.vo.Article;

@Controller
// 컨트롤러는 딱 요청만 받는 용도로 구조화
public class UsrArticleController {
	// 인스턴스 변수
	
	@Autowired
	private ArticleService articleService; // 객체화 하지 않고 처리하는 법. 세션이나 new 사용해서 따로 안만들어도 됨.
	
	// 액션 메서드 시작
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		Article article = articleService.writeArticle(title, body);
		return article;
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);
		if(article==null) {
			return id + "번 글은 존재하지 않습니다.";
		}
		articleService.deleteArticle(id);
		return id + "번 글이 삭제되었습니다.";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);
		if(article==null) {
			return id + "번 글은 존재하지 않습니다.";
		}
		articleService.modifyArticle(id, title, body);
		return id + "번 글이 수정되었습니다.";
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.articles;
	}
	
	// 게시물 상세 보기
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticleAction(int id) {
		Article article = articleService.getArticle(id);

		if( article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}

		return article;
	}
	// 액션 메서드 끝
}
