package day7;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBaseballEx3 {

	public static void main(String[] args) {
		//숫자 야구 게임에서 컴퓨터가 랜덤한 수를 생성하도록 코드를 작성하세요
		int com[] = new int[3];
		int min = 1, max = 9;
		int count = 0;
		//3번 반복
		do{
			//랜덤한 수를 생성
			int random = (int)(Math.random()*(max-min+1)+min);
			//배열에 중복된 값이 있는지 확인하는 반복문
			int i;
			/*count가 0일 때는 반복문이 한 번도 실행 안 됨
			 *count가 1, [0]에 중복된 수가 있으면 반복 문 종료 후 i는 0으로 count값보다 작음 
			 *count가 2, 중복된 수가 있으면 반복문 종료 후 i는 0 or 1번지에 있음*/
			for(i= 0 ; i<count ; i++) {
				//중복된 수가 있으면 반복문을 중단. break에 중단되지 않았다고 하면 count-1까지 i가 증가한 것
				if(com[i] == random) {
					break;
				}
			}
				//반복문 종료 후 i값이 count와 같다는 건 중복된 수가 없어서 break 문이 실행 안 된 경우
				if (i == count) {
					com[i] = random;
					//중복된 수가 없어서 count의 값을 증가시킴
					count++;
				}
			
		}while(count !=3);		
		//컴퓨터가 1~9 사이의 중복되지 않은 세 수를 저장하는 코드를 작성
		//사용자가 무한히 세 수를 입력받음
		Scanner scan = new Scanner(System.in);
		int user[] = new int[3];
		int strike, ball, out;
		while(true) {
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
			 	if (com[i] == user[i]) {
				 ball++;
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
		
		if (strike == 3) {
			System.out.println("정답입니다. 프로그램을 종료합니다.");
			break;}
		
		
		}
		//괄호위치 중요하다ㅜㅜ 
		scan.close();
	}

}
