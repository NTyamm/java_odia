package day18;

public class ExdInnerEx1 {

	public static void main(String[] args) {
		A.InnerB b = new A.InnerB();
		A a = new A();
		A.InnerD d = a. new InnerD();

	}

}
class A{
	public class innerD{}
	public static class innerB{}
	private class InnerC{
		public int num = 10;
	}
	public void test() {
		InnerC c = new InnerC();
		c.num = 20;
		System.out.println(c.num);
	}
}