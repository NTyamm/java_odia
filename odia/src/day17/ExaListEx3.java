package day17;

import java.util.*;

import day16.ExbStudent;

public class ExaListEx3 {

	public static void main(String[] args) {
		/* 그린고등학생의 국어, 영어, 수학 성적을 관리하려 한다.
		 * 관리하기 위한 리스트를 만들어 보세요. */
		//학년, 반, 번호, 이름, 국어성적, 수학성적, 영어성적을 분류할 수 있어야 한다.
		
		int menu = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		/*학생 정보를 입력받고 계속할건지를 물어봐서 y라고 대답하면 계속하고 아니면 종료*/
	
		
		/* 학생 정적을 관리하는 프로그램을 만들어 보세요.
		 * 메뉴
		 * 1. 학생정보 추가
		 * 2. 전체 학생정보 출력
		 * 3. 학생 정보 삭제(삭제할 학생의 정보를 입력하여 일치하는 학생의 정보를 삭제)
		 * 4. 학생 정보 수정
		 * 5. 프로그램 종료*/
		//게시판 프로그램 응용
		//학생리스트 만들어주고 메소드를 이용해 프로그램 메뉴 출력
		do {
			//메뉴를 입력
			printMenu(scan);
			//입력받은 메뉴에 따른 기능 실행
			switch(menu) {
			case 1: inputStudent(scan, stdList);	break;
			case 2:	printStudentList(stdList);	break;
			case 3:	deleteStudent(scan, stdList) break; //를 만들어야함 
					//삭제할 학생 정보 입력
			//특정 학생 정보 수정 : 이름, 성적만 수정할 건지, 학년, 반, 번호, 이름, 성적을 수정할지 생각
			//강사님은 이름, 성적만 수정하는 것으로 진행
			case 4: if(modifyStudent(scan,stdList)) {
				System.out.println("학생 정보를 수정했습니다.");
			}else {
				System.out.println("일치하는 학생정보가 없습니다.");
			}	
					break;
			case 5: break;
			default :
				System.out.println("잘못된 메뉴입니다");
			}
			
		
		}while(menu != 5);
		System.out.println("프로그램을 종료합니다.");
	}
	
	public static void printMenu(Scanner scan) {
		System.out.println("[메뉴]");
		System.out.println("1. 학생정보 추가");
		System.out.println("2. 전체 학생정보 출력");
		System.out.println("3. 학생 정보 삭제");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요(1~3) : ");
		int menu = scan.nextInt();
	
	}
	
	public static ExbStudent inputStudent(Scanner scan) {
		System.out.println("학생 정보를 입력하세요.");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");

		scan.nextLine(); //엔터처리
		String name = scan.nextLine();
		System.out.println("성적을 입력하세요.");
		System.out.print("국어 : ");
		int kor = scan.nextInt();
		System.out.print("영어 : ");
		int eng = scan.nextInt();
		System.out.print("수학 : ");
		int math = scan.nextInt();
		ExbStudent std = new ExbStudent(grade, classNum, num, name, kor, eng, math);
		return std;
		
	

	public static void inputStudent(Scanner scan, ArrayList<ExbStudent> stdList) {
		ExbStudent std = inputStudent(scan); //오버로딩을 이용해 위에서 작업한 메소드 이용 가능 
				stdList.add(std);
	}
	
	public static void printStudentList(ArrayList<ExbStudent> stdList) {
		Iterator<ExbStudent> it = stdList.iterator();
		while(it.hasNext()) {			//리스트에서 하나씩 꺼내서
			ExbStudent tmp = it.next(); //tmp에 저장
			System.out.println(tmp);
		}
	}
	
	/* 기능	: 주어진 리스트에 Scanner를 통해 입력받은 학생정보를 삭제하여 삭제됐는지 알려주는 메소드
	 * 매개변수 : 주어진 리스트, Scanner -> ArrayList<ExbStudent> stdList, Scanner scan
	 * 리턴타입 : */
	public static boolean deleteStudent(Scanner scan, ArrayList<ExbStudent> stdList) {
		System.out.print("삭제할 학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		ExbStudent std = new ExbStudent(grade, classNum, num, "",0,0,0);
		/*
		int index = stdList.indexOf(std);
				//있으면 해당 번지에 있는 학생 정보 삭제
		if(index >= 0) {
			stdList.remove(index);
			System.out.println("학생정보를 삭제했습니다.");
		}else {
			System.out.println("일치하는 학생 정보가 없습니다.");
		}
		*/
				//방법2. 학생 정보를 삭제했을 때 해당 학생 정보가 있으면 삭제되었습니다/ 없으면 삭제할 학생 정보가 없습니다를 출력
		return stdList.remove(std);
				//방법3.
	}
	
	/* 기능	: Scanner를 이용하여 수정할 학생 정보와 성적, 이름을 입력받고,
	 * 		 입력받은 학생 정보를 주어진 리스트에서 수정하여 수정 됐는지 안됐는지 알려주는 메소드
	 * 매개변수: Scanner, 주어진 리스트 -> Scanner scan, ArryList<ExbSutdent> stdList
	 * 리턴타입: 수정 됐는지 안됐는지 -> boolean 
	 * 메소드명: modifyStudent
	 * */
	public static boolean modifyStudent(Scanner scan, ArrayList<ExbSutdent> stdList) {
		//특정 학생 정보 입력
		System.out.print("삭제할 학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
				//특정 학생 정보가 있으면 이름, 성적을 입력 받음
				//특정 학생 정보의 번지가 0 이상이면 이름, 성적을 입력 받음
		ExbStudent std = new ExbStudent(grade, classNum,num,"",0,0,0);
		int index = stdList.indexOf(std);
		if(index>=0) {
			System.out.print("이름 : ");
			String name = scan.nextLine();
			System.out.println("성적을 입력하세요.");
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			System.out.print("수학 : ");
			int math = scan.nextInt();
						//학생 정보 수정
						//방법1.get 이용
						//리스트에서 학생 정보를 가져와서 이름과 성적만 수정
			/*std = stdList.get(index);
			std.setName(name);
			std.setKor(kor);
			std.setEng(eng);
			std.setMath(math); */
						//방법2.set 이용
						//입력받은 학생 정보와 이름, 성적을 하나의 객체로 만들어서 리스트에 수정하는 방법
			std = new ExbStudent(grade, classNum, num, name, kor, eng, math);
			stdList.set(index,  std); //4줄 수정하느니 한 줄로 새로 만들어버리는 방법
		}
		
				//없으면 끝
	}
}
