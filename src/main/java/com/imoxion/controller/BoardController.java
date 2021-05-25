package com.imoxion.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imoxion.domain.BoardVo;
import com.imoxion.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	
	@Autowired
	BoardService boardService;

	//리스트목록
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getBoardList(Model model) throws IOException {
		model.addAttribute("list", boardService.getBoardList());
		return "list";
	}

	//글입력
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void getInsert() {

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String postInsert(BoardVo boardVo) throws IOException {
		boardService.insertBoard(boardVo);
		return "redirect:/";
	}

	//글삭제
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String getDel(@RequestParam("no") int no) throws IOException {
		boardService.delBoard(no);
		return "redirect:/";

	}

	
	//글보기
	  @RequestMapping(value="/view" ,method = RequestMethod.GET) 
	  public void getView(@RequestParam("no") int no , Model model) throws IOException { 
		  BoardVo boardVo = boardService.getBoardView(no);
		  model.addAttribute("view",boardVo); 		  
	  
	  }
	  
	  //글수정
	  @RequestMapping(value = "/update", method = RequestMethod.GET)
		public void getUpdate(@RequestParam("no") int no ,Model model) throws IOException {
		  BoardVo boardVo = boardService.getBoardView(no);
		  model.addAttribute("view",boardVo);
		  
	  }
	  
		
		  @RequestMapping(value="/update" ,method = RequestMethod.POST) 
		  public String postUpdate(BoardVo boardVo) throws IOException {
		  boardService.getUpdate(boardVo); 
		  return "redirect:/";
		  
		  
		  }
		 
	 

}
