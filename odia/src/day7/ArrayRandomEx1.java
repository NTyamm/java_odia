package day7;

import java.util.Arrays;
import java.util.Random;

public class ArrayRandomEx1 {

	public static void main(String[] args) {
		//1~9 사이의 랜덤한 수를 3개 생성하여 배열에 저장하는 코드를 작성하세요.
		//3개짜리 배열을 먼저 만들어야 함
		int num[] = new int[3];
		int min = 1, max = 9;
		//3번 반복
		for(int i=0 ;i < num.length ; i++ ) {
			//랜덤한 수를 생성
			int random = (int)(Math.random()*(max-min+1)+min);
			//배열에 랜덤한 수를 저장
			num[i] = random;
			//num [i] = (int)(Math.random()*(max-min+1)+min);
		}			
		//배열을 출력
		System.out.println(Arrays.toString(num));
		 
		/* 방법 1. 배열x 반복문 x
		 * int num1, num2, num3;
		 * int min = 1, max = 9;
		 * num1 = (int)(Math.random()*(max-min+1)+min);
		 * num2 = (int)(Math.random()*(max-min+1)+min);
		 * num3 = (int)(Math.random()*(max-min+1)+min);
		 * System.out.prinln(num1 + ", " + num2 + ", ", num3 );
		 */
		
		
		//방법2. 배열o, 반복문x
		/*
		int min = 1, max = 9;
		int com[] = new int[3];
		Random r = new Random();
		num[0] = (int)(Math.random()*(max-min+1)+min);
		num[1] = (int)(Math.random()*(max-min+1)+min);
		num[2] = (int)(Math.random()*(max-min+1)+min);
		System.out.println(Arrays.toString(num));
		}
		*/
		
		
	}

}
