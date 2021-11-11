package day12;

public class ExaShape {
	//도형 클래스 : 그림판에서 그려지는 모든 도형을 대표할 수 있는 클래스

//도형을 아무튼 박스형태 안에서 크기가 변화한다고 하면???
/*도형은 위치를 이동시킬 수 있다.
 * 도형은 크기를 조절할 수 있다.
 * 도형은 방향에 상관없이 그릴 수 있다.
 */

/* Shape 클래스 작성
 * 메소드로 시작점(lt)과 끝점(rb) 좌표 설정
 * 시작점 좌표값 x와 y의 getter와 setter설정
 * 끝점 좌표값 x와 y의 getter와 setter 설정
 * 
 * */

//lt, rb 설정
	protected int left, top; //lt
	protected int right, bottom; //rb
	//도형을 그릴 때 대각선 점 2개가 필요
	public ExaShape(int x1, int y1, int x2, int y2) {
		setLeft(x1 < x2 ? x1 : x2);
		right = x1 < x2 ? x2 : x1;
		top = y1 < y2 ? y1 : y2;
		bottom = y1 < y2 ? y2 : y1;
		/* if (x1 < x2){
				left = x1;
				right=x2;
			}else {
				left = x2;
				right = x1
			}
			if (y1 < y2){
				top = y1;
				bottom = y2;
			}else{
				top = y2;
				bottom = y1
			과 같음 */
	}
	//도형의 너비를 계산하는 기능
	public int getWidth() {
		return right - getLeft();
	}
	
	//도형의 높이를 계산하는 기능
	public int getHeight() {
		return bottom - top;
	}
	
	//도형은 위치를 이동시킬 수 있다(왼쪽 위의 점).
	public void move(int left, int top) {
		this.right = left + getWidth();
		this.bottom = top + getHeight();
		this.setLeft(left);
		this.top = top;
	}
	//도형은 크기를 바꿀 수 있다(방향은 마음대로.)
	public void resize(int width, int height, int direction) {
		/* direction : 1이면 오른쪽 우하방향, 2이면 좌하방향, 3이면 좌상방향, 4이면 우상방향 */
		if(width <=0 || height <= 0 ) {
			System.out.println("잘못된 너비 또는 높이입니다");
			return; //(void일 때 리턴 강제종료)
		}
		switch(direction) {
		case 1 :
			right = getLeft() + width;
			bottom = top + height;
			break;
		case 2 :
			setLeft(right - width);
			bottom = top + height;
			break;
		case 3 :
			setLeft(right - width);
			top = bottom - height;
			break;
		case 4 :
			right = getLeft() + width;
			top = bottom + height;
			break;
		default:
			System.out.println("잘못된 방향입니다.");
		}
	}
	//도형을 그리기
	public void print() {
		System.out.println("----도형----");
		System.out.println("좌상점 : " + getLeft() + "," + top);
		System.out.println("우하점 : "+ right + "," + bottom);
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	} 
	
}