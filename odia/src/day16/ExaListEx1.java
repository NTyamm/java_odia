package day16;

import java.util.*;

public class ExaListEx1 {

	public static void main(String[] args) {
		/* list1은 ArrayList를 이용한 리스트이기 때문에 생성자가 반드시 ArrayList이어야 한다.
		 * list2는 List 인터페이스를 이용한 리스트이기 때문에 생성자가 List 인터페이스를 구현한 구현클래스 아무나 올 수 있다.*/
		ArrayList<Integer> list1 = new ArrayList<Integer>();//자손과 조상 관계에서만 형변환이 가능해서 new LinkedList못씀
		List<Integer> list2 = new LinkedList<Integer>(); //ArrayList는 List를 이용한 구현클래스라 new ArrayList사용 가능
		list1.add(1); list1.add(2);	list1.add(3);	list1.add(4);
		list2.add(11);	list2.add(12);	list2.add(13);	list2.add(4);
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println("list1에 list2가 포함? : " + list1.containsAll(list2));
		list1.addAll(list2);
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println("list1에 list2가 포함? : " + list1.containsAll(list2));
		list1.removeAll(list2);
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		list1.clear();
		System.out.println("list1 : " + list1);
		list1.add(1);	list1.add(2);
		System.out.println(list1.set(1, 22));
		System.out.println("list1 : " + list1);
	}

}
