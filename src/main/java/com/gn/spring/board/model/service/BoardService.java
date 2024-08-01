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
	
	// 페이징
	public int selectBoardCount() {
		int result = 0;
		try {
			result= boardDao.selectBoardCount();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<Board> selectBoardList(){
		List<Board> resultList = new ArrayList<Board>();
		try {
			resultList = boardDao.selectBoardList();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
}
