package day7;

public class MethodEx1 {

	public static void main(String[] args) {
		sum(1,2); //3; 동작은 하지만 아무 의미가 없음
		int num = sum(1,2);
		System.out.println((num));
		System.out.println(sum(1,2));//int num으로 자료형을 선언했으니 정수만 들어간다. 혹은 자동형변환을 해야 함
		int a=1, b=2;
		System.out.println(sum(a,b));
		
		sum2(4,5);
		//num = sum2(4,5); //리턴타입이 없어서 에러발생
	}
	/*기능: 두 정수의 합을 알려주는 메소드
	 * 매개변수	: 두 정수 -> int num1, int num2
	 * int num1, num2//잘못된 매개변수 선언 방법
	 * 리턴 타입	: 두 정수의 합 -> 정수 -> int
	 * 메소드명	: sum
	 */
	public static int sum(int num1, int num2) { //알려주는 메소드
		int result = num1 + num2;
		return result;
		//정의된 매개변수에 맞는 값만 오면 됨
	}
	/* 기능 : 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수 : 두 정수 -> int num1, int num2
	 * 리턴타입 : 없음 -> void
	 * 메소드명 : sum
	 */
	public static void sum2(int num1, int num2) { //출력하는 메소드
		int result = num1 + num2;
		System.out.println(result);
	}

}
