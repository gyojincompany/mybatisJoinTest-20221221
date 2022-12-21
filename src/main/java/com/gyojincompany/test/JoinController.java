package com.gyojincompany.test;

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
	public String test(Model model) {
			
		IDao dao = sqlSession.getMapper(IDao.class);		
		
		BoardDto boardDto = dao.joinTest("tiger");
		
		System.out.print(boardDto.getMemberDto().getName());
		
		model.addAttribute("boardInfo", boardDto);
		
		return "test";
	}
}
