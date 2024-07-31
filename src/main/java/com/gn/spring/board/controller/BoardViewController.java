package com.gn.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gn.spring.board.model.service.BoardService;
import com.gn.spring.board.model.vo.Board;

// 서블릿과 같은 역할
@Controller
public class BoardViewController {
	
	// new 연산자 등록 안하려고
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/board")
	public String selectBoardList() {
		List<Board> resultList = boardService.selectBoardList();
		// /WEB-INF/views/board/list.jsp
		System.out.println(resultList);
		return "/board/list";
	}
	
	
	
	
}
