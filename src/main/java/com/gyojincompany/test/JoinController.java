package com.gyojincompany.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.test.dao.IDao;
import com.gyojincompany.test.dto.BoardDto;

@Controller
public class JoinController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "test")
	public String test(Model model, HttpServletResponse response) throws IOException {
			
		IDao dao = sqlSession.getMapper(IDao.class);		
		
		BoardDto boardDto = dao.joinTest("tiger");
		
		System.out.print(boardDto.getMemberDto().getName());
		
		model.addAttribute("boardInfo", boardDto);
		
		//특정 페이지로 이동전에 자바스크립트 경고창 띄우기
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
        out.flush(); 
		
		return "test";
	}
	
	
}
