package day6;

public class ArraySortEx2 {

	public static void main(String[] args) {
		// 다음과 같은 배열이 있을 때 정렬하는 코드를 작성하세요.
		int num [] = {1, 10, 9, 3, 6, 2, 3, 4};
		/*버블정렬 : 옆에 있는 값과 비교하여 정렬하는 방법
		 * 1, 10, 9, 3, 6, 2, 3, 4
		 * 1, 9, 3, 6, 2, 3, 4, 10
		 * 1, 3, 6, 2, 3, 4, 9, 10
		 * 1, 3, 2, 3, 4, 6, 9, 10
		 * 1, 2, 3, 3, 4, 6, 9, 10
		 * 1, 2, 3, 3, 4, 6, 9, 10
		 * 1, 2, 3, 3, 4, 6, 9, 10
		 */
		
		for(int i = 0; i < num.length-1; i++) {
			for(int j = 0; j < num.length-1 ; j++) { //j가 1일때 0번지 1번지... j가 2일때 1번지 2번지를 비교함
				if(num[j] > num[j+1]) {
					//두 값을 바꿈
					int tmp = num[j]; //매우 중요함...임시값에 기존 j값을 저장하고
					num[j] = num[j+1]; //j+1을 j에 저장
					num[j+1] = tmp;	  //j+1에는 임시값 tmp를 저장하는 식으로 바꿔야 함
				}
				
			}
		}
		for(int tmp : num) {
			System.out.print(tmp + " ");
		}
	}

}
