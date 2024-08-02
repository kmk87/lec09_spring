package com.gn.spring.board.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gn.spring.board.model.service.BoardService;
import com.gn.spring.board.model.vo.Board;

// 서블릿과 같은 역할
@Controller
public class BoardViewController {
	
	// new 연산자 등록 안하려고
	@Autowired
	BoardService boardService;
	
	private static final Logger LOGGER = LogManager.getLogger(BoardViewController.class);
	
	
	
	
	// 화면단에 데이터 보내는 방법
	// 1. ModelAndView -> 잘 안씀
//	@GetMapping("/board")
//	public ModelAndView selectBoardList() {
//		List<Board> resultList = boardService.selectBoardList();
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("resultList",resultList);
//		mav.setViewName("/board/list");
//		return mav;
//		
//		
//	}
//	
	
	
	
	@GetMapping("/board")
	public String selectBoardList(Model model, Board option) {
		
		// 제목으로 검색
		// 아무것도 써줄 필요없음. option에 들어가있음
		// 아래 페이징에 매개변수 option 넣어주고 매퍼 변경해줌
		
		// 페이징
		option.setTotalData(boardService.selectBoardCount(option));
		
		
		List<Board> resultList = boardService.selectBoardList(option);
		LOGGER.info(resultList);
		
		// 2. Model(매개변수 설정!!) 위의 (Model model)
		model.addAttribute("resultList",resultList);
		model.addAttribute("paging",option);
		
		
		// /WEB-INF/views/board/list.jsp
		return "/board/list";
	}
	
	// 화면만 전환하는 역할
	@GetMapping("/board/create")
	// 게시글 등록
	public String cteateBoardPage() {
		// /WEB-INF/views/board/create.jsp
		return "/board/create";
	}
	
	
}
