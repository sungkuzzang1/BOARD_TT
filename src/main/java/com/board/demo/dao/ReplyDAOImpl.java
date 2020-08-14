package com.board.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.demo.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	@Autowired
	SqlSession sqlsession;
	
	public List<ReplyVO> readReply(int bno) throws Exception{
		return sqlsession.selectList("replyMapper.readReply",bno);
	}
	
	public void writeReply(ReplyVO vo) throws Exception{
		sqlsession.insert("replyMapper.writeReply",vo);
	}
}
