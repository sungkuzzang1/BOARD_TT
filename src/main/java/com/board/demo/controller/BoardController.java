package com.board.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.demo.service.BoardService;
import com.board.demo.service.ReplyService;
import com.board.demo.vo.BoardVO;
import com.board.demo.vo.Criteria;
import com.board.demo.vo.PageMaker;
import com.board.demo.vo.ReplyVO;
import com.board.demo.vo.SearchCriteria;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value="/writeView",method=RequestMethod.GET)
	public void writeView() throws Exception{
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		boardService.write(boardVO);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		model.addAttribute("list",boardService.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.listCount(scri));
		
		model.addAttribute("pageMaker",pageMaker);
		return "board/list";
	}
	
	@RequestMapping(value="/readView",method=RequestMethod.GET)
	public String read(BoardVO boardVO,Model model) throws Exception{
		model.addAttribute("read", boardService.read(boardVO.getBno()));
		
		List<ReplyVO> replyList = replyService.readReply(boardVO.getBno());
		model.addAttribute("replyList",replyList);
		
		return "board/readView";
		
	}
	
	@RequestMapping(value="/updateView",method=RequestMethod.GET)
	public String updateView(BoardVO boardVO,Model model) throws Exception{
		model.addAttribute("update",boardService.read(boardVO.getBno()));
		return "board/updateView";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		boardService.update(boardVO);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/delete")
	public String delete(BoardVO boardVO) throws Exception{
		boardService.delete(boardVO.getBno());
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/replyWrite",method=RequestMethod.POST)
	public String replyWrite(ReplyVO vo, RedirectAttributes rttr) throws Exception{
		replyService.writeReply(vo);
		
		rttr.addAttribute("bno",vo.getBno());
		return "redirect:/board/readView";
	}
}
