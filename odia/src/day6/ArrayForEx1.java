package day6;

public class ArrayForEx1 {

	public static void main(String[] args) {
		/*
		 * */
		int arr2[] = new int[5];
		int i, sum;
		for(i = 0; i <5 ; i++) { 
			arr2[i] = 2 * i + 2;
		}
		sum = 0;
		//tmp는 아래 반복문에서만 사용 가능
		for(int temp : arr2) { 
			sum += temp;	 
		}
		System.out.println("2부터 10까지의 합 : " + sum);
		

	}

}
