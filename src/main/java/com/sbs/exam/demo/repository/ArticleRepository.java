package com.sbs.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sbs.exam.demo.vo.Article;

@Mapper
// MyBatis 매핑xml에 기재된 sql을 호출하기 위한 인터페이스이다.
public interface ArticleRepository {

	public void writeArticle(@Param("title") String title, @Param("body") String body);
	
	public Article getArticle(@Param("id") int id);
	
	public Article modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	
	public void deleteArticle(@Param("id") int id);
	
	public List<Article> getArticles();

	public int getLastInsertId();
}
