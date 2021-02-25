package edu.bit.ex.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Criteria {
	private int pageNum;//페이지 번호
	private int amount;//한페이지당 몇개의 데이터를 보여줄것인가?
	
	public Criteria() {
		this(1,10);//다시 찾아서 공부하자! 생성자를 호출맞아
		//기본값 1페이지 10개로 지정
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}

}
