package Day13;

import day12.ExaEllipse;
import day12.ExaRect;
import day12.ExaShape;

public class ExfTestEx1 {

	public static void main(String[] args) {
		/* 타원, 사각형을 같이 관리할 수 있는 배열을 만들고
		 * 타원 1개, 사각형 2개를 만들어 저장한 후, 그리는 코드를 작성하세요. */
		ExfShape list [] = new ExfShape[10];
		//타원 1개와 사각형 2개를 생성하여 배열에 저장
		//클래스 형변환, 자식->부모클래스로 형변환, 자동클래스형변환
		list[0] = new ExfEllipse(0,0,10,10);
		list[1] = new ExfRect(10,10,20,20);
		list[2] = new ExfRect(10,20,20,30);
		
		for(ExfShape tmp:list) {
			tmp.draw();
		}
	}
}
