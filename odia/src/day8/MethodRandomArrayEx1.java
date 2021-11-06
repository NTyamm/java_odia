package day8;

import java.util.Arrays;

public class MethodRandomArrayEx1 {

	public static void main(String[] args) {
		/* 1에서 45사이의 랜덤한 수를 6개 생성하여 배열에 저장하고,
		 * 출력하는 코드를 작성하세요. 메소드 생성하고 호출할 것. 단, 중복가능*/
		int size = 6, min = 1, max = 45;
		int arr1[] = new int[size]; //1. 첫번째 방법. 배열을 먼저 생성해준다.
		randomArray1(min, max, arr1);
		System.out.println(Arrays.toString(arr1));
		int arr2[] = randomArray2(min, max, size); //2. 두번째 방법에서는 메소드가 배열을 만든다
		System.out.println(Arrays.toString(arr2));
	}
//		기능: 배열이 주어지면 주어진 배열에 min에서 max 사이의 랜덤한 수를 생성하여 저장하는 메소드
//		매개변수: 배열, 정수 범위(min~max) -> int min, int max, int arr[]
//		리턴타입: 없음
//		메소드명: randomArray1
		
//		기능: 배열의 크기가 주어지면 주어진 배열의 크기만큼 min에서 max사이의 랜덤한 수를 생성하여 저장한 후 
//		만들어진 배열을 알려주는 메소드
//		매개변수: 크기, 정수 범위(min~max) -> int min, int max, int size
//		리턴타입:	배열 int []
//		메소드명: randomArray2
	public static void randomArray1(int min, int max, int arr[]) {
		//int arr[]은 여기서 내용을 바꾸면 원본 내용도 바뀜. 일반변수가 아니라 매개변수라서.
		for(int i = 0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
	}
	
	public static int[] randomArray2(int min, int max, int size) {
		int [] arr = new int[size]; //배열의 크기 설정
		for(int i = 0; i < arr.length ; i++) { //반복횟수 설정
			arr[i] = (int)(Math.random()*(max-min+1)+min); //배열에 숫자 넣기
		}
		return arr; //초기화를 해줘야 함. 초기화 값으로는 null을 많이 쓴다. 여기선 배열arr로 보내줘야 함
	}
}
