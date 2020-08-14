package com.board.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.demo.dao.ReplyDAO;
import com.board.demo.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyDAO replydao;
	
	public List<ReplyVO> readReply(int bno) throws Exception{
		return replydao.readReply(bno);
	}
	
	public void writeReply(ReplyVO vo) throws Exception{
		replydao.writeReply(vo);
	}

}
