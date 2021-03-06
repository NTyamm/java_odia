package day9;

public class ClassAccessEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		//a.num1 = 10; //접근제한자가 private이기 때문에 ClassAccessEx1 클래스에서 사용할 수 없음
		a.setNum1(10); //위 방식으로는 num1값을 수정할 수 없기 때문에 setter를 사용한다.
		a.num2 = 20; //A클래스와 ClassAccessEx1클래스가 같은 패키지에 있기 때문에 사용 가능
		a.num3 = 30; //아무 클래스나 사용할 수 있다.
	}

}
class A{ //현재 파일명이 ClassAccessEx1이기 때문에 클래스 A에 public을 붙일 수 없다
	private int num1;
	int num2; // default : 기본접근제한자. 접근제한자를 생략한 경우 
	public int num3;
	public int getNum1(){
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
}