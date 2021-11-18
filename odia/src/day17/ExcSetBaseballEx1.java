package day17;

import java.util.*;

public class ExcSetBaseballEx1 {

	public static void main(String[] args) {
		/* 1~9 사이의 중복되지 않은 랜덤한 수 3개를 저장하여 숫자 야구 게임을 만들려고 한다.
		 * 이 때 1~9 사이의 중복되지 않은 랜덤한 수 3개를 만들어 보세요.*/
		
		//1~9 사이의 랜덤한 수를 만들어서 첫째자리에 채우고
		//1번에서 만든 수를 제외한 1~9 사이의 랜덤한 수를 만들어서 둘째자리에 채우고
		//1과 2에서 만든 수를 제외한 1~9 사이의 랜덤한 수를 만들어서 셋째자리에 만든 후 출력
		
		List<Integer> com = new ArrayList<Integer>();  //왜 리스트 다음에
		Set<Integer> tmp = new HashSet<Integer>();		//셋을 한 번 더 썼지?
		int min = 1, max = 9;
		while(com.size() < 3 ){						//List는 size를 사용할 수 있음. 그건 알아
			int r = (int)(Math.random()*(max-min+1) + min); //그래서 1~9 사이의 랜덤숫자를 3번 만들었어.
			boolean isAdd = tmp.add(r);
			if(isAdd) { //isAdd가 true이면 tmp에 숫자가 추가된 경우이기 때문에
				com.add(r); //List에 추가한다
			}
		}
		System.out.println(tmp); 
		System.out.println(com);
		//숫자 야구 게임은 순서를 보장해야 하기 때문에 List를 사용하는 것이 낫다.
		//로또는 순서가 상관 없기 때문에 set으로 충분하다.
	}

}
