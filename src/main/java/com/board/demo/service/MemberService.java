package com.board.demo.service;

import com.board.demo.vo.MemberVO;

public interface MemberService {
	public void register(MemberVO vo) throws Exception;
	
	public int idChk(MemberVO vo) throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
}
