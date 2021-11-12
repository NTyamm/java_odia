package Day13;

public class ExeTestEx1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
interface ExeTest{
	public void func1();
	public void func2();
	public void func3();
	//인터페이스에서 새로운 기능을 추가할 때 추상 메소드로 하면
	//이전에 인터페이스를 이용하여 개발중이던 모든 클래스에 오버라이딩 해야 한다.
	public default void func4() {}
}

class ExeA implements ExeTest{
	
	public void func1() {}
	public void func2() {}
	public void func3() {};
}