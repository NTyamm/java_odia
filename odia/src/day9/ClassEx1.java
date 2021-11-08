package day9;

import java.util.Scanner;

public class ClassEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car(); //new를 통해 클래스의 객체를 만들어야 함
		car1.brand="기아";
		System.out.println("브랜드 : " + car1.brand);
		car1.turnOn();
		//객체 멤버 변수는 값을 공유하지 않음
		Car car2 = new Car();
		System.out.println("브랜드 : " + car2.brand);
		Car car3 = "대형"; //자동차의 정보가 들어있는 객체의 시작 주소
		System.out.println(car1.count +  "인승");
		//Scanner scan = new Scanner(); //기본생성자 제공하지 않는 클래스. 이런 예외가 있다.
	}

}
class Car{
	//자동차와 관련된 정보들 -> 멤버 변수
	String brand;	//기아, 현대 등
	String type;	//소형차, SUV, 대형 등
	int count;		//최대 탑승인원
	int power;		//시동, 기어
	int speed; 		//속력
	//자동차와 관련된 기능들 -> 멤버 메소드
	//시동 켜는 기능
	void turnOn() {
		System.out.println("켰습니다.");
	}
	//시동켜는기능
	void trunOff() {
		System.out.println("껐습니다.");
	}
	//Car(){} 생성자가 하나도 없으면 이 코드가 생성이 됨
/*	Car(){
		count = 1;
		brand = "";
		type = "소형";
	} */
	Car(int count1 , String brand1, String type1){ //여기서 생성자를 적으면 메인에서 기본생성자를 출력할 수 없어서 에러남
		count = count1;
		brand = brand1;
		type = type1;
	}
}
