package day17;

import java.util.*;
import java.util.Map.Entry;//java.util.Map.Entry를 임포트해줘야 함

public class ExdMapIteratorEx2 {

	public static void main(String[] args) {
		/* Map에서 반복문 사용하는 예제
		 * Entry 클래스를 이용하여 반복문을 활용하는 방법 p.414
		 * Entry ㅋ르래스는 제네릭 클래스로 두 개의 값이 필요
		 * Entry<A,B>*/ 
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("abc123", "123123");
		map.put("qweqwe", "qweqwe");
		map.put("zzz", "zzzzzz");
		/* entrySet(): key와 value를 멤버 변수로 갖는 Entry 클래스가 있고
		 * 각 key와 value들을 Entry 클래스의 객체로 바꾼 후 Set에 담아서 알려주는 메소드 */
		Set<Map.Entry<String,String>> set= map.entrySet();//내부클래스
		
		Iterator<Map.Entry<String, String>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> e = it.next();
			String key = e.getKey();
			String value = e.getValue();
			System.out.println("ID : "+ key + " PW : " + value);
		}
	}

}
