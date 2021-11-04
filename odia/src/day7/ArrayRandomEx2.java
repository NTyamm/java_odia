package day7;

import java.util.Arrays;

public class ArrayRandomEx2 {

	public static void main(String[] args) {
		/*1~9사이의 랜덤한 수 3개를 배열에 저장하여 출력하는 코드를 작성하세요.
		 * 단, 세 수가 중복되지 않게 작성하세요.
		 */
		
		int num[] = new int[3];
		int min = 1, max = 9;
		int count = 0;
		//3번 반복
		do{
			//랜덤한 수를 생성
			int random = (int)(Math.random()*(max-min+1)+min);
			//배열에 중복된 값이 있는지 확인하는 반복문
			int i;
			/*count가 0일 때는 반복문이 한 번도 실행 안 됨
			 *count가 1, [0]에 중복된 수가 있으면 반복 문 종료 후 i는 0으로 count값보다 작음 
			 *count가 2, 중복된 수가 있으면 반복문 종료 후 i는 0 or 1번지에 있음*/
			for(i= 0 ; i<count ; i++) {
				//중복된 수가 있으면 반복문을 중단. break에 중단되지 않았다고 하면 count-1까지 i가 증가한 것
				if(num[i] == random) {
					break;
				}
			}
				//반복문 종료 후 i값이 count와 같다는 건 중복된 수가 없어서 break 문이 실행 안 된 경우
				if (i == count) {
					num[i] = random;
					//중복된 수가 없어서 count의 값을 증가시킴
					count++;
				
			}
		}while(count !=3);			
		//배열을 출력
		System.out.println(Arrays.toString(num));
		}	
	
}