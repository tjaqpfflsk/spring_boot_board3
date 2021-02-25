package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardMapper {


	public List<BoardVO> getList();
	public int boardCount();
	public List<BoardVO> getListWithPaging(Criteria criteria);
	public int getTotalCount(Criteria cri);
	public void insert(BoardVO boardVO);
	public BoardVO getBoard(int bId);
}
