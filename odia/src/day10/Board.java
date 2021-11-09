package day10;

public class Board {
	// 멤버변수 
	// 게시글번호, 제목, 내용, 작성자, 조회수, 작성일
	private String title, contents, writer, date;
	private int num, views;

	// 생성자 (alt + shift + s -> 필드...어쩌구)
	public Board(String title, String contents, String writer, String date, int num) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.date = date;
		
		//조회수는 기본이 0이기 때문에 생성자가 필요 없음
	}
	// 일반적으로 멤버변수를 변경만 하는 기능들은 리턴타입이 void
	// 게시글 제목, 내용을 수정하는 기능
	public void modify(String title, String contents) {
		this.title = title; this.contents = contents;		
	}
	//게시글을 조회하는 기능(게시글 정보 출력)
	public void print() {
		System.out.println("글번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + contents);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + date);
		System.out.println("조회수 :  " + views);
		
	}	
	//조회수 1 증가하는 기능
	public void updateViews() {
		views++;
	}
	
}
