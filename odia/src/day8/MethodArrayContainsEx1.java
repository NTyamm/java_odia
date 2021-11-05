package day8;

import java.util.Arrays;

public class MethodArrayContainsEx1 {

	public static void main(String[] args) {
		/* 배열이 다음과 같이 주어지고, 정수가 주어졌을 때 정수가 배열에 있는 값인지 아닌지 확인하는 메소드를 정의하고, 호출하여 확인
		 * 배열에 1~45사이의 랜덤한 수를 생성하여 저장하는 코드를 작성하세요.
		 * 단, 중복 불가, 메소드 이용*/
		int [] lotto = {5, 18, 23, 35, 40, 1};
		int num = 36;
		if(containsArray(lotto, num)) {
			System.out.println(num+"는 배열에 있다.");
		}
		else {
			System.out.println(num+"는 배열에 없다.");
		}
		if(containsArray2(lotto, num,7)) {
			System.out.println(num+"는 배열에 있다.");
		}
		else {
			System.out.println(num+"는 배열에 없다.");
		}
		
		int []lotto2 = randomArray(1, 45, 6);
		System.out.println(Arrays.toString(lotto2));
	}
	/*기능		: 배열에 정수가 주어지면 정수가 배열에 있으면 true를, 없으면 false를 알려줌	
	 * 매개변수 : 배열과 정수 => int []arr, int num
	 * 리턴타입 : 있다/없다 => true/false => boolean
	 * 메소드명 : containsArray
	 * */
	public static boolean containsArray(int []arr, int num) {
		for(int tmp : arr) {
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}
	/*기능	: 배열 arr과 정수 num가 주어지면 배열에서 0번진부터 n중에 num가 있는지 없는지 알려주는 메소드
	 * *       없는지 알려주는 메소드
	 * 매개변수 : 배열과 정수, 확인할 갯수=> int []arr, int num, int n
	 * 리턴타입 : 있다/없다 => true/false
	 * 메소드명 : containsArray2
	 */
		public static boolean containsArray2(int []arr, int num, int n) {
			//배열의 길이보다 검사하는 갯수가 많으면 검사 갯수를 배열의 길이로,
			//아니면 원래 검사 개수로 변경
			n = arr.length < n ? arr.length : n;
			for(int i = 0; i<n; i++) {
				if(arr[i] == num) {
					return true;
				}
			}
			return false;
		}
		/*기능 : 배열의 크기가 주어지면 주어진 min에서 max사이의 랜덤한 정수를 중복되지 않게 생성하여
	 			저장하는 메소드
		매개변수: 배열의 갯수, 최소값, 최대값-> int min, int max, int size
		리턴타입:	배열 int []
		메소드명: randomArray */
	public static int[] randomArray(int min, int max, int size) {
		int [] arr = new int[size]; //배열의 크기 설정
		for(int count = 0; count < size ; ) { //반복횟수 설정
			//random과 배열을 비교하여 중복된 숫자가 없으면
			if(!containsArray2(arr, random, count)) {
				arr[count++] = random;
			}
		}
		return arr; //초기화를 해줘야 함. 초기화 값으로는 null을 많이 쓴다. 여기선 배열arr로 보내줘야 함
	}
}
