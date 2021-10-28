package day2;

public class ShiftEx1 {
	public static void main(String[] args) {
		//12    : 000000000 00000000 00000000 00001100
		//12<<2 : 0000000 00000000 00000000 0000110000 : 48 {12*(2^2)}
		//12>>2 : 00000000000 00000000 00000000 000011 : 3  {12/(2^2)}
		int num1 = 12;
		int leftShift = 12 << 2;
		int rightShift = 12 >> 2;
		
		System.out.println(" << 2 = " + leftShift);
		System.out.println(" >> 2 = " + rightShift);
	}
}
