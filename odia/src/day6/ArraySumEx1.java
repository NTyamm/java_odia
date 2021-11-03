package day6;

public class ArraySumEx1 {

	public static void main(String[] args) {
		/*2부터 10사이의 짝수들을 배열에 저장하고, 배열에 저장된 값의 합을 출력하는 코드를 작성하세요.
		 * 정수형 5개짜리 배열 선언
		 * 배열에 2부터 10까지 저장
		 * 배열에 있는 값을 꺼내서 더함(누적)
		 */
		int arr[]=new int[5];
		arr[0] = 2;
		arr[1] = 4;
		arr[2] = 6;
		arr[3] = 8;
		arr[4] = 10;
		//내가 한 거... 2부터 10까지 9번 비교하는 거라 비효율적
		int sum=0;
		for(int i = arr[0] ; i <= arr[4] ; i++) {
			if(i % 2 ==0) {
			sum = sum + i; // sum += i;
			}
		}
		System.out.println("2부터 10까지의 합 : " + sum);
		
		//배열에 있는 값을 꺼내서 다함(누적)
		int sum1=0;
		int i; //번지수?
		sum1 += arr[0];
		sum1 += arr[1];
		sum1 += arr[2];
		sum1 += arr[3];
		sum1 += arr[4];
		System.out.println("2부터 10까지의 합 : " + sum1);
		
		//
		int arr2[] = new int[5];
		for(i = 0; i <5 ; i++) { //향상된 for문 사용 불가능
			arr2[1] = 2 * i + 2; //<이 라인에서 배열의 값을 수정하기 때문
		}
		for(i = 0, sum=0; i<5 ; i++) { //향상된 for문 사용 가능
			sum += arr2[i];			   //배열의 값 수정x기 때문ㅇ
		}
		System.out.println("2부터 10까지의 합 : " + sum);
		
	}

}
