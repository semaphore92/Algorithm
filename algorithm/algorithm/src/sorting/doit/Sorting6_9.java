package sorting.doit;

import java.util.Scanner;

public class Sorting6_9 {

	static void swap(int[] a , int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void quickSort(int [] a, int left , int right) {
		int pl = left; //0
		int pr = right; //4
		int x = a[(pl + pr) / 2]; //�߰� ��
		
		
		do {
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if(pl <= pr) {
				swap(a, pl++, pr--);
			}
		}while(pl <= pr);
		
		if(left < pr) quickSort(a,left,pr);
		if(pl < right) quickSort(a, pl, right);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ����");
		System.out.println("��� �� :");
		
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for(int i =0; i < nx; i++) {
			System.out.println("x["+  i + "] :");
			x[i] = stdIn.nextInt();
		}
		
		quickSort(x,0,nx-1);
		
		
	}
}

