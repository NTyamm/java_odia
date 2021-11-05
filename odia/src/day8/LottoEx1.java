package day8;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx1 {

	public static void main(String[] args) {
		//1~45 사이의 중복되지 않은 6개의 로또 번호와 1개의 보너스번호를 생성
		int min = 1, max = 45, size = 6, size2 = 1;
		int [] lotto = randomArray(min, max, 6);
		
		int bonus = creatBonus(min, max, lotto);
		//당첨번호와 중복되지 않게 보너스 번호를 랜덤으로 생성하여 저장
		

		//당첨번호와 중복되지 않게 1개의 보너스번호를 랜덤으로 생성
		
		
		//당첨번호 출력
		System.out.println("당첨번호 : " + Arrays.toString(lotto));
		
		//보너스번호 출력
		System.out.println("보너스번호 : " + bonus);
		
		Scanner scan = new Scanner(System.in); //구매자 번호 입력용
		int customer [] = new int[6];
			for(int i = 0 ; i<customer.length ; i++ ) {
				customer[i]=scan.nextInt();
		}
		System.out.println("입력번호 : " + Arrays.toString(customer));
		scan.close();
		
		//등수를 출력
				/* 1등 : 당첨번호 6개 전부 일치
				 * 2등 : 당첨번호 5개와 보너스 번호 일치
				 * 3등 : 당첨번호 5개 일치
				 * 4등 : 당첨번호 4개 일치
				 * 5등 : 당첨번호 3개 일치
				 * 꽝 : 나머지
				 */
		rank(lotto,bonus,customer);
	
	}
		/* 기능	: 배열의 크기가 주어지면 주어진 min에서 max사이의 랜덤한 정수를 중복되지 않게 생성하여
	 			  저장하는 메소드
		 * 매개변수: 배열의 크기, 최소값, 최고값 -> int [], int, size
		 * 리턴타입: int []
		 * 메소드명: lottoCom
		 */
	//1~45사이의 중복되지 않은 6개의 로또 번호 생성
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
		/* 기능 	  : 최소값, 최대값, 배열이 주어지면 min~max 사이의 랜덤한 수를 생성하고
		 *   		배열에 있는지 없는지 확인한 후 없으면 해당 수를 알려주는 메소드
		 * 매개변수 : 최소값, 최대값, 배열 -> int min, int max, int []
		 * 리턴타입 : 배열에 없는 min~max 사이의 랜덤한 수-> int
		 * 메소드명 : check
		 * */
		public static int creatBonus(int min, int max, int []arr) {
			int bonus = 0;
			while(true) {
				bonus = (int)(Math.random()*(max-min+1)+min);
				//당첨번호에 보너스가 있으면 조건심으로 점프(이동)하여 다시 번호 생성
				if(containsArray(arr, bonus, arr.length)) {
					continue;
				}
				//당첨번호에 보너스 번호가 없으면 반복문 종료
				break;
			}
			return bonus;
			
		}
		/* 기능		: 두 배열이 주어지면, 두 배열에서 일치하는 정수의 갯수를 알려주는 메소드
		 * 매개변수	: 두 배열 -> int []arr1, int []arr2
		 * 리턴타입	: 일치하는 정수의 갯수 -> int
		 * 메소드명	: check	
		 */
		public static int check(int []arr1, int[]arr2) {
			int count = 0;
			for(int tmp : arr1) {
				//배열 arr2에 배열arr1에서 꺼낸 tmp가 있으면 count를 1 증가
				if(containsArray(arr2, tmp, arr2.length)) {
					count++;
				}
			}
			return count;
		}
		/* 기능		: 로또 번호와 사용자 번호를 이용하여 당첨등수를 출력하는 메소드
		 * 매개변수	: 로또번호, 보너스번호, 사용자번호 -> int []lotto, int bonus, int []customer
		 * 리턴타입	: 없음 -> void
		 * 메소드명	: rank
		 */
		public static void rank(int []lotto, int bonus, int []customer) {
			int count = check(lotto, customer);
			String result = "";
			switch(count) {
			case 6:	result = "1등 당첨!!";	
				break;
			case 5: result = containsArray(customer, bonus, customer.length) ?
						"2등 당첨!":"3등 당첨!";
				break;
			case 4: result = "4등 당첨!";
				break;
			case 3: result = "3등 당첨!";
				break;
			default: result = "꽝";
			}
			
		}
		
		
	

}
