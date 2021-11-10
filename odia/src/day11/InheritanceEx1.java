package day11;

public class InheritanceEx1 {

	public static void main(String[] args) {
		Square s1 = new Square();
		s1.print();
		Point p = new Point(10,10); //참조변수에 =을 쓰면 값을 공유한다
		Square s2 = new Square(p,5);
		s2.print();
		p.move(20, 20);
		s2.print();
	}

}
