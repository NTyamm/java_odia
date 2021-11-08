package day9;

public class MethodParameterEx1 {

	public static void main(String[] args) {
		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1,2,3,4));
//		System.out.println(sum2()); //에러발생 : 매개변수가 없어서
		int arr[] = new int[] {1};	//배여러을 넣을 때 에러 발생을 막으려면
		System.out.println(sum2(arr)); //매개변수를 이런 식으로 넣어줘야 한다.
		System.out.println(sum2(new int[] {1}));
		System.out.println(sum2(new int[] {1,2}));
		System.out.println(sum2(new int[] {1,2,3}));
		System.out.println(sum2(new int[] {1,2,3,4}));
		printInfo(1,1,1, "홍길동" , "홍길동", "활빈당", "영웅");
		printInfo(1,1,2, "임꺽정, "임꺽정", "도둑", "의적");

	}
	/* 기능		: 정수가 주어지면 정수의 합을 알려주는 메소드
	 * 매개변수 	: 정수 ( 하나일 수도, 여러 개일 수도) -> int ... nums//nums는 배열이 됨
	 * 리턴타입	: 정수의 합 -> 정수 -> int
	 * 메소드명	: sum	 */
	public static int sum(int ...nums) {
		int sum = 0;
		for(int i=0 ; i<nums.length; i++) {
			sum +=nums[i];
		}
		return sum;
	}
	public static int sum2(int []nums) {
		int sum = 0;
		for(int i=0; i<nums.length;i++) {
			sum += nums[i];
		}
	}
	/* 기능		: 학생 학년, 반, 번호, 이름, 별명들이 주어지면 학생 정보를 콘솔에 출력하는 메소드
	 * 매개변수	: 학년, 반, 번호, 이름 별명(0~여러개)
	 * 			 -> int grade, int classNum, int num, String name
	 * 			 ->String ... nickname
	 * 리턴타입	: 없음 -> void
	 * 메소드명	: printInfo
	 */
	public static void printInfo(int grade, int classNum, int num, String name, String ...nicknames) {
		System.out.println("학년 : "+ grade );
		System.out.println("반 : "+ classNum);
		System.out.println("번호 : "+ num );
		System.out.println("이름 : "+ name );
		System.out.println("별명 : " );
		for(int i=0; i<nicknames.length;i++) {
			System.out.print(nicknames[i]+" ");
		}
		System.out.println();
	}
	
	
//	public static void printInfo2(int grade, int classNum, int num, String ...nicknames, String name) {}
	 //p.129 첫번째 일반 매개변수와 가변 매개변수를 섞어 쓸 때 가변 매개변수를 마지막에 써야 함
	 //이름도 문자열, 닉네임도 문자열이라 동일한 자료형이 섞여 있는 상태에서 가변인자가 먼저 나오면 에러가 난다
	
//	public static void printInfo3(int ...grade, String ...nams) {}
	//p.130 가변매개변수는 하나씩만 올 수 있다.
}
