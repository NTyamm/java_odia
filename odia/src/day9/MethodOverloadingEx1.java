package day9;

public class MethodOverloadingEx1 {

	public static void main(String[] args) {
		System.out.println(sum(1,2)); //변수가 2개인 1번이 호출된다
		System.out.println(sum(1,2,3)); //변수가 3개인 2번이 호출된다
		System.out.println(sum(1.2,2.5)); //실수가 2개인 3번이 호출된다
		System.out.println(sum(1,2.5)); //정수는 실수로 자료형변환이 가능하기 때문에 3번이 호출된다
		System.out.println(1);
		System.out.println('1'); //자료형이 달라서 사실상 1에 메소드 오버로딩이 발생함
		System.out.println("1");
	}
	//1
	public static int sum(int num1, int num2) {
		System.out.println("메소드1");
		return num1 + num2 ;
	}
	//매개변수의 갯수가 다른 경우, 2
	public static int sum(int num1, int num2, int num3) {
		System.out.println("메소드2");
		return num1 + num2 + num3 ;
	}
	//매개변수의 자료형이 다른 경우 ,3
	public static double sum(double num1, double num2) {//매개변수와 리턴타입이 다르면 에러가 난다.
		System.out.println("메소드3");
		return num1 + num2 ;
	}
}
