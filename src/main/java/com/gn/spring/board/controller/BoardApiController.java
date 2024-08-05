package com.gn.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gn.spring.board.model.service.BoardService;
import com.gn.spring.board.model.service.UploadFileService;
import com.gn.spring.board.model.vo.Board;

@Controller
public class BoardApiController {
	
	
	
	@Autowired
	UploadFileService  uploadFileService;
	
	@Autowired
	BoardService boardService;
	
	// fetch 에서 보내는 작업
	@ResponseBody
	@PostMapping("/board")
	public Map<String,String> createBoard(Board vo,
			@RequestParam("file") MultipartFile file){
		
		
		
		// 2. 게시글 정보, 파일 정보 DB에 등록(INSERT)
		String savedFileName = uploadFileService.upload(file);
		
		// 3. 결과를 json 형태로 화면에 전달
		Map<String, String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "게시글 등록 중 오류가 발생하였습니다.");
		
		if(!"".equals(savedFileName)) {
			vo.setOri_thumbnail(file.getOriginalFilename());
			vo.setNew_thumbnail(savedFileName);
			
			// BoardService 의존성 주입
			// service -> dao -> mapper 게시글 insert
			
			int result = boardService.insertBoard(vo);
			
			if(result > 0) {
				resultMap.put("res_code","200");
				resultMap.put("res_msg","게시글이 성공적으로 등록되었습니다.");
			}
		}
		
		return resultMap;

	}
	
	
	@ResponseBody
	@PostMapping("/board/{board_no}")
	public Map<String,String> updateBoard(Board vo,
			@RequestParam("file") MultipartFile file) {
		
		String saveFileName = uploadFileService.upload(file);
		
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "게시글 수정 중 오류가 발생하였습니다.");
		
		
		if(file != null && !"".equals(file.getOriginalFilename())) {
			vo.setOri_thumbnail(file.getOriginalFilename());
			vo.setNew_thumbnail(saveFileName);
			
			int result = boardService.updateBoard(vo);
			
			if(result > 0) {
				resultMap.put("res_code", "200");
				resultMap.put("res_msg", "게시글 수정이 완료되었습니다.");
			}
		} else {
			int result = boardService.updateBoard(vo);
			
				if(result > 0) {
					resultMap.put("res_code", "200");
					resultMap.put("res_msg", "게시글 수정이 완료되었습니다.");
			}
		}
		return resultMap;
		
	}
	
	
	@ResponseBody
	@DeleteMapping("/board/{board_no}")
	public Map<String,String> deleteBoard(@PathVariable int board_no) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("res_code", "404");
		map.put("res_msg", "게시글이 성공적으로 삭제되었습니다.");
		if(boardService.deleteBoard(board_no) > 0) {
			map.put("res_code", "200");
			map.put("res_msg", "게시글이 성공적으로 삭제되었습니다.");
		}
		return map;
	}
	

}
