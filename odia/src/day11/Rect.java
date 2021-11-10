package day11;

public class Rect {
	Point lt;//leftTop의 약자, 왼쪽 위의 점
	Point rb;//rightBottom의 약자, 오른쪽 아래 점
	
	public Point getLt() {
		return lt;
	}
	public void setLt(Point lt) {
		this.lt = lt;
	}
	public Point getRb() {
		return rb;
	}
	public void setRb(Point rb) {
		this.rb = rb;
	}
	
	public Rect(Point lt, Point rb) {
		this.lt= new Point(lt);//복사생성자를 이용해, 값을 복사한 객체를 만들어 전달 
		/*this.lt = new Point(0,0);
		this.lt.setX(lt.getX());
		this.lt.setY(lt.getY());*/ //복사생성자를 이용하지 않으면 이렇게 세 줄로 길어진다.
		this.rb= new Point(rb);
//		this.rb=rb; //=을 통해 공유를 하면 rb값이 바뀌면 내용이 값이 바뀜
	}
	public Rect() {
		lt = new Point(0,0);
		rb = new Point(0,0);
	}
	public void move(int x, int y) {
		int width = rb.getX() - lt.getX();
		int height = rb.getY() - lt.getY();
		lt.move(x, y);
		rb.move(x + width, y + height);
	}
	public void resize(int width, int height) {
		rb.move(lt.getX() + width, lt.getY() + height);
	}
	public void print() {
		System.out.println("---사각형---");
		System.out.println("좌상점 : ");
		lt.print();
		System.out.println("우하점 : ");
		rb.print();
	}
}
