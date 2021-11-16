package day15;

public class ExdData<T> { //꺾쇠를 이용해 제네릭클래스의 이름을 넣음
	T data;
	public void print() {
		System.out.println(data.getClass().getName() + " : " + data);
	}
	public ExdData(T data) {
		this.data = data;
	}
	public T getData () {
		return data;
	}
	public void setData(T data) {
		this.data =data;
	}
	public void test(ExdData<?> data) { //여기서 ?를 와일드카드라고 함
		System.out.println(data);
	}
}


