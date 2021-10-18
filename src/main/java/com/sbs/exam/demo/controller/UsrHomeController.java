package com.sbs.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
//	객체가 죽지 않는한 계속 살아있을 수 있도록 전역, 지역변수 활용하기
//	이안에서만 활용한다고 하면 private
//	private int cnt = -1;
	
	private int cnt;
//	생성자 활용이 더 좋은 방법임
	UsrHomeController(){
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
	public String showMain2(){
		return "반갑습니다";
	}
	
	@RequestMapping("/usr/home/main3")
	@ResponseBody
	public String showMain3(){
		return "잘가";
	}
	
	@RequestMapping("/usr/home/main4")
	@ResponseBody
	public int showMain4(){
		cnt++;
		return cnt;
	}
	@RequestMapping("/usr/home/main5")
	@ResponseBody
	public String showMain5(){
		cnt=0;
		return "count값이 초기화 되었습니다.";
	}
}
