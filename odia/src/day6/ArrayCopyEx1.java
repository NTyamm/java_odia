package day6;

public class ArrayCopyEx1 {

	public static void main(String[] args) {
		/* 배열을 제대로 복사하기 위해서(원본을 수정해도 복사본이 바뀌지 않기 위해서)는
		 * 배열을 새로 생성하여 모든 번지에 있는 값을 하나씩 복사해야 함
		 */
		int arr1[] = {1,2,3};
		int arr2[] = new int[arr1.length];
		/*src : 원본, srcPos: 원본에서 복사할 시작위치
		 *dest: 복사본, dedsPos: 복사본에서 복사될 시작위치
		 *length : 복사할 길이
		 */
		//arr1의 1번지부터 2개 값을 복사해 arr2의 0번지부터 붙여넣기
		System.arraycopy(arr1, 1, arr2, 0, arr1.length-1);
		
		
		arr1[0] = 10;
		
		System.out.println("arr1: ");
		for(int tmp : arr1) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		System.out.println("arr2: ");
		for(int tmp : arr2) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}
