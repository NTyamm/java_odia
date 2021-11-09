package day10;

import java.util.Random;

public class ClassStaticEx1 {

	public static void main(String[] args) {
		
		//객체를 만들지 않고 클래스를 통해 객체변수를 호출했기 때문에 에러발생
		//이 때 클래스 변수 num2는 생서잉 되고, 객체변수 num1은 생성이 안 됨
		
		Test1 t;
		//System.out.println("객체변수 num1 : " + Test1.num1); 
		
		System.out.println("클래스변수 num2 : " + Test1.num2);
		Test1 t1 = new Test1(); //num1=1, num2=2
		Test1 t2 = new Test1(); //num1=1, num2=2
		t1.num1 = 20;
		t1.num2 = 40;
		System.out.println("t1객체변수 num1 : " + t1.num1);
		System.out.println("t1클래스변수 num2 : " + t1.num2);//일단 사용은 가능
		System.out.println("t2객체변수 num1 : " + t2.num1);
		System.out.println("t2클래스변수 num2 : " + t2.num2);
		//0~1사이의 랜덤한 실수를 알려주는 클래스 메소드
		System.out.println(Math.random());
		Random r = new Random();
		
		//0에서 10미만의 랜덤한 정수를 알려주는 객체 메소드
		System.out.println(r.nextInt(10));
		

	}

}
class Test1{
	public int num1 = 1; 		//객체변수
	public static int num2 = 2; //클래스변수
	public void print1() {		//객체 메소드
		System.out.println("num1 : " + num1); //객체메소드에 객체변수 사용할 수 있다.
		System.out.println("num2 : " + num2); //객체메소드에 클래스변수 사용 가능
		method1();// 객체메소드에 객체메소드 사용가능
		method2();// 객체메소드에 클래스메소드 사용가능
		System.out.println("객체 메소드");
	}
	public static void print2() {//클래스 메소드
		System.out.println("클래스 메소드");
//		System.out.println("num1 : " + num1); //클래스메소드에 객체변수를 사용할 수 없다
		System.out.println("num2 : " + num2); //클래스메소드에 클래스변수를 사용할 수 있다.
//		method1();// 클래스메소드에 객체메소드 사용불가능
		method2();// 클래스메소드에 클래스메소드 사용가능
	}
	public void method1() {} //객체메소드
	public static void method2() {} //클래스메소드
}