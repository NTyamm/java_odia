package day12;

public class ExbEqualsEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExbTestA a1= new ExbTestA(1,1);
		ExbTestA a2 = new ExbTestA(1,1);
		if(a1.equals(a2)) {
			System.out.println("두 객체의 멤버 변수값이 같습니다.");
		}else{
			System.out.println("두 객체의 멤버 변수값이 다릅니다.");
		}
		System.out.println(a1);
		ExbTestB b = new ExbTestB(1,2);
		System.out.println(b);
	}

}
class ExbTestA{
	public int num1;
	public int num2;
	public ExbTestA(int num1, int num) {
		this.num1 = num1;
		this.num2 = num2;
	}
	@Override //equals를 잘 오버라이드 해야 두 객체 비교가 편하다
	public boolean equals(Object obj) {//조상클래스가 있으면 해당 조상 클래스를 포함해서 거기까지의 모든 조상클래스를 매개변수로 사용가능
		//비교 대상이 없는 경우
		if(obj == null) {
			return false;
		}
		//this : 내 객체 > 내 객체의 주소, obj는 비교 대상의 주소
		//주소가 같다는 건 같은 객체를 공유
		//비교 대상과 내가 같은 객체를 공유하는 경우
		if(this == obj) {
			return true;
		}
		//비교 대상이 내 클래스로 형 변환이 가능해야함
		//비교 대상이 내 자식클래스의 객체이거나 나와 같은 클래스의 객체
		//멤버변수를 비교하려면 상대방 멤버변수가 누가 있는지 알아야하기 때문에
		if (obj instanceof ExbTestA) {
			ExbTestA tmp = (ExbTestA)obj;
			if(this.num1 == tmp.num1 && this.num2 == tmp.num2);
		}
		
		return false;
	}
	@Override
	public String toString() {
		return "num1 : "+num1 + ", num2 : " + num2;
	}
	
}
class ExbTestB{
	private int num1;
	private int num2;
	
	public ExbTestB(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	//ctrl + shift + s 에서 hashcode and equals 통해 생성 가능

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num1;
		result = prime * result + num2;
		return result;
	}

	@Override
	public String toString() {
		return "ExbTestB [num1=" + num1 + ", num2=" + num2 + "]";
	}


	
	
}




