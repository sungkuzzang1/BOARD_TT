package com.board.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.demo.service.MemberService;
import com.board.demo.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberService service;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
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
				String inputPass = vo.getUserPass();
				String pwd = pwdEncoder.encode(inputPass);
				vo.setUserPass(pwd);				
				service.register(vo);
			}			                   
		}catch(Exception e) {
			throw new RuntimeException();
		}		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/idChk")
	public int idChk(MemberVO vo) throws Exception{
		int result = service.idChk(vo);		
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/passChk")
	public boolean passChk(MemberVO vo) throws Exception {
		MemberVO login = service.login(vo);
		boolean pwdChk = pwdEncoder.matches(vo.getUserPass(), login.getUserPass());
		return pwdChk;
		
		/*int result = service.passChk(vo);
		return result;*/
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO vo,HttpSession session,RedirectAttributes rttr) throws Exception{
		session.getAttribute("member");
		MemberVO login =service.login(vo);		
		boolean pwdMatch = pwdEncoder.matches(vo.getUserPass(), login.getUserPass());
		if(login != null && pwdMatch == true) {
			session.setAttribute("member", login);			
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg",false);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception{		
		return "member/modify";
	}
	
	@RequestMapping(value="/memberUpdate",method=RequestMethod.POST)
	public String registerUpdate(MemberVO vo,HttpSession session) throws Exception{
		service.memberUpdate(vo);
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/memberDeleteView", method = RequestMethod.GET)
	public String memberDeleteView() throws Exception{
		return "member/memberDeleteView";
	}
	
	@RequestMapping(value="/memberDelete", method = RequestMethod.POST)
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		/*
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		String sessionPass = member.getUserPass();		
		String voPass = vo.getUserPass();
		
		if(!(sessionPass.equals(voPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/memberDeleteView";
		}
		*/
		service.memberDelete(vo);
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
}
