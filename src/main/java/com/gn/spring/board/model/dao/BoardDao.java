package com.gn.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gn.spring.board.model.vo.Board;

@Repository
public class BoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public int updateBoard(Board vo) {
		return sqlSession.update("boardMapper.updateBoard", vo);
	}
	
	public Board selectBardOne(int board_no) {
		return sqlSession.selectOne("boardMapper.selectBardOne",board_no);
	}
	
	public int insertBoard(Board vo) {
		return sqlSession.insert("boardMapper.insertBoard",vo);
	}
	
	// 제목으로 검색
	
	// 페이징
	public int selectBoardCount(Board option) {
		return sqlSession.selectOne("boardMapper.selectBoardCount",option);
		
	}
	
	public List<Board> selectBoardList(Board option){
		return sqlSession.selectList("boardMapper.selectBoardList",option);
	}
}
