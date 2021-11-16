package day14;

public class ExdTryCatchEx1 {

	public static void main(String[] args) {
		/* try ~ catch 문을 이용한 예외처리*/
		int num1 = 1, num2 = 0;
		int res;
		try {
			res = num1/ num2;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 번지로 배열에 접근");
		}catch(ArithmeticException e) { //자손
			//printStackTrace() : 예외가 발생된 정보들을 콘솔에 출력하는 메소드
			e.printStackTrace(); //예외 발생 라인 추적
			System.out.println(e.getMessage()); //예외 정보를 간단히 문자열로 출력하는 메소드
			System.out.println("0으로 나눔");
		}catch(Exception e) { //조상 순으로 가야함. 조상-자손 
			System.out.println("모든 예외 처리");
		}System.out.println("프로그램 종료");
	}

}
