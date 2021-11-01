package day4;

public class ForSumEx1 {

	public static void main(String[] args) {
		/*1부터 10까지 합을 구하는 코드를 for문을 이용하여 작성하세요.
		 * 1. 1부터 5까지 출력하는 예제 활용
		 * 		sum0 = 0 *sum 함수에 임의로 의미상 숫자를 붙여 설명
		 * i=1  sum1 = sum0 + 1
		 * i=2  sum2 = sum1 + 2
		 * i=3  sum3 = sum2 + 3
		 * ...
		 * i=9  sum9 = sum8 + 9
		 * i=10 sum10= sum9 + 10
		 * 		sum = sum + i
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : sum = sum + i
		 * 반복문 종료 후 sum 출력
		 */
		int sum=0;
		//for문에서만 사용할 수 있는 변수 i를 선언. for문 밖에서 i를 사용하려면 다시 선언해야 하고, for문에 사용했던 값을 이어 사용할 수 없다.
		for(int i = 1 ; i <=10 ; i++) {
			sum = sum + i; // sum += i;
			}
		System.out.println("1부터 10까지의 합 : " + sum);
			
	}
	
}
