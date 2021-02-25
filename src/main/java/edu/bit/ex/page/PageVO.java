package edu.bit.ex.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//롬보기할 때 두번째 대문자가 오류가 난다.
public class PageVO {
	//페이징 처리 할때 필요한 정보들
	private int startPage;//화면에 보이는 페이지 시작번호
	private int endPage;//화면에 보이는 페이지 끝번호
	private boolean prev, next;//이전,다음 이동하는 링크
	
	private int total; //전체 글의 개수;
	private Criteria cri;//나누어주는 것이 좋다
	//프라이빗
	
	
	public PageVO(Criteria cri,int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//처음 보이는 화면에 대한 것이다.열개까지 보여주겠다.//10은 변수로 해도 된다.근데 이게 더 좋대
		//내가 7이게 되면 거기에 맞추어 1~10이렇게 하는게 위의 연산식이다.
		//예: 현재 페이지가 13이면 13/10 = 1.3 올림 2-> 끝페이지는 2*10=20
		
		this.startPage = this.endPage -9;//10-9=1
		
		//Total을 통한 endPage의 재계산
		//10개씩 보여주는 경우 전체 데이터 수가 80개라고 가정하면 끝 번호는 10이 아닌 8이 됨
		int realEnd = (int)(Math.ceil((total * 1.0)/cri.getAmount()));
		//ceil 반올림이래  
		
		if(realEnd<=this.endPage) {
			this.endPage = realEnd;
		}
		//시작번호가 1 보다 큰 경우 존재
		this.prev = this.startPage >1;
		//realEnd가 8이면 안나와 ,끝번호(endPage)보다 큰 경우에 만 존재
		this.next = this.endPage < realEnd;
		
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum = 3
				.queryParam("amount", cri.getAmount()) // pageNum=3&amount=10 클릭을 할 때 마다 1,2,3,4, 
				.build(); // ?pageNum=3&amount=10
		return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴 
		//쉽게 달아주기 위해서 query를 하나 만든 것이다.
	}
	
}
