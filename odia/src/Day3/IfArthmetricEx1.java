package Day3;

import java.util.Scanner;

public class IfArthmetricEx1 {

	public static void main(String[] args) {
		/*두 정수와 산술연산자중 하나를 입력하여 입력한 연산자가 +이면 두 정수의 합을
		 * -면 두 정수의 차를, *면 두 정수의 곱을, /면 두 정수의 나눗셈을, %이면 두 정수의 나머지를 
		 * 산술연산자가 아니면 산술연ㅅ산자가 아닙니다라고 출력하는 코드를 작성하세요
		 *
		 * 1. 두 정수와 산술 연산자를 입력: Scanner
		 * 2. 조건문 작성
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 산술 연산자를 입력하세요 (예: 1 +2 ) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		scan.close();
		
		if(operator == '+'){
			System.out.println(" " + num1 + " " + "+" + " " + num2 + " " + "=" + " " + (num1 + num2));
		}else if(operator == '-') {
			System.out.println(" " + num1 + " " + "-" + " " + num2 + " " + "=" + " " + (num1 - num2));
		}else if(operator == '*') {
			System.out.println(" " + num1 + " " + "*" + " " + num2 + " " + "=" + " " + (num1 * num2));
		}else if(operator == '/') {
			System.out.println(" " + num1 + " " + "/" + " " + num2 + " " + "=" + " " + ((double)num1 / (double)num2));
		}else if(operator == '%') {	
			System.out.println(" " + num1 + " " + "%" + " " + num2 + " " + "=" + " " + (num1 % num2));
		}else {
			System.out.println("산술연산자가 아닙니다.");

		}
;
	}

}
