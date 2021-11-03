package day6;

import java.util.Scanner;

public class ArrayScoreAverageEx1 {

	public static void main(String[] args) {
		/*배열을 이용하여 5명의 학생의 국어 성적을 입력받아 평균을 구하는 코드를 작성하세요.
		 * 단, 성적을 배열에 저장해야 하고, 성적은 정수입니다.
		 */
		System.out.println("5인의 성적을 입력하세요(예: 12 95 84 30 22) : ");
		Scanner scan = new Scanner(System.in);
		int i, sum;
		int arr[] = new int[5];
		arr[0] = scan.nextInt();
		arr[1] = scan.nextInt();
		arr[2] = scan.nextInt();
		arr[3] = scan.nextInt();
		arr[4] = scan.nextInt();

		for(i = 0, sum=0; i<5 ; i++) {
			sum += arr[i];

		}
		double average = sum / 5.0;
		System.out.println("5인의 성적 평균값은 "+ average + "입니다.");
		
		
		
	
		scan.close();
	}

}
