package day18;

import java.util.*;

public class ExfBoardEx1 {

	public static void main(String[] args) {
		/* 게시글을 관리하는 프로그램을 만드세요. 
		 * 기능
		 * 1. 게시글 등록
		 * 2. 게시글 확인(전체)
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 프로그램 종료
		 * */
		//입력받을 스캐너 생성
		Scanner scan = new Scanner(System.in);
		//게시글 번호, 게시글 갯수 제목, 내용, 작성자, 작성일, 리스트로 넣기...ArrayList<>();
		List<ExfBoard> list = new ArrayList<ExfBoard>();
		//메뉴 출력
		while(true){
			//반복-게시글 등록: 게시글 제목, 내용, 작성자 입력받아 리스트에 추가후 "글을 등록했습니다." 출력
			/* 기능
			 * 1. 게시글 등록
			 * 2. 게시글 확인(전체)
			 * 3. 게시글 수정
			 * 4. 게시글 삭제
			 * 5. 프로그램 종료
			 * */
			System.out.println("Menu");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 조회");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 게시글 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.println("============");
			System.out.println("메뉴 선택 : ");
			
			//반복-메뉴입력
			char ch = scan.next().charAt(0);
			System.out.println("------------");			
			
			//메뉴실행
			if(ch == '1' ) {
				System.out.println("==게시글 등록==");
				scan.nextLine();
				System.out.println("제목 : ");
				String title = scan.nextLine();
				System.out.println("내용 : ");
				String contents = scan.nextLine();
				System.out.println("작성자 : ");
				String writer = scan.nextLine();
		
				//입력한 정보를 이용해 게시글 하나 생성
				ExfBoard board = new ExfBoard(title, contents, writer);
			
				//생성된 게시글을 리스트에 추가
				list.add(board);
				System.out.println("게시글이 등록되었습니다.");
				System.out.println("=================");
			}else if(ch == '2') {
				for(ExfBoard tmp : list) {
					System.out.println("=============");
					System.out.println(tmp);
					System.out.println("=============");
				
				}
				System.out.println(list);
			}else if(ch == '3') {
			//수정할 게시글 선택
			System.out.println("게시글을 수정합니다.");
			System.out.println("번호 : ");
			int num = scan.nextInt();
			scan.nextLine();
			System.out.println("제목 : ");
			String title = scan.nextLine();
			System.out.println("내용 : ");
			String contents = scan.nextLine();
			
			//리스트에서 수정할 게시글 정보 가져옴
			ExfBoard tmp = new ExfBoard();
			tmp.setNum(num);
			int index = list.indexOf(tmp);
			//수정할 게시글이 있으면 수정 후 안내문구 출력
			if(index > 0) {
				System.out.println("게시글을 수정했습니다.");
			}
			//없으면 없다고 안내문구 출력
				else {
				System.out.println("게시글을 찾을 수 없습니다.");
			}
			
			}else if(ch == '4') {
			//삭제할 게시글 번호 입력
			System.out.println("게시글을 삭제합니다.");
			System.out.println("삭제할 게시글 번호 : ");
			int num = scan.nextInt();
			//리스트에 해당 게시글이 있는지 확인
			ExfBoard tmp = new ExfBoard();
			tmp.setNum(num);
			int index = list.indexOf(tmp);
			//리스트에 게시글이 있으면 삭제후 삭제안내
			if(index >=0) {
				list.remove(index);
				System.out.println("게시글이 삭제되었습니다.");
			}else{
				System.out.println("없는 게시글입니다.");
			//리스트에 게시글이 없으면 해당 게시불이 없다고 안내
			}
			}else if(ch == '5') {
			System.out.println("프로그램을 종료합니다.");
			break;
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
			
			
			//->게시글 번호, 제목, 내용, 작성자, 작성일, 조회수 출력
			//반복-게시글 수정: 게시글 제목, 내용만 수정받아 리스트에 덮어쓴 후 "글을 수정했습니다." 출력
			//반복-삭제 후 "삭제되었습니다"출력 메뉴로 되돌아가기 
			//프로그램 종료
		
		} 
	}	
}	
	
	/* 기능	: 메뉴를 출력하고, 메뉴 넘버를 입력받아 번호를 알려주는 메소드
	 * 매개변수: Scanner
	 * 리턴타입: 메뉴 번호 int
	 * 메소드명: printmenu*/
	
		
	
	
	

	/* 기능	: 리스트에서 선택한 게시글 제목과 내용을 수정해 리스트에 덮어쓰는 메소드
	 * 매개변수: Scanner
	 * 리턴타입: String? ArrayList?
	 * 메소드명: articleModify
	 * */
	
	/* 기능	: 리스트에서 선택된 게시글을 삭제하는 메소드
	 * 매개변수: Scanner
	 * 리턴타입: ArrayList
	 * 메소드명: articleDelete
	 * */

