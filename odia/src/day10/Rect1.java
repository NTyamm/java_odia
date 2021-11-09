package day10;

public class Rect1 {
	//시작점과 가로 세로
	private int x, y;
	private int width, height;
	
	Rect1(){}

	public Rect1(int x, int y, int width, int height) {
		this.x = x;		this.y = y;
		this.width = width;		this.height = height;
	}
	//사각형 정보 출력 기능(내 정보를 출력하는 거라 매개변수 따로 필요하지 않음)
	public void print() {
		System.out.println("---사각형---");
		System.out.println("시작점 : " + x + "," + y);
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
		System.out.println("----------");
	}
	//시작점 이동 기능
	public void move(int x, int y) {
		this.x = x;				this.y = y;
	}
	public void resize(int width, int height) {
		this.width = width;		this.height = height;
	}
}
