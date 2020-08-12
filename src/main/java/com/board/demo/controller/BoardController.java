package com.board.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.demo.service.BoardService;
import com.board.demo.vo.BoardVO;
import com.board.demo.vo.Criteria;
import com.board.demo.vo.PageMaker;
import com.board.demo.vo.SearchCriteria;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/writeView",method=RequestMethod.GET)
	public void writeView() throws Exception{
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		service.write(boardVO);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		model.addAttribute("list",service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker",pageMaker);
		return "board/list";
	}
	
	@RequestMapping(value="/readView",method=RequestMethod.GET)
	public String read(BoardVO boardVO,Model model) throws Exception{
		model.addAttribute("read", service.read(boardVO.getBno()));
		return "board/readView";
		
	}
	
	@RequestMapping(value="/updateView",method=RequestMethod.GET)
	public String updateView(BoardVO boardVO,Model model) throws Exception{
		model.addAttribute("update",service.read(boardVO.getBno()));
		return "board/updateView";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		service.update(boardVO);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/delete")
	public String delete(BoardVO boardVO) throws Exception{
		service.delete(boardVO.getBno());
		return "redirect:/board/list";
	}
}
