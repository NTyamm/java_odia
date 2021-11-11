package day12;

public class ExaRect extends ExaShape {
	/* 도형 클래스를 상속받아 사각형 클래스를 만드세요. */
	//사각형 클래스는 도형의 테두리와 일치한다
	//이 클래스에 부모클래스의 생성자를 만들지 않으면 에러가 발생한다. super로 호출
	public ExaRect(int x1, int y1, int x2, int y2) {

		super(x1, y1, x2, y2);
	}
	@Override
	//사각형을 그리기
	public void print() {
		System.out.println("----사각형----");
		System.out.println("좌상점 : " + left + "," + top); //부모클래스에서 private 멤버변수로 설정된 left, top를 변환해야 함
		System.out.println("우하점 : "+ right + "," + bottom); //ExaShape의 접근제한자를 protected로 수정함
		System.out.println("가로 : " + getWidth());
		System.out.println("세로 : " + getHeight());
	} 
	
	public void testR() {
		System.out.println("사각형");
	}
}
