package day9;

public class ClassEx3 {

	public static void main(String[] args) {
		//그린고등학교에 다니는 1학년 11반 1번 홍길동 학생 객체를 생성하고, 학생정보를 출력해보세요
		/*고등학교 학생 정보를 관리하기 위한 클래스를 생성하고, 테스트해보세요.
		 * 클래스명	: HighSchoolStudent
		 * 멤버변수	: 학교명, 학년, 반, 번호, 이름 -> int grade, int classNum, int num, char name
		 * 멤버메소드	: sort
		 * 생성자		: 학년, 반, 번호를 0으로 초기화
		 * */
		
		HighSchoolStudent std1 = new HighSchoolStudent("그린고등학교", 학년, 1, 1, 1);
	}
	

class HighSchoolStudent{
	String schoolName, name;
	int grade, classNum, num;
}
	public HighSchoolStudent() {
		schoolName = "고등학교";
		name = "";
		grade = 1; classNum = 1; num =1;
	
		HighSchoolStudent(String schoolName, String name, int grade, int classNum, int num)	
			this.schoolName = schoolName;
			
	}
	public void printInfo() {
		System.out.println("학교명 : " + schoolName );
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
	}

	}

}
