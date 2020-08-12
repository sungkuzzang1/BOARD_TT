package com.board.demo.dao;

import com.board.demo.vo.MemberVO;

public interface MemberDAO {
	public void register(MemberVO vo) throws Exception;
	
	public int idChk(MemberVO vo) throws Exception;
}
