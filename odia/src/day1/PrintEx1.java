package day1;

public class PrintEx1 {

	public static void main(String[] args) {
		//println 메소드 : 콘솔에 값을 출력하고 마지막에 엔터를 쳐주는 기능
		//()안에 값이 없어도 가능
		//print 메소드 : 콘솔에 값을 출력하는 기능
		//()안에 값이 없으면 에러
		System.out.println("Hello!!");
		System.out.println("Hello!!");
		System.out.print("Hello?");
		System.out.print("Hello?");
		System.out.println();
		//System.out.println();

		/* system.out.println(변수명);
		 * system.out.println("변수명 : +" 변수명);
		 */
		int num1 = 10;
		System.out.println(num1);
		System.out.println("num1 =" + num1);
		
		int num2 = 20;
		char operator = '+';
		//계획 : 10+20=30으로 출력
		System.out.println(num1 + operator + num2 + "=" + num1 + num2 );
		//결과 : 73-1020으로 출력
		//정수 + 문자 => 정수
		//10 + '+' => 10 + 43 = 53
		//아스키코드 할당으로 인해 +가 숫자 43으로 계산됨
		//정수 + 문자열 => 문자열 + 문자열 => 문자열
		System.out.println("" + num1 + operator + num2 + "=" + num1 + num2 );
		//결과 : 10+20=1020
		System.out.println("" + num1 + operator + num2 + "=" + (num1 + num2) );
	}
}
