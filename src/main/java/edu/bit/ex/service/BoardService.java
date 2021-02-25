package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;


public interface BoardService {
	
	public List<BoardVO> getList();

	public List<BoardVO> getList(Criteria criteria);

	public int getTotal(Criteria criteria);

	public void writeBoard(BoardVO boardVO);

	public BoardVO getBoard(int bId);

	public void modify(BoardVO boardVO);
	
	}
	
 
