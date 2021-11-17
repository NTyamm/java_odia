package day16;

import java.util.ArrayList;
import java.util.Scanner;

import day16.ExbListEx2.ExbStudent;

public class ExbListEx3 {

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
			case 3:	deleteStudent(stdList) break; //를 만들어야함 
					//삭제할 학생 정보 입력
			System.out.print("삭제할 학생 정보를 입력하세요");
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("학반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
					//방법1. 삭제할 학생 정보가 몇번지에 있는지 확인하고 있으면 해당 번지에 있는 학생 정보 삭제
					//ExbStudent 클래스의 equals를 오버라이딩 해야함
					//리스트에 특정 객체가 있는지 확인할 때 사용하는 메소드 : contains, indexOf
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
			case 4: break;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
		}while(menu != 4);//3번 메뉴를 선택하면 반복문 종료
		System.out.println("프로그램을 종료합니다.");
	}

}
