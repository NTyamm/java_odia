package day4;

public class ForInfinityLoop {

	public static void main(String[] args) {
		/* 무한루프 : 반복문이 종료되지 않은 상황
		 * 1. 조건식을 생략한 경우(for문만 해당, while문과 do while문은 아님)
		 * 	- 반복문 밑에 코드를 작성하면 에러가 발생
		 * 	- 무한 루프에 의해 실행될 수 없기 때문
		 * 2. 조건식을 잘못설정하여 무조건 참이 된 경우
		 * -i를 1로 착각해서 오타내는 경우
		 * 3. 증갑식을 설정하지 않아서 같은 값으로 계속 반복하는 경우
		 * 	-위의 1, 2번의 경우 반복문 밑에 코드를 작성하면 에러 표시가 뜨지만 반복문 밑에 코드 작성해도 에러 표시가 안 뜸
		 */
		
		//무한루프 1
		/*
		for ( ; ; ){
			System.out.println("Hello");
		}
		*/
		//System.out.println("왜 에러가 발생할까요?");
		
		//무한루프2
		/*
		int i;
		for(i = 1 i<=5; i++) {
			System.out.println("Hello");
		}
		System.out.println("에러 발생");
		*/
		
		//무한루프3
		/*for(i = 1 ; i != 5 ; ) {
			System.out.println("Hello");
		}
		System.out.println("에러 발생하지 않음");
		*/
	}
	

}
