import java.util.Scanner;


public class SeqSearch {
    public static void main(String[] args) {
        int num = 5;
        int[] x = new int[6];
        
        for( int i = 0; i < num; i++){
            x[i] = i+1;
        }

        int key = 1;
        int idx = SeqSearchSen(x, num, key);

        System.out.println(idx);

    }

    static int SeqSearchSen(int[] a, int n, int key){
        int i = 0;
        a[n] = key;

        while(true){
            if(a[i] == key){
                System.out.println(i);
                break;
            }
            i++;
        }
        return i == n ?-1:i;
    }
}