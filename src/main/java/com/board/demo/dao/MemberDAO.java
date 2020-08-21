package com.board.demo.dao;

import com.board.demo.vo.MemberVO;

public interface MemberDAO {
	public void register(MemberVO vo) throws Exception;
	
	public int idChk(MemberVO vo) throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
	
	public void memberUpdate(MemberVO vo) throws Exception;
	
	public void memberDelete(MemberVO vo)throws Exception;
	
	public int passChk(MemberVO vo) throws Exception;
}
