package Day3;

import java.util.Scanner;

public class SwitchMonthEx1 {

	public static void main(String[] args) {
		/* 월의 마지막일을 출력하는 코드를 switch문으로 작성하세요.
		 * 31: 1 3 5 7 8 10 12
		 * 30: 4 6 9 11
		 * 28: 2
		 */
		System.out.println("1월에서 12월 중 하나를 입력하세요(ex : 3) : ");
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		scan.close();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
				System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month + "월은 30일까지 있습니다.");
		break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
		default:
			System.out.println(month + "월은 없는 달입니다.");
		}
	}

}
