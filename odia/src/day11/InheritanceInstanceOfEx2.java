package day11;

public class InheritanceInstanceOfEx2 {

	public static void main(String[] args) {
		P3 p1 = new P3(); //부모클래스의 머시기를..케이스라서 안됨
		System.out.println(p1 instanceof C3);
		P3 p2 = new C3(); //조건부로 자료형변환을 통해 사용할 수 있는지
		System.out.println(p2 instanceof C3); //instanceof 라는 연산자를 통해 확인가능
		C3 child = null; //초기화가 필요함
		P3 parent = new P3();
		//parent가 C3로 형변환이 가능하면 child와 공유하고 싶다.
		//형변환이 불가능하면 아무것도 안함
		if(parent instanceof C3) {
			child = (C3)parent;
		}
		//형변환이 가능해서 parent와 공유하면 이상한 값이 나오고
		//아니면 null이 나옴
		System.out.println(child); //형변환이 되지 않아 null이 출력될 것임
	}

}
class P3{
	
}
class C3 extends P3{
	
}