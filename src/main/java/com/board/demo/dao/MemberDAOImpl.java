package com.board.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.demo.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	SqlSession sql;
	
	public void register(MemberVO vo) throws Exception{
		sql.insert("memberMapper.register",vo);
	}
	
	public int idChk(MemberVO vo) throws Exception{
		int result = sql.selectOne("memberMapper.idChk",vo);
		return result;
	}
	
	public MemberVO login(MemberVO vo) throws Exception{
		return sql.selectOne("memberMapper.login",vo);
	}

}
