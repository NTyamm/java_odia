package Day3;

import java.util.Scanner;

public class IfMultipleEx2and3 {

	public static void main(String[] args) {
		/*정수를 입력받고
		 * 입력받은 정수가 2의 배수이면 2의 배수입니다라고 출력하고
		 * 정수가 3의 배수이면 3의 배수라고 출력,
		 * 정수가 6의 배수이면 6의 배수라고 출력,
		 * 정수가 2, 3, 5의 배수가 아니면 2, 3, 6의 배수가 아닙니다라고 출력하는 코드를 작성하세요.
		 * 단, 6, 12, ...는 6의 배수라고 출력해야 한다.
		 */
		System.out.println("정수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		scan.close();
			
		if (num1 % 2 == 0 && num1 % 3 !=0 ) {
			System.out.println(num1 + "은 2의 배수입니다.");
		}else if (num1 % 3 == 0  && num1 % 2 !=0) {
			System.out.println(num1 + "은 3의 배수입니다.");
		}else if (num1 % 6 == 0 ) {
			System.out.println(num1 + "은 6의 배수입니다.");
		}else {
			System.out.println(num1 + "은 2, 3, 6의 배수가 아닙니다");
		}
	
	}
}
