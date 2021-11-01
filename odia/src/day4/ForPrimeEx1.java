package day4;

import java.util.Scanner;

public class ForPrimeEx1 {

	public static void main(String[] args) {
		/*입력받은 정수가 소수인지 아닌지 판별하는 코드를 for문을 이용하여 작성하세요.
		 * 소수이면 소수, 소수가 아니면 소수가 아님이라고 출력하세요.
		 * 소수는 약수가 2개인 수
		 * *scanner를 이용하여 num1에 정수를 입력
		 * 반복횟수 : i는 1부터 num1까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 count(약수의 갯수)를 1증가
		 * 반복문 종료 후 : count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력
		 */

		int i, count = 0; //or count;로 두고
		System.out.println("정수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		scan.close();
		for ( i = 1 ; i <= num1 ; i++ ) { //i = 1, count = 0;으로 초기화해도 된다.
			if(num1 % i == 0) {
				count++;};} //++count; //count = count + 1; // count += 1;
				
		if (count == 2) {
			System.out.println(num1 + "은 소수이다.");
		}else {
			System.out.println(num1 + "은 소수가 아니다.");
		}
		switch(count) {
		case 2 : System.out.println(num1 + "은 소수이다."); break;
		default: System.out.println(num1 + "은 소수가 아니다."); break;
		}
		String str = count == 2 ? "소수" : "소수가 아님";
		System.out.println(num1 + "은 " + str);
	}
		
}
	


