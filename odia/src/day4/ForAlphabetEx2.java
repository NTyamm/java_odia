package day4;

public class ForAlphabetEx2 {

	public static void main(String[] args) {
		/*'a'부터 'z'까지 툴력하는 코드를 for문을 이용하여 작성하세요.
		 * abcdefghijk...xyz 
		 * 방법1)
		 * 반복횟수 : i는 0부터 26보다 작을 때까지 1씩 증가
		 * 규칙성	  : 문자 'a'+i를 출력
		 * 방법2)
		 * 반복횟수 : ch는 'a'부터 'z'까지 1씩 증가
		 * 규칙성	  : ch를 출력
		 */
		char ch;
		for(ch = 'a' ; ch <= 'z' ; ch++ ) {
		System.out.print(ch);
		}
		System.out.println(" ");
		//방법1 : 난...모르겠다...
		int i = 0; //초기화
		for( ; i < 26 ; i++) //초기화 생략
			System.out.print((char)('a' + i)); //자료형변환 추가
	}

}
