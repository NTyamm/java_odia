package kr.green.green.pagination;

import lombok.Data;

@Data
public class Criteria {
	//현재 페이지
	private int page; 
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	//검색어 추가
	private String search;
	//공지사항을 위한 type 추가
	private String type;
	//쿼리문에서 필요한 Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.search = "";
		this.type = "일반";
	}
	public Criteria(int page, int perPageNum) {
		this.page = page <= 0 ? 1 : page;
		this.perPageNum = perPageNum <= 0 ? 10 : perPageNum;
	}
	//번지수를 이용해 시작 페이지 넘버 계산
	public int getPageStart() {
		return(this.page -1)*perPageNum;
	}
	//getter and setter, toString은 필요가 없음. 롬복으로 @Data 하니까
	public String getTypeTitle() {
		if(type!=null && type.equals("공지"))
			return "공지사항";
		return "게시판";
		
	}
	
}