package Day3;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		/*0~100점 사이의 점수를 입력받아 입력받은 점수의 학점을 출력하는 코드를 작성하세요.
		 * 90이상~100이하: A
		 * 80이상~90미만: B
		 * 70이상~80미만: C
		 * 60이상~70미만: D
		 * 0이상~60미만: F
		 * 잘못된 점수: 잘못된 점수입니다.
		 */
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		scan.close();
		
		if (90 <= score && score <= 100) {
			System.out.println(score + "점은 A학점입니다.");		
			}else if (80 <= score && score < 90)
				System.out.println(score + "점은 B학점입니다.");		
			}else if (70 <= score && score < 80) {			
				System.out.println(score + "점은 C학점입니다.");		
			}else if (60 <= score && score < 70) {
				System.out.println(score + "점은 D학점입니다");
			}else if (0 < score && score < 60) {
				System.out.println(score + "점은 F학점입니다");
			}else {System.out.println("잘못된 점수입니다.");
	}

}
