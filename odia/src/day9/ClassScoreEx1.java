package day9;

import java.util.Scanner;

public class ClassScoreEx1 {

	public static void main(String[] args) {
		/* 국어, 영어, 수학 성적을 관리하기 위한 클래스를 만들고
		 * 학생 5명의 성적을 관리하기 위한 배열을 만드세요.*/
		
		//5명의 학생 정보를 저장할 수 있는 배열을 생성
		Score score[] = new Score[3];
		Scanner scan =new Scanner(System.in);
		for(int i = 0; i<score.length; i++) {
			//new를 통해 학생 정보를 생성하고, 생성자로 초기화
			System.out.println("이름 : ");
			String name = scan.next();
			System.out.println("국어");
			int kor = scan.nextInt();
			System.out.println("영어");
			int eng = scan.nextInt();
			System.out.println("수학");
			int math = scan.nextInt();
			score[i] = new Score(kor, eng, math, name);
		}
		for(Score tmp : score) {
			tmp.printInfo();
		}
		scan.close();
	}

}
class Score { //과목 관리용 클래스
	//1. 멤버변수
	private int kor, eng, math;
	private String name;
	public Score(int kor, int eng, int math, private string) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		String = string;
	} 
	
	//2. 
	
	//기본생성자
	public Score() {}
	//생성자 오버로딩
		public Score(int kor, int eng, int math, Private string) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	
	}
	//학생 정보를 출력하는 메소드
	public void printInfo() {
		System.out.println("이름 : " + name );
		System.out.println("국어 : " + kor));
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
	}
}
