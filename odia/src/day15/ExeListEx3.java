package day15;

import java.util.*; //java.util.*;을 입력하면 util 전부를 임포트하겠다는 뜻

public class ExeListEx3 {

	public static void main(String[] args) {
		/* 오늘의 할일을 5개 입력받아 출력하는 코드를 작성하세요. 단, 리스트를 이용
		 * 방법1. 오늘의 할일을 String으로 관리하는 방법
		 * 방법2. 오늘의 할일을 ToDo로 관리하는 방법 */
		//방법1
		ArrayList<String> todoList1 = new ArrayList<String>();
		Scanner scan =new Scanner(System.in);
		for(int i =0; i<5; i++) {
			System.out.println("오늘의 할 일");
			//String tmp = scan.nextLine(); //tmp 에 저장했다가 출력하는 것과
			//todoList1.add(tmp);			//아래 스캔받자마자 출력하는 것의 결과는 같다
			todoList1.add(scan.nextLine());
		}
		System.out.println(todoList1);
		scan.close();
	}


}
