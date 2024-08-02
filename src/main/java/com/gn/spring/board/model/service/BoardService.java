package com.gn.spring.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gn.spring.board.model.dao.BoardDao;
import com.gn.spring.board.model.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public int deleteBoard(int board_no) {
		int result = 0;
		try {
			result = boardDao.deleteBoard(board_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 수정
	public Board selectBoardOne(int board_no) {
		Board vo = null;
		try {
			vo = boardDao.selectBoardOne(board_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public int insertBoard(Board vo) {
		int result = 0;
		try {
			result = boardDao.insertBoard(vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 페이징
	public int selectBoardCount(Board option) {
		int result = 0;
		try {
			result= boardDao.selectBoardCount(option);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<Board> selectBoardList(Board option){
		List<Board> resultList = new ArrayList<Board>();
		try {
			resultList = boardDao.selectBoardList(option);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	public int updateBoard(Board vo){
		int result = 0;
		try {
			result = boardDao.updateBoard(vo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
