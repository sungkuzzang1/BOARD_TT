package com.board.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.demo.dao.BoardDAO;
import com.board.demo.vo.BoardVO;
import com.board.demo.vo.Criteria;
import com.board.demo.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;
	
	public void write(BoardVO boardVO) throws Exception {
		String content = boardVO.getContent();
		content = content.replace("\n", "<br>");
		boardVO.setContent(content);
		dao.write(boardVO);
	}
	
	public List<BoardVO> list(SearchCriteria scri) throws Exception{
		return dao.list(scri);
	}
	
	public int listCount(SearchCriteria scri) throws Exception{
		return dao.listCount(scri);
	}
	
	public BoardVO read(int bno) throws Exception{
		return dao.read(bno);
	}
	
	public void update(BoardVO boardVO) throws Exception{		
		dao.update(boardVO);
	}
	
	public void delete(int bno) throws Exception{
		dao.delete(bno);
	}
	
}
