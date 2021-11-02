package day5;

public class PrintAlphabetEx1 {

	public static void main(String[] args) {
		/*zyx...cba가 출력되도록 코드를 가성하세요.
		 * 
		 */
		char ch;
		for(ch = 'z'; ch>='a';ch--) {
			System.out.print(ch + " ");
		}
		int i=0;
		while(i<26) {
			System.out.print((char)('z'-i)+" ");
			i++;
		}
	}

}
