package recursion.doIt;

import java.util.Scanner;

public class recursion5_2 {
	static int gcd(int x, int y) {
		if(y==0)
			return x;
		else 
			System.out.println(x+"나누기"+y+"는"+x % y);
			return gcd(y, x % y);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("두 정수의 최대공약수를 구합니다.");
		int x = stdIn.nextInt();
		int y = stdIn.nextInt();
		
		
		System.out.println("최대공약수는 " + gcd(x,y) +"입니다.");
	}
}
