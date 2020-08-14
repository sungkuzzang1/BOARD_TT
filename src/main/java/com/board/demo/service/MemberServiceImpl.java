package com.board.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.demo.dao.MemberDAO;
import com.board.demo.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;
	
	public void register(MemberVO vo) throws Exception{
		dao.register(vo);
	}
	
	public int idChk(MemberVO vo) throws Exception{
		int result =dao.idChk(vo);
		return result;
	}
	
	public MemberVO login(MemberVO vo) throws Exception{
		return dao.login(vo);
	}
}
