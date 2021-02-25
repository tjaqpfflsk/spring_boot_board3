package edu.bit.ex.service;


import java.util.List;

import org.springframework.stereotype.Service;
import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		log.info("mapper.getList()호출");
		return mapper.getList();
	}
	
	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("get List with criteria"+ criteria);
		return mapper.getListWithPaging(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		log.info("mapper.getTotalCount()호출");
		return mapper.getTotalCount(criteria);
	}

	@Override
	public void writeBoard(BoardVO boardVO) {
		log.info("mapper.insert()호출");
		mapper.insert(boardVO);
		
	}

	@Override
	public BoardVO getBoard(int bId) {
		log.info("mapper.getBoard()호출");
		return mapper.getBoard(bId);
	}

	@Override
	public void modify(BoardVO boardVO) {
		log.info("mapper.modify()호출");
		mapper.modify(boardVO);
		
	}

	@Override
	public void delete(int bId) {
		log.info("mapper.delete()호출");
		mapper.delete(bId);
		
	}

	@Override
	public void reply(BoardVO boardVO) {
		mapper.reply(boardVO);
		
	}

	@Override
	public void hit(int bId) {
		mapper.hit(bId);
		
	}

}
