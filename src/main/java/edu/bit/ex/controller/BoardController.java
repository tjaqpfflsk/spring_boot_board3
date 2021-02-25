package edu.bit.ex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.PageVO;
import edu.bit.ex.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@AllArgsConstructor
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	 @GetMapping("board/list")
	 public String list(Criteria cri, Model model) throws Exception {	
		 //페이징 처리한 부분
		 log.debug("list()...");
		 log.info("list 호출");
		 log.info(""+cri);
		 model.addAttribute("list", boardService.getList(cri));	
		 
		 int total = boardService.getTotal(cri);
		 log.info("total" + total);
		 
		 model.addAttribute("pageMaker", new PageVO(cri,total));
		 return "board/list";
	 }
	
}