package day2;

public class IfNumex1 {

	public static void main(String[] args) {
		/* num가 0보다 크면 양수라고 출력하고
		 * num가 0이면 0이라고 출력하고
		 * num가 0보다 작으면음수라고 출력하는 코드를 작성하세요.
		 */
		int num = 5;
		if( num > 0) {
			System.out.println(num + "은 양수다.");
		}else if( num == 0) {
			System.out.println(num + "은 0이다.");
		}else {
			System.out.println(num + "은 음수다.");
		}

		//정수가 0보다 크지 않고, 정수가 0과 같지 않은 수 = 음수
		if(num > 0) {
			System.out.println();
		}
		
	}

}
