package recursion.doIt;

import java.util.Scanner;

public class recursion5_2 {
	static int gcd(int x, int y) {
		if(y==0)
			return x;
		else 
			System.out.println(x+"������"+y+"��"+x % y);
			return gcd(y, x % y);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ������ �ִ������� ���մϴ�.");
		int x = stdIn.nextInt();
		int y = stdIn.nextInt();
		
		
		System.out.println("�ִ������� " + gcd(x,y) +"�Դϴ�.");
	}
}