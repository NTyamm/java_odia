package Day3;

import java.util.Scanner;

public class IfMultipleEx1 {

	public static void main(String[] args) {
		/*정수를 입력받고
		 * 입력받은 정수가 2의 배수이면 2의 배수입니다라고 출력하고
		 * 아니면 2의 배수가 아닙니다라고 출력하는 코드를 작성하세요.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		scan.close();
		
		if(num1 % 2 == 0) {
			System.out.print(num1 + "은 2의 배수입니다.");
		}else {
			System.out.print(num1 + "은 2의 배수가 아닙니다.");
		}

	}

}
