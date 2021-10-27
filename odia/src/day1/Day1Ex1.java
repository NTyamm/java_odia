package day1;

public class Day1Ex1 {

	public static void main(String[] args) {
		/* 핸드폰 번호를 -없이 저장하여 관리하려 한다.
		 * 초기값으로 01012345671을 저장하여 관리해 보세요.
		 */
		//int phone1 = 01012345671;
		//System.out.println(phone1);
		//앞에 0이 붙어서 8진수로 바뀌어 출력
		String phone = "01012345671";
				System.out.println(phone);
		/*성별을 저장하여 관리하려 한다. 알맞은 변수를 선언하고 초기값을 남자로 설정
		 * 단, 성별은 남자와 여자만 있다고 가정
		 */
		boolean isMale = true; //비교시 용이
		String gndr = "male"; //남녀 구분해서 관리시 용이
		int isMale2 = 13;//이 경우 13:남자 24:는 여자라는 걸 기억해둬야해서 불편함
	}

}
