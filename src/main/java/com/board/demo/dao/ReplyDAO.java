package com.board.demo.dao;

import java.util.List;

import com.board.demo.vo.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;

}
