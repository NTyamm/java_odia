package Day3;

import java.util.Scanner;

public class SwitchArthmetricEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산자에 맞는 결과를 출력하는 코드를 작성하세요
		 * 예) 두 정수와 산술 연산자를 입력하세요 : 1 + 2
		 */
		
		System.out.println("두 정수와 산술연산자를 입력하세요. (ex: 1 + 2)");
		Scanner scan = new Scanner(System.in);	
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
	switch(operator) {
	case '+':
		System.out.println(num1 + " " + operator+ " " + num2 + " = " + (num1 + num2));
		break;
	case '-':
		System.out.println(num1 + " " + operator+ " " + num2 + " = " + (num1 - num2));
		break;
	case '*':
		System.out.println(num1 + " " + operator+ " " + num2 + " = " + (num1 * num2));
		break;
	case '/':
		System.out.println(num1 + " " + operator+ " " + num2 + " = " + (num1 / num2));
		break;
	case '%':
		System.out.println(num1 + " " + operator+ " " + num2 + " = " + (num1 % num2));
		break;
	default :
		System.out.println("잘못된 연산자입니다.");
	}

	scan.close();

	}
}