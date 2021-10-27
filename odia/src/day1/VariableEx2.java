package day1;

public class VariableEx2 {
	//변수명 작성 규칙과 관례 예제
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
			
			int num1 = 0;//가능
			//int 1num = 0;//에러발생. 변수명은 숫자로 시작할 수 없다
			//int num1 =1;//에러발생. 중복선언 불가
			//int _; //에러발생. _만 사용 불가능
			int abc_;//가능
			//int abc^; //에러발생. _와 $만 사용가능
			int 변수;//가능
			//int int;//에러발생. 키워드 사용 불가
			int Num1 = 0;//가능. 대소문자 구분
	}

}
