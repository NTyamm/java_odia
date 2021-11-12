package Day13;

public class ExgStringIndexOfEx1 {

	public static void main(String[] args) {
		/* int indexOf(int ch) : ch라는 문자가 몇 번지에 있는지 알려주는 메소드로, 없으면 -1을 알려줌 
		 * int indexOf(String str) : str이 몇번지에서 시작하는지 알려주는 메소드로 없으면 -1을 알려줌
		 * int indexOf(int ch, int from) : from번지부터 검색하여 ch가 몇번지에 있는지 알려주는 메소드로 없으면 -1을 알려줌
		 * int indexOf(String str, String from) : from번지부터 검색하여 strdl 몇번지에 있는지 알려주는 메소드로 
		 * 없으면 -1을 알려줌
		 * 
		 * int lastIndexOf(int ch) : 마지막부터 검색해서 ch가 몇번지에 있는지 알려준는 메소드로 없으면 -1*/
		

		String str = "Hello world" ;
		System.out.println(str.indexOf('H'));
		System.out.println(str.indexOf('e'));
		System.out.println(str.indexOf('w'));
		System.out.println(str.indexOf("wo"));
		
		/*str에 l이 몇 개 있는지 확인하는 예제*/
		int index = 0;
		int count = 0;
		int ch = 'e'; //문자가 몇 번 쓰였는지도 확인 가능 
		do {
			index = str.indexOf(ch, index);
			if(index >=0) {
				count++;
				index++; //다음 번지부터 
			}
		}while(index != -1);
		System.out.println((char)ch + "의 갯수 : " + count);
		
	}

}
