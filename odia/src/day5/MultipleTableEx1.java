package day5;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		/*2단에서 9단까지 구구단을 출력하는 코드를 작성하세요.
		 * 
		 */
		int num = 2
		while(num <= 9) {
			j=1;
			while(j <= 9) {
				System.out.println(num + "x" + j + " = " + num*j);
				j++;	
			}
						num++;
		}
	}

}
