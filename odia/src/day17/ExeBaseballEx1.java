package day17;

import java.util.*;

import day16.ExbStudent;

public class ExeBaseballEx1 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크를 이용하여 숫자 야구게임을 구현해 보세요. */
		
		//컴퓨터는 1~9 사이의 랜덤한 수를 만들어서 첫째자리에 채우고
		//1번에서 만든 수를 제외한 1~9 사이의 랜덤한 수를 만들어서 둘째자리에 채우고
		//1과 2에서 만든 수를 제외한 1~9 사이의 랜덤한 수를 만들어서 셋째자리에 채움
		//생성된 숫자를 저장할 리스트 선언 및 생성
		List<Integer> com = new ArrayList<Integer>(); 
		List<Integer> use = new ArrayList<Integer>(); 
		//중복되지 않은 숫자를 생성하기 위한 임시set을 선언 및 생성
		Set<Integer> comSet = new HashSet<Integer>();		
		int min = 1, max = 9;
		int count = 3;
		int strike = 0, ball = 0, out = 0;
		Scanner scan = new Scanner(System.in);
		try {
		createRandomList(com, min, max, count);
		}catch(Exception e) {
			System.out.println("===========================");
			System.out.println("예외 발생!! : " +e.getMessage());
			System.out.println("===========================");
			System.out.println("숫자 생성에 실패하여 게임을 할 수 없습니다.");
			return;
		}
	
		
		//반복
			//사용자가 3O이 되기 전까지 반복해서 1~9 사이의 랜덤한 수 3개를 입력받음 - 메소드 만들기
			while(strike != count) {
				//사용자가 숫자 3개를 입력
				System.out.print("숫자 3개 입력(예 : 1 2 3) : ");
				int inputResult = inputList(use, min, max, count, scan);
				switch(inputResult) {
				case -1 :
					System.out.println("중복된 숫자를 입력했습니다.");
					break;
				case 1 :
					System.out.println("잘못된 범위의 정수를 입력했습니다.");
					break;
				}
			}
			//컴퓨터가 만든 세 숫자와 사용자가 입력한 수를 비교함
			//스트라이크 갯수
			strike = getStrike(com,use);
			//볼의 갯수를 계산 : 같은 숫자의 갯수 - 스트라이크 갯수
			ball = getBall(com,use);
			System.out.println(strike +", "+ball);
			//결과 판별
			printResult(strike, ball);
			//프로그램 종료 알림
		System.out.println("프로그램 종료");

	}
	/* 기능	: 정수 리스트가 주어지면 해당 정수 리스트에 min~max 사이의 값을 중복되지 않게 count개 저장하는 메소드
	 * 매개변수: 주어진 정수 리스트, 정수 범위-> List<Integer>list, int min, int max
	 * 리턴타입: 없음 ->void
	 * 메소드명: createRandomList*/
	public static void createRandomList(List<Integer>list, int min, int max, int count) {
		if(list == null) {
			//return; //리스트가 비어서 일 안함
			throw new NullPointerException("list가 null입니다."); //리스트가 비어서 문제 발생함
		}
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > max - min + 1) {
			throw new RuntimeException("범위가 배열의 크기보다 작아서 만들 수 없습니다.");
		}
		//중복되지 않은 숫자를 생성하기 위한 임시 set을 선언 및 생성
		Set<Integer> comSet = new HashSet<Integer>();
		//comSet에 3개 저장될때까지 반복
				while(comSet.size() < count ){
					//랜덤한 수 생성
					int r = (int)(Math.random()*(max-min+1) + min); //그래서 1~9 사이의 랜덤숫자를 3번 만들었어.
					//comSet에 생성한 랜덤 수를 저장
					boolean isSave = comSet.add(r);
					//위에서 랜덤수가 저장이 됐다면 com리스트에 랜덤수를 저장
					if(isSave) { //isAdd가 true이면 tmp에 숫자가 추가된 경우이기 때문에
						list.add(r); //List에 추가한다 //
					/*if(comSet.add(r)){
					 * com.add(r);과 같다*/	
					}
				}
		
	}
	
	/* 기능	: 정수 리스트가 주어지면 해당 정수 리스트에 min~max 사이의 값을 스캐너를 통해 count개 입력받아 제대로 입력했는지 알려주는 메소드
	 * 		0: 제대로 입력, 1: 범위 잘못, -1: 중복
	 * 매개변수: 리스트, 범위, 갯수스캐너 ->List<Integer> list, int min, int max, int count, Scanner scan
	 * 리턴타입: 0 또는 1 또는 -1 -> 정수 -> int 
	 * 메소드명: inputList
	 * */	
	public static int inputList(List<Integer> list, int min, int max, int count, Scanner scan) {	
		if(list ==null ) {
			throw new NullPointerException("리스트가 null입니다.");
		}
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > max - min +1) {
			throw new RuntimeException("범위가 리스트의 크기보다 작아서 만들 수 없습니다.");
		}
		if(scan == null) {
			throw new NullPointerException("scan가 null입니다.");
		}
		list.clear();
		int i =0;
		Set<Integer> useSet = new HashSet<Integer>();
		boolean isOutOfBounds = false;
		while(i < count) {
			int tmp = scan.nextInt();
			useSet.add(tmp);
			list.add(tmp);
			//isOutOfBounds = tmp>=min && tmp <=max ? isOutOfBounds : true; //세 개 중에 하나만 벗어나도 true, 아닐 시 기존값 유지
			if(tmp < min || tmp > max) { //이렇게
				isOutOfBounds = true; //두 줄로 늘여써도 됨
			}
			i++;
		}
		if(useSet.size() != count) {
			return -1;
		}
		//return isOutOfBounds ? i : -1;
		if(isOutOfBounds) {
			return 1;
		}else {
			return 0;
		} //이렇게 두 줄로 늘여써도 됨
	}
	/* 기능	: 두 정수 리스트가 주어지면 같은 번지에 있는 숫자가 몇 개 같은지 알려주는 메소드
	 * 매개변수: 두 정수 리스트 -> List<Integer>list1,List<Integer>list2 
	 * 리턴타입: 같은 번지에 있는 숫자 중 같은 숫자의 갯수 -> 정수 -> int
	 * 메소드명: getStrike*/
	public static int getStrike(List<Integer>list1,List<Integer>list2) {
		int strike = 0;
		for(int i = 0; i < list1.size(); i++) {
			if(list1.get(i).equals(list2.get(i))) {
				strike++;
			}
		}
		return strike;
	}
	/* 기능	: 두 정수 리스트가 주어지면 다른 번지에 있는 숫자가 몇 개 같은지 알려주는 메소드
	 * 매개변수: 두 정수 리스트 -> List<Integer>list1,List<Integer>list2 
	 * 리턴타입: 다른 번지에 있는 숫자 중 같은 숫자의 갯수 -> 정수 -> int
	 * 메소드명: getBall*/
	public static int getBall(List<Integer>list1,List<Integer>list2) {
		int ball=0;
		for(int i = 0; i<list1.size(); i++) {
			if(list1.contains(list2.get(i))) {
				ball++;
			}
		}
		ball = ball - getStrike(list1, list2);
		return ball;
	}
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.println(strike + "S");
		}
		if(ball != 0) {
			System.out.println(ball + "B");
		}
		if(strike ==0 && ball == 0) {
			System.out.println("3O");
		}
		System.out.println();
	}
}
//input에 list.clear();가 빠지면 숫자가 누적되어 결과값이 이상해진다.
