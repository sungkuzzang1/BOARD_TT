package com.board.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.demo.service.MemberService;
import com.board.demo.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void getRegister() throws Exception{
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception{
		int result = service.idChk(vo);
		try {
			if(result == 1) {
				return "/member/register";
			}else if(result == 0) {
				service.register(vo);
			}			                   
		}catch(Exception e) {
			throw new RuntimeException();
		}		
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/idChk")
	public int idChk(MemberVO vo) throws Exception{
		int result = service.idChk(vo);
		System.out.println("증벅호가인 -"+ result);
		return result;
		
	}
	
	
}
