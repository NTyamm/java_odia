package day14;

public class ExdExceptionEx1 {

	public static void main(String[] args) {
		/*예외 1 : ArithmeticException
		 * 1/0d은 ArithmeticException이 발생하는데
		 * 1.0/0은 발생하지 않음*/
		int num1 = 1, num2 = 0;
		//int res1 = num1 / num2;
		//System.out.println(num1 + " / " + num2 + " = " +res1); 예외발생
		double res2 = (double)num1 /num2;
		System.out.println(num1 + " / " + num2 + "=" +res2);
		
		/* 예외2 : ArrayIndexOutOfBoundsException*/
		int []arr = new int[3];
		//arr[3] = 0;
		
		/* 예외3 : NullPointException
		 * 참조변수(객체)가 null인 상태로 멤버 변수/메소드를 호출할 때 발생 */
		String str = null;
		//System.out.println(str.contains("Hello"));
	}

}
