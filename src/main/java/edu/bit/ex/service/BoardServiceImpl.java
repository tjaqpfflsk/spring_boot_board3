package edu.bit.ex.service;


import java.util.List;

import org.springframework.stereotype.Service;
import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
	
	@Override
	public List<BoardVO> getList(Criteria criteria) {
		//log.info("get List with criteria"+ criteria);
		return mapper.getListWithPaging(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		return mapper.getTotalCount(criteria);
	}

	@Override
	public void writeBoard(BoardVO boardVO) {
		mapper.insert(boardVO);
		
	}

}
