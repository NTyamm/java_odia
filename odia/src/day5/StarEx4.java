package day5;

public class StarEx4 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 * 2n(n=1,2,3...)
		 * 2n-1(n=1,2,3...)
		 *     *		i=1 공백 =4  *=1
		 *    ***		i=2 공백 =3  *=3
		 *   *****		i=3 공백 =2  *=5
		 *  *******		i=4 공백 =1  *=7
		 * ********* 	i=5 공백 =0  *=9
		 * 					공백=5-i *=2+1-1
		 *     * 		i=1 공백 =4  *=1 *=0
		 *    ** *		i=2 공백 =3  *=2 *=1
		 *   *** **		i=3 공백 =2  *=3 *=2
		 *  **** ***	i=4 공백 =1  *=5 *=3
		 * ***** **** 	i=5 공백 =0  *=5 *=4
		 * 					공백=5-i *=i *=i-1
		
		 * 반복횟수	: i는 1에서부터 5까지 1씩 증가
		 * 실행문		: 공백을 5-i개 출력하고 *를 출력하고, 다시 5-i개 출력후 엔터 출력
		 * 			반복횟수: j를 5-i로 감소하고 " "를 출력
		 * 			실행문:  
		 */
		//방법1.
		int num=5, i, j;
		i = 1;
		for(i=1;i<=num;i++) {
			for(j=1;j<=num-i;j++){
				System.out.print(" ");
			}
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			for(j=1;j<=i-1;j++) {
				System.out.print("*");
			}
		System.out.println();
		}
		//방법1. 
				i = 1;
		while(i<=num) {
			j=1;
			while(j<=num-i) {
				System.out.print(" ");
			j++;
			}
			j=1;
			while(j<=2*i-1) {
				System.out.print("*");
			j++;
			}
			System.out.println();
			i++;
		}
	}

}
