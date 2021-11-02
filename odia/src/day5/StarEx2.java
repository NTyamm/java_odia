package day5;

public class StarEx2 {

	public static void main(String[] args) {
		/*다음과 같이 출력되도록 반복문을 이용하여 코드를 작성하세요.
		 * *	i=1 *=1 엔터
		 * **	i=2 *=2 엔터
		 * ***	i=3 *=3 엔터
		 * **** i=4 *=4 엔터
		 * *****i=5 *=5 엔터
		 * 
		 * 반복횟수 : i는 1부터 5까지 1개씩 증가
		 * 규칙성	 : *을 i개 출력하고 엔터를 출력
		 * 			반복횟수 : j를 1부터 i까지 1씩 증가
		 * 			규칙성 : *를 출력
		 * 			반복문 종료 후 엔터를 출력
		 */

		int i, j;
		for (i = 1 ; i <= 5 ; i++) {
			for(j = 1 ; j <= i; j++)
				System.out.print("*");
				System.out.println();
			}
		
		i = 1;
		while(i<=5) {
			j=1;
			while(j<=i) {
				System.out.println("*");
				j++;
			}
			System.out.println();
			i++;
		
		}
	}
}


