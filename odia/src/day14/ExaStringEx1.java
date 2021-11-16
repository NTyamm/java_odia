package day14;

public class ExaStringEx1 {

	public static void main(String[] args) {
		/* 5명의 이름을 배열에 저장하고, 성이 홍씨인 사람을 검색하는 코드를 작성하세요.*/ 
		String str = "김연습, 이랩톱, 박안드, 최코드, 홍초";
		String []names = str.split(",");
		for(String tmp : names) {
			if(tmp.startsWith("홍")) {
				System.out.println(tmp +"는 홍씨입니다.");
			}else {
				System.out.println(tmp + "는 홍씨가 아닙니다.");
			}
			System.out.println("-----------");
		//위로는 내가 한 거
			/* 홍이라는 글자로 시작하는지? startsWdth
			 * 홍이라는 글자가 0번지에 있는지? indexOf
			 * 홍이라는 글자가 있는지? (여기에선 필요없음) contains */
		String [] names1 = new String[5];
		names1[0] = "홍길동";
		names1[1] = "임꺽정";
		names1[2] = "김연홍";
		names1[3] = "김철수";
		names1[4] = "홍영희";
		//startsWidth
		for(String name : names1) {
			if(name.startsWith("홍")) {
				System.out.println(name + "은 홍씨입니다.");
			}else {
				System.out.println(name +"은 홍씨가 아닙니다.");
			}
		}
		System.out.println("-----------");
		//indexOf
		for(String name : names1) {
			if(name.indexOf("홍") == 0 ) { //인덱스 위치를 잘 걸어줘야 함
				System.out.println(name + "은 홍씨입니다.");
			}else {
				System.out.println(name + "은 홍씨가 아닙니다.");
			}
		}
		
		}
	}
}
