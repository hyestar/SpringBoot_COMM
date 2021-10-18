package com.sbs.exam.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UsrHomeController {
//	객체가 죽지 않는한 계속 살아있을 수 있도록 전역, 지역변수 활용하기
//	이안에서만 활용한다고 하면 private
//	private int cnt = -1;

	private int cnt;

//	생성자 활용이 더 좋은 방법임
	UsrHomeController() {
		cnt = -1;
	}

//  @RequestMapping을 통해 요청을 받고
	@RequestMapping("/usr/home/main")
//	@@ResponseBody를 통해 실행
	@ResponseBody
	public String showMain() {
		return "안녕하세요";
	}

	@RequestMapping("/usr/home/main2")
	@ResponseBody
	public String showMain2() {
		return "반갑습니다";
	}

	@RequestMapping("/usr/home/main3")
	@ResponseBody
	public String showMain3() {
		return "잘가";
	}

	@RequestMapping("/usr/home/main4")
	@ResponseBody
	public int showMain4() {
		cnt++;
		return cnt;
	}

	@RequestMapping("/usr/home/main5")
	@ResponseBody
	public String showMain5() {
		cnt = 0;
		return "count값이 초기화 되었습니다.";
	}

	@RequestMapping("/usr/home/getCount")
	@ResponseBody
	public int getCount() {
		cnt++;
		return cnt;
	}

	@RequestMapping("/usr/home/doSetCount")
	@ResponseBody
	public String doSetCount(int cnt) {
		this.cnt = cnt;
		return "Count값이 " + this.cnt + "으로 초기화 되었습니다.";
	}

	@RequestMapping("/usr/home/test1")
	@ResponseBody
	public String getString() {
		return "Hi";
	}

	@RequestMapping("/usr/home/test2")
	@ResponseBody
	public float getFloat() {
		return (float) 3.1425; // == return 3.1425f;
	}

	@RequestMapping("/usr/home/test3")
	@ResponseBody
	public boolean getboolean() {
		return true;
	}

	@RequestMapping("/usr/home/test4")
	@ResponseBody
	public int getint() {
		return 5;
	}

	@RequestMapping("/usr/home/test5")
	@ResponseBody
	public double getdouble() {
		return 3.25656;
	}

	@RequestMapping("/usr/home/getChar")
	@ResponseBody
	public char getChar() {
		return 'a';
	}

	@RequestMapping("/usr/home/getMap")
	@ResponseBody
	public Map getMap() {
		Map<String, Object> map = new HashMap<>();

		map.put("철수의 나이", 22);
		map.put("영희의 나이", 33);

		return map;
	}

	@RequestMapping("/usr/home/getList")
	@ResponseBody
	public List<String> getList() {
		List<String> list = new ArrayList<>();

		list.add("철수의 나이");
		list.add("영희의 나이");

		return list;
	}

	@RequestMapping("/usr/home/getArticle")
	@ResponseBody
	public Article getArticle() {

		Article article = new Article(1, "제목1");
		Article article1 = new Article();

		return article;
	}

	@RequestMapping("/usr/home/getArticles")
	@ResponseBody
	public List<Article> getArticles() {

		Article article1 = new Article(1, "제목1");
		Article article2 = new Article(2, "제목2");

		List<Article> list = new ArrayList<>();

		list.add(article1);
		list.add(article2);

		return list;
	}

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Article {
	private int id;
	private String title;
}
