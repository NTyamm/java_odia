package day8

import java.util.Arrays;
import java.util.Scanner;

import com.sun.tools.jdeprscan.scan.Scan;

public class BasballEx1 {

	public static void main(String[] args) {
		/* 6일차 숫자 야구게임 예제와 lotto 예제를 이용하여 숫자 야구게임을 작성하세요.
		 * 단, 메소드를 생성하여야 하고, 컴퓨터가 생성하는 번호는 랜덤이어야 합니다..
		 */
		int min = 1, max = 9, size =3;
		int count = 0;
		int []com = randomArray(min, max, size);
		System.out.println(Arrays.toString(com));
		Scanner scan = new Scanner(System.in); //스캐너는 프로그램에서 단 한 번 밖에 만들지 못하기 때문에 뒤에 두어야 함
			//사용자가 무한히 세 수를 입력 받음
			int user[] = new int[3];
			int strike = 0, ball = 0;
				
			do {
				System.out.print("사용자 : ");
				inputArray(user, scan);
			
				//스트라이크 갯수
				strike = getStrike(com, user);
					
				//볼의 갯수를 계산
				ball = getBall(com, user);
					
				//결과 판별
				printResult(strike, ball);
					
			}while(strike != 3);
				
			System.out.println("정답입니다. 프로그램을 종료합니다.");
			scan.close();
	}
	
	//컴퓨터 랜덤 숫자 생성
	public static boolean containsArray(int []arr, int num, int n) {
		//배열의 길이보다 검사하는 갯수가 많으면 검사 갯수를 배열의 길이로,
		//아니면 원래 검사 개수로 변경
		n = arr.length < n ? arr.length : n;
		for(int i = 0; i<n; i++) {
			if(arr[i] == num) {
				return true;
			}
		}return false;
	}
	
	public static int [] randomArray(int min, int max, int size) {
		int []arr = new int [size];
		for(int count = 0; count<size; ) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//random과 배열을 비교하여 중복된 숫자가 없으면 중복된 숫자가 없으면
				if(!containsArray(arr, random, count)) {
					arr[count++] = random;
				}
			}
					return arr;
					
	}
		//-------------------------------------------------------
		
		/* 기능		: 두 배열이 주어지면 스트라이크 갯수를 알려주는 메소드
		 * 매개변수	: 두 배열 -> int []com, int []user
		 * 리턴타입	: 스트라이크 갯수 -> 정수 -> int
		 * 메소드명	: getStrike
		 */
		public static int getStrike(int[]com, int[]user) {
			int count = 0;
			for(int i = 0; i<com.length ; i++) {
				if(com[i] == user[i]) {
					count++;
				}
			}
			return count;
		}
		/* 기능		: 두 배열이 주어지면 볼의 갯수를 알려주는 메소드
		 * 매개변수	: 두 배열 -> int []com, int []user
		 * 리턴타입	: 스트라이크 갯수 -> 정수 -> int
		 * 메소드명	: getBall
		 */
		public static int getBall(int[]com, int[]user) {
			int count = 0;
			for(int tmp : com) {
				if(containsArray(user, tmp, user.length)) { // tmp와 com을 비교해서 하나라도 겹치면 무조건 카운트(볼과 스트라이크 전부 포함)
					count++;
				}
			}
			return count - getStrike(com,user); //겹치는 숫자를 전부 구한 후 스트라이크 갯수를 빼면 볼 갯수가 된다
		}
		
		/* 기능		: 스트라이크와 볼의 갯수가 주어지면 결과를 콘솔에 출력하는 메소드
		 * 매개변수	: 스트라이크와 볼의 갯수 -> int strike, int ball
		 * 리턴타입	: 없음 -> void
		 * 메소드명	: printResult
		 */
		public static void printResult(int strike, int ball) {
			if(strike != 0) {
				System.out.print(strike + "S");
			}
			if(ball != 0) {
				System.out.print(ball + "B");	
			}
			if(strike == 0 && ball == 0) {
				System.out.print("3O");
			}
			System.out.println();
		}
		/* 기능		: Scanner와 배열이 주어지면 Scanner를 통해 배열의 길이만큼 배열에 정수를 입력하는 메소드
		 * 매개변수	: Scanner와 배열 -> int [] arr
		 * 리턴타입	: 없음 -> void
		 * 메소드명	: inputArray
		 */
		public static void inputArray(int []arr) {
			for(int i = 0; i<arr.length; i++) {
				arr[i] = scan.nextInt();
					
		}
		
	}
}
