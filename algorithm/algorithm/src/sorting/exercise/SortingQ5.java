package sorting.exercise;

import java.util.Scanner;

public class SortingQ5 {
	static void swap(int[] a, int idx1, int idx2) {
		int t= a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int [] a, int n) {
		boolean direction = true;
		int start = 0;
		int end = n;
		
		while(start-end != 1) {
			if(direction) {
				for(int i = start; i < n - 1 ; i++ ) {
					if(a[i] > a[i + 1]) {
						swap(a,i,i+1);
						end = i;
					}
					direction = false;
				}
			}else {
				int size = start;
				for(int j = end; j > size  ; j--) {
					if(a[j] < a[j - 1]) {
						swap(a,j,j-1);
						start = j;
					}
					direction = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("���� ����(����1)");
		System.out.println("��ڼ� : ");
		
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] :");
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort(x,nx);
		
		System.out.println("����� ����");
		
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]=" + x[i]);
		}
		
	}
}