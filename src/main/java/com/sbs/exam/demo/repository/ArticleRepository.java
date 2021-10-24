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

	// INSER INTO article SET regDate = NOW(), updateDate = NOW(), title = ?, body = ?
	@Insert("INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, `body` = #{body}")
	public void writeArticle(@Param("title") String title, @Param("body") String body);
	
	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(@Param("id") int id);
	
	// UPDATE article SET updateDate = NOW(), title = ? , body = ?
	@Update("UPDATE article SET title = #{title}, `body` = #{body}, updateDate = NOW() WHERE id = #{id}")
	public Article modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	
	// DELETE FROM article WHERE id = ?
	@Delete("DELECT FROM article WHERE id = #{id}")
	public void deleteArticle(@Param("id") int id);
	
	// SELECT * FROM article ORDER BY id DESC
	@Select("SELECT * FROM article ORDER BY id DESC")
	public List<Article> getArticles();

	@Select("SELECT LAST_INSERT_ID()")
	public int lastInsertId();
}
