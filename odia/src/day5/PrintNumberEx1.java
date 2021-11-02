package day5;

public class PrintNumberEx1 {

	public static void main(String[] args) {
		/*다음과 같이 출력하도록 코드를 작성하세요.
		 * 1 2 3 i=1 시작숫자 : 1
		 * 4 5 6 i=2 시작숫자 : 4
		 * 7 8 9 i=3 시작숫자 : 7
		 * 			 시작숫자 : 3*1 - 2
		 * 방법1 : 3의 배수마다 숫자 출력 후 엔터를 침
		 */
		//방법1
		int i, j;
		for(i=1;i<=9;i++) {
			System.out.print(i+" ");
			if(i % 3 == 0) {
				System.out.println();
			}
			
		}
		//방법2
		for(i=1;i<=3;i++) {
			for(j=3*i-2;j<=3*i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
