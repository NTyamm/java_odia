package day2;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*콘솔에서 두 정수를 입력받아 입력받은 정수들의 합과 나눈 결과를 구하는 코드를 작성하세요. */
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		System.out.println("합은" + (num1 + num2) +"입니다.");
		System.out.println("나눈 결과는" + ((double)num1 / (double)num2 + "입니다."));
		scan.close();
	
		
		//아니면
			/*int num1, num2;
			 *System.out.print("두 정수를 입려갛세요(예: 1 2: :);
			 *Scanner scan = new Scanner(System.in);
			 *num1 = scan.nextInt();
			 *num2 = scan.nextInt();
			 *int res = num + num2;
			 *System.out.println(num1 + "+ " + num2 + " = " + res);		
			 *scan.close();
			 */
	}

}
