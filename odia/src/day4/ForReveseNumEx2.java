package day4;

import java.util.Scanner;

public class ForReveseNumEx2 {

	public static void main(String[] args) {
		/* 0보다 큰 정수를 역순으로 출력하는 코드를 for문으로 작성하세요.
		 * 예) 1234 > 4321
		 * 반복문1 : 1234에서 일의자리 4를 콘솔에 출력, 1234를123으로 만듬
		 * 반복문2 : 123에서 1의자리 3을 콘솔에 출력, 123을 12로 만듬
		 * 반복문3 : 12에서 1의자리 2를 콘솔에 출력, 12를 1로 만듬
		 * 반복문4 : 1에서 1의 자리 1을 콘솔에 출력, 1을 0으로 만듬
		 * 반복문 종료	
		 * 반복횟수 : num가 0이 아니면 반복문 실행, 0이면 반복문 종료 
		 * 규칙성	  :	num를 10으로 나눈 나머지를 출력
		 * 			num를 10으로 나눈 몫을 출력
		 */
		System.out.println("4자리 정수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num= scan.nextInt();
		for( ; num !=0 ; ) {
			System.out.print(num % 10);
			num = num /10; //for 문의 증감식에 넣어도 괜찮다. 
		}
		scan.close();
	}

}
