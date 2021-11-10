package day11;

public class ClassInitEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Test11{
	/* 멤버변수 num의 초시화 순서
	 * 1. num은 자료형 int의 기본값 0으로 초기화 
	 * 2. num은 10으로 초기화(명시적 초기화) 
	 * 3. (초기화 블록에 초기화)*/
	private int num = 10; // =10;으로 명시적초기화
	{
		num = 20; //초기화 블록
	} 
	public Test11() {
		num = 30;
	}
	/* 클래스 멤버변수 cnt의 초기화 순서
	 * 1. cnt는 0으로 초기화(자료형의 기본값으로 초기화)
	 * 2. cnt는 11로 초기화(명시적 초기화)
	 * 3. cnt는 21로 초기화(초기화블록)*/
	public static int cnt = 11; //명시적초기화
	static { //초기화블록
		cnt=21;
	}
}