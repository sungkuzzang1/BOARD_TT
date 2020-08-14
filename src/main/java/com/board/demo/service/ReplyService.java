package com.board.demo.service;

import java.util.List;

import com.board.demo.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
}
