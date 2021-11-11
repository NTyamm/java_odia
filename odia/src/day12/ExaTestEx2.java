package day12;

public class ExaTestEx2 {

	public static void main(String[] args) {
		/* 사각형과 타원을 여러개 저장할 수 있는 배열을 만들어보세요.
		 * 사각형과 타원을 합쳐서 최대 10개까지 저장하는 배열*/
		//int? Rect와 Ellipse에게 고유번호를 부여하거나 스트링으로 가져와야? > 자료형변환이 가능할지?
		//Rect 배열과 Ellipse배열을 구분해서 갯수 채우기...
		//10개 개수를 채울 때까지 반복해서 배열에 Rect나 Ellipse 넣기...
		//10개이 채워지면 해당 배열의 모든 내용을 콘솔에 한줄로 출력하는 메소드
		
		//도형 배열명 [] = new 도형 [10];
		ExaShape list [] = new ExaShape[10];
		//타원 1개와 사각형 2개를 생성하여 배열에 저장
		//클래스 형변환, 자식->부모클래스로 형변환, 자동클래스형변환
		list[0] = new ExaEllipse(0,0,10,10);
		list[1] = new ExaRect(10,10,20,20);
		list[2] = new ExaRect(10,20,20,30);
		list[0] = new ExaShape(10,10,0,0);
		//배열에 저장된 도형들을 그려보세요. (콘솔에 출력)
		//반복문을 이용하여 배열에 저장된 도형들을 콘솔에 출력해 보세요.
		
		//내가 했다가 망한거
		/*int i = 0;
		while (i < 3) {
			System.out.print(list[i]); //이게 아닌데...i가 반복해서 출력되어야 while말고? for?나 do while?
			i++;
			} */  //도형이 없어도 출력하게 하기 때문에 문제 발생
		
		/*print 메소드를 이용*/
		for(int i= 0; i <list.length ; i++) {
			/*도형이 있으면 print()기능을 이용하여 출력하고,
			 *도형이 없으면 아무것도 안함 
			 *도형이 없다가 null인 이유
			 * -배열은 생성이 되면 타입에 맞는 초기값으로 초기화를 한다.
			 * -참조변수는 null로 초기화
			 * -도형이 없다는 건 도형이 생성되어 저장된 게 아니기 때문에 초기값인 경우이다.
			 */
			if(list[i] != null) { //참조변수는 초기값이 null인지 아닌지 체크해 줘야 함
			list[i].print();
			}
		}
		/* 저장된 도형이 타원이면 testE를 호출하고, 사각형이면 testR을 호출하는 코드를 호출하세요.
		 * 반복문을 이용*/
		// instanceof 로 확인
		for(ExaShape tmp : list ) {
			if(tmp != null) { //초기값이 null인지 확인
				//tmp.print
				if(tmp instanceof ExaEllipse) {
					//도형 tmp를 타원으로 형변환 시킨 후 testE()호출
					((ExaEllipse)tmp).testE(); //tmp를 타원으로 형변환을 먼저 하고 .testE();
					//ExaEllipse e = (ExaEllipse)tmp; 이런 식으로
					//e.testE();두 줄로 늘려 쓸 수 있다.
				}
				else if(tmp instanceof ExaRect) {
					ExaRect r = (ExaRect)tmp;
					r.testR();
				}
			
			}	
			
		}
		System.out.println("---------");
		for(ExaShape tmp : list) {
			if(tmp ==null) {
				continue;
			}
			print(tmp);
		}
	}
	/* 기능		: 매개변수가 사각형이면 사각형이라고 출력하고, 매개변수가 타원이면 타원이라고 출력하고
	 * 			  매개변수가 도형이면 도형이라고 출력하는 메소드
	 * 매개변수	: 사각형 또는 타원 또는 도형 -> ExaShape shape
	 * 리턴타입	: 없음 void
	 * 메소드명	: print
	 * */
	public static void print(ExaShape shape) {//static인 메인에서 호출하기 위해 static으로 가공한다.
		if(shape instanceof ExaRect) {
			System.out.println("사각형");	
		}else if(shape instanceof ExaEllipse) {
			System.out.println("타원");
		}else {
			System.out.println("도형");
		}
	}
}