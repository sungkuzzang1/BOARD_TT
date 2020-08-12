package com.board.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.demo.vo.BoardVO;
import com.board.demo.vo.Criteria;
import com.board.demo.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	public void write(BoardVO boardVO) throws Exception{
		sqlSession.insert("boardMapper.insert",boardVO);		
	}
	
	public List<BoardVO> list(SearchCriteria scri) throws Exception{
		return sqlSession.selectList("boardMapper.listPage",scri);
	}
	
	public int listCount(SearchCriteria scri) throws Exception{
		return sqlSession.selectOne("boardMapper.listCount",scri);
	}
	
	public BoardVO read(int bno) throws Exception{
		return sqlSession.selectOne("boardMapper.read",bno);
	}
	
	public void update(BoardVO boardVO) throws Exception{
		sqlSession.update("boardMapper.update",boardVO);
	}
	
	public void delete(int bno) throws Exception{
		sqlSession.delete("boardMapper.delete",bno);
	}
	
}
