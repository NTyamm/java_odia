package day14;

public class ExcWrapperEx1 {

	public static void main(String[] args) {
		int num = 10;
		Integer numi = num; //Wrapper 클래스 Integer가 참조변수 numi를 정수 num으로 자동변환시켜줌 ->내 정리
		//print에 정수를 넣었는데 동작하는 이유는 int형 num가 Integer로 오토박싱이 되어 실행이 가능 -> 정식필기
		print(num);//print((Integer)num);
		print(numi);
		numi = 20;
		num = numi; //Integer 객체 numi를 num에 오토 언박싱
		System.out.println(numi);
		
		/*numi = null;
		num = numi;*/ //예외발생, null을 정수로 변환할 수 없다.

	}
	public static void print(Object obj ) {
		System.out.println(obj.toString());
	}

}
