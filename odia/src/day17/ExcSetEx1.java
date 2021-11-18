package day17;

import java.util.*;

public class ExcSetEx1 {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		set1.add(1);	set1.add(2);	set1.add(3);	set1.add(1);
		System.out.println(set1);
		//Set은 중복을 허용하지 않음
		int min = 1, max = 9;
		while(set2.size() < 3 ){
			int r = (int)(Math.random()*(max-min+1) + min);
			set2.add(r);
		}
		System.out.println(set2);
		//for(int i = 0; i<set2.size(); i++) // Set에는 번지가 없으므로 번지값 i를 쓸 수 없고 Iterator를 이용해야 한다.
		Iterator<Integer>it=set2.iterator();
		while(it.hasNext()) {
			Integer tmep = it.next();
			System.out.print(tmep+ " ");
		}
	}

}
