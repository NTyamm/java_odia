package day2;

public class LogicEx1 {
	public static void main(String[] args) {
		//&&연산자 예제, A학점 판별을 이용
		int score = 85;
		//score가 100점 이하이고, score가 90점 이상이다.
		//score가 100점보다 작거나 같고, score가 90점보다 크거나 같다.
		boolean isA = score <= 100 && score >=90;
		System.out.println(score + "점은 A학점인가?" + isA);

		//driverLicense, restrationCard가 true이면 있음, false이면 없음
		boolean driverLicense = true, registrationCard = false;
		//운전면허증이 있거나 주민등록증이 있으면 응시 가능
		boolean testOk = driverLicense || registrationCard;
		System.out.println("시험 응시 가능?" + testOk);
		
		//!연산자 예제. 남녀 구분
		//isMale이 true이면 남자, flase이면 여자
		boolean isMale = true;
		System.out.println("남자인가?" + isMale);
		System.out.println("여자인가?" + !isMale);
		
		//isA = score && score; //에러 발생, &&연산자 양 옆에 참거짓 판단할 수 있는 조건식이 없기 때문
		
	}

}
