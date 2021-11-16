package day15;

import java.util.ArrayList;

public class ExeListEx2 {

	public static void main(String[] args) {
		/* 하나의 점이 이동한 좌표를 저장하려 한다.*/
		ExePoint pt=new ExePoint(0,0);
		ArrayList<ExePoint> moveRoute = new ArrayList<ExePoint>();
		moveRoute.add(new ExePoint(pt));
		pt.move(5, 5);
		//점이5,5로 이동한 후 위치를 리스트에 저장
		moveRoute.add(new ExePoint(pt));//하나의 객체를 사용하게 되면 내용값 덮어쓰기가 됨
		pt.move(10, 10);
		moveRoute.add(new ExePoint(pt)); //new ExePoint(pt)라는 연산자와 생성자가 없으면 좌표값이 아니라 내용값이 변한 게 됨
		System.out.println(moveRoute);
		System.out.println(pt + "좌표가 list에 있습니까? : " + moveRoute.contains(pt));
		System.out.println(pt + "좌표가 list에 있습니까? : " + moveRoute.indexOf(pt));
	}

}
class ExePoint{
	int x, y;
	
	public ExePoint (int x, int y) {
		this.x = x; this.y = y;
	}
	public ExePoint(ExePoint p) {
		x=p.x; y=p.y; //이게 없으면 좌표값이 아니라 내용값이 변하게 됨
	}
	public void move(int x, int y) {
		this.x = x; this.y = y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	@Override
	public boolean equals(Object obj) { 
		//list에서 contains나 indexOf는 equals 값으로 비교하기 때문에 오버라이드 생성해줘야함
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExePoint other = (ExePoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}