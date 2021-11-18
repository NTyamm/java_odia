package Day3;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

public class SwitchEvenEx1 {

	public static void main(String[] args) {
		/*Switch문을 이용하여 정수의 홀짝 여부를 판별하는 코드를 작성하세요.
	    */
	int num = 10;
	switch (num % 2) {
		case 0:
			System.out.println(num + "는 짝수");
			break;
		default:
			System.out.println(num + "는 홀수");
	}
	}

}
