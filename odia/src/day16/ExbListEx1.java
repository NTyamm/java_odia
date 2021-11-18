package day16;

import java.util.*;

import day16.ExbStudent;

public class ExbListEx1 {

	public static void main(String[] args) {
		/* 그린고등학생의 국어, 영어, 수학 성적을 관리하려 한다.
		 * 관리하기 위한 리스트를 만들어 보세요. */
		//학년, 반, 번호, 이름, 국어성적, 수학성적, 영어성적을 분류할 수 있어야 한다.
		//클래스랑 메소드를 활용하는 게 편리할 것 같은데 메소드 아직 얼레벌레 따라가느라 바쁨...
		/* 국어, 영어, 수학 성적을 각각 리스트로 만들어서 관리 방법
		 * 번지가 같으면 같은 학생의 성적이라는 가정 필요
		 * 가능은 하지만 좋은 방법은 아님 */
		ArrayList<Integer> KoExbStudent = new ArrayList<Integer>();
		ArrayList<Integer> MaExbStudent = new ArrayList<Integer>();
		ArrayList<Integer> EnExbStudent = new ArrayList<Integer>();
		/* 국어, 영어, 수학 성적을 같이 다룰 수 있는 클래스를 만들어서 활용하는 방법*
		 */
		//클래스는 이전에 활용한 걸 그대로 써도 될 것 같은데... 
		//그걸 리스트화하려면? 학생이름-국-영-수 순서로 알아서 출력되는 것이? 학생이름+성적들은 비효율적이지 않은가?
		//그렇다면 Integer말고 String도 List에 추가해야..String List와 Integer List를 합칠 수 있나? 
		//번지수를 몰라도 알아서 맞춰서 출력되면 좋겠는데... 
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		Scanner scan = new Scanner(System.in);
	
		/*학생 정보를 입력받고 계속할건지를 물어봐서 y라고 대답하면 계속하고 아니면 종료*/
		char next = 'y';
		while(next == 'y' || next == 'Y') {
			//방법1 : 첫번째 inputStudent 메소드 이용
		/*	ExbStudent std 
			= inputStudent(scan);
			stdList.add(std);
			System.out.println("학생정보를 더 입력하시겠습니까?");
			next = scan.next().charAt(0); //문자열의 첫번째 값을 가져오기 위해 0을 삽입 */
			
			//방법2 : 두번째 inputStudent 메소드 이용
			inputStudent(scan, stdList);
			
			System.out.println("학생 정보를 더 입력하겠습니까?");
			next=scan.next().charAt(0);
		}

		/*입력받은 학생정보를 출력 : iterator 이용 */
		printStudentList(stdList);
		
		//위의 코드를 이용하여 학생 정보를 입력하는 메소드와 학생 정보들을 출력하는 메소드를 만들어 보세요. *메인에 만들면 됨
		scan.close();
	}
	//학생정보를 입력하는 메소드
	/* 기능	: Scanner를 이용해 학생 정보와 성적을 입력받아 list로 넣어줌 //기능을 구체화해야함. 리턴타입을 알기 쉽게.
	 * 매개변수: 학년, 번호, 이름... String과 Int
	 * 리턴타입: 리스트...로 만들기 ? 리스트로 리턴이 되던가? ->오버라이드로 출력가능할 거 같음.
	 * 메소드명: */
	//public static void inputInfo(Scanner scan) {}
		//System.out.print("학생정보를 입력하세요.");
		//위쪽이랑 똑같이 while문으로 입력받아도 되는건가??? stdInfo.add 같은 거 이용하고 싶은데..가능한가?
	
	
	//학생정보를 출력하는 메소드 ^ 위와 합쳐도 될지 나눠야할지는 천천히 생각
	/* 기능	: 리스트를..출력함
	 * 매개변수: 리스트겠지...?
	 * 리턴타입: void
	 * 메소드명: print */
	//public static void printList (리스트...가능??) { } 
	
	//아래로는 강사님
	/* 기능 : Scanner를 이용하여 학생 정보와 성적을 입력받아 입력받은 학생정보를 알려주는 메소드
	 * 매개변수 : Scanner -> Scanner scan
	 * 리턴타입 : 입력받은 학생 정보 -> ExbStudent
	 * 메소드명: inputStudent
	 */
	public static ExbStudent inputStudent(Scanner scan) {
			System.out.println("학생 정보를 입력하세요.");
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("학반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			System.out.print("이름 : ");
			/*nextLine()을 이용하는 경우 앞에서 앞에서 Scanner를 통해 입력받은 값 중 엔터가 사라지지 않는 상황이면
			 * 실제 사용하려는 nextLine()앞에 nextLine()을 한 번 더 입력해야 한다.*/
			scan.nextLine(); //엔터처리
			String name = scan.nextLine();
			System.out.println("성적을 입력하세요.");
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			System.out.print("수학 : ");
			int math = scan.nextInt();
			ExbStudent std 
			= new ExbStudent(grade, classNum, num, name, kor, eng, math);
			return std;
	}
	 
	/* 기능 : Scanner를 이용하여 학생 정보돠 성적을 입력받아 입력받은 학생정보를 주어진 리스트에 넣어주는 메소드
	 * 매개변수 : Scanner, 주어진 리스트 -> Scanner scan, ArrayList<ExbStudent> stdList
	 * 리턴타입 : 리스트에 넣고 끝남 -> 필요없음 -> void
	 * 메소드명 : inputStudent
	 */ 
	public static void inputStudent(Scanner scan, ArrayList<ExbStudent> stdList) {
		ExbStudent std = inputStudent(scan); //오버로딩을 이용해 위에서 작업한 메소드 이용 가능 
				stdList.add(std);
	}
	
	/* 기능 : 학생 리스트가 주어지면 주어진 학생정보를 출력하는 메소드
	 * 매개변수 : 학생리스트 - >ArrayList<ExbStudent> stdList
	 * 리턴타입 : 없음 -> void
	 * 메소드명 : printStdList
	 */
	public static void printStudentList(ArrayList<ExbStudent> stdList) {
		Iterator<ExbStudent> it = stdList.iterator();
		while(it.hasNext()) {			//리스트에서 하나씩 꺼내서
			ExbStudent tmp = it.next(); //tmp에 저장
			System.out.println(tmp);
		}
	}
	

//이런 식으로 클래스를 나누면???

}