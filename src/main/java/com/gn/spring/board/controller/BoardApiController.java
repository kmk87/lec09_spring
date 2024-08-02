package com.gn.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gn.spring.board.model.vo.Board;

@Controller
public class BoardApiController {
	
	private static final Logger LOGGER = LogManager.getLogger(BoardApiController.class);
	
	// fetch 에서 보내는 작업
	@ResponseBody
	@PostMapping("/board")
	public Map<String,String> createBoard(Board vo,
			@RequestParam("file") MultipartFile file){
		
		LOGGER.info("board 데이터 : "+vo);
		LOGGER.info("file 데이터 : "+file.getOriginalFilename());
		
		
		// 1. 파일을 저장
		// 2. 게시글 정보, 파일 정보 DB에 등록(INSERT)
		// 3. 결과를 json 형태로 화면에 전달
		Map<String, String> resultMap = new HashMap<String,String>();
		// 3.
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "게시글 등록 중 오류가 발생하였습니다.");
		return resultMap;
		
		
	}
	
	
}
