package Day3;

import java.util.Scanner;

public class IfMonthEx1 {

	public static void main(String[] args) {
		/*월을 입력받아 입력받은 월의 마지막 일의 출력하는 코드를 작성하세요.
		 * 
		 */
		System.out.println("1월에서 12월 중 하나를 입력하세요(ex : 3) : ");
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		scan.close();
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month ==12) {
			System.out.println(month + "월은 31일까지 있습니다.");
		}else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month +"월은 30일까지 있습니다.");
		}else if (month ==2){ 
			System.out.println(month + "월은 28일까지 있습니다.");
		}else {System.out.println("숫자를 잘못 입력하셨습니다.");}

	}
}