package day6;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBaseballEx1 {

	public static void main(String[] args) {
		/* 숫자 야구 게임
		 * 컴퓨터가 랜덤으로 1~9사이의 중복되지 않은 세 수를 선택하고
		 * 사용자는 컴퓨터가 선택한 세 수를 맞추는 게임
		 * -> 사용자가 처음으로 입력한 중복되지 않은 1~9 사이의 세 수를 컴퓨터가 만든 수라고 가정하고
		 * 사용자는 컴퓨터가 선택한 세 수를 맞추는 게임
		 * 규칙
		 * S : 숫자가 있고, 숫자의 위치가 맞은 경우
		 * B : 숫자는 있지만 위차가 안 맞은 경우
		 * 3O : 맞는 숫자가 하나도 없는 경우
		 * 3S : 게임 종료
		 * 컴퓨터 : 1 9 5
		 * 사용자 : 1 2 3
		 * -> 1S
		 * 사용자 : 1 4 5
		 * -> 2S
		 * 사용자 : 1 5 8
		 * -> 1S1B
		 * 사용자 : 5 7 8
		 * -> 1B
		 * 사용자 : 4 7 8
		 * -> 3O
		 * 사용자 : 1 9 5
		 * -> 3S
		 * 정답입니다. 프로그램 종료.
		 */
		//사용자가 컴퓨터 숫자 3개를 입력
		System.out.print("컴퓨터(예: 1 2 3): ");
		int com[] = new int[3];
		Scanner scan = new Scanner(System.in);
//		com[0] = scan.nextInt();
//		com[1] = scan.nextInt();
//		com[2] = scan.nextInt();
		for(int i=0; i<com.length; i++) {
			com[i] = scan.nextInt();
		}
		//사용자가 무한히 숫자 세 개를 입력 받음
		int user[] = new int[3];
		int strike, ball, out;
		do {
		System.out.print("사용자: ");
		for(int i = 0 ; i<user.length ; i++ ) {
			user[i]=scan.nextInt();
			}
		//스트라이크 갯수를 계산하여 스트라이크 갯수를 출력
		//컴퓨터 : 1 3 2
		//사용자 : 1 2 3
//		1
		System.out.println(Arrays.toString(user));
		//스트라이크 갯수를 계산하여 스트라이크 갯수를 출력
		strike = 0;
		for(int i = 0 ; i<user.length ; i++ ) {
		 if(user[i] == com[i]) {
			strike++;
		 }
		}
		//볼의 갯수를 계산하여 볼의 갯수를 출력
		ball=0;
		out=0;
		for(int i = 0; i<user.length ; i++) {
			 for(int j=0; j<user.length ; j++)
				 //com[i], user[j]
				 //스트라이크인 경우는 생략
				 if (i == j) {
				  continue;
				 }
			 	if (com[i] == user[j]) {
				 ball++;
			 }
		}
		}
		//스트라이크만 있는 경우는 xS
		//볼만 있는 경우는 xB
		//스트라이크와 볼이 같이 있는 경우 xSxB
		//스트라이크와 볼이 없는 경우 3O 출력되도록 작성 \
		if (strike !=0 && ball == 0 ) {
			System.out.println(strike+"S");
		}else if (strike != 0 && ball !=0) {
		System.out.println(strike+"S " +ball+"B");
		}else if (strike == 0 && ball !=0 ) {
			System.out.println(ball+"B");
		}else{	System.out.println("3O");}
		
		}		}while(strike !=3);
		if (strike == 3) {
			System.out.println("정답입니다. 프로그램을 종료합니다.");
			break;}
		
		
		}
		scan.close();

		}	
		
		

