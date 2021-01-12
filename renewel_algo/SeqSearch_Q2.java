
public class SeqSearch_Q2 {
a
    public static void main(String[] args) {
        int num = 6;
        int[] x = new int[6];
        
        for( int i = 0; i < num; i++){
            x[i] = i+1;
        }

        int key = 4;
        int idx = SeqSearchSen(x, num, key);

        System.out.println(idx);

    }

    static int SeqSearchSen(int[] a, int n, int key){
        int idx = 0;

        for(int z = 0; z < a.length; z++){
            System.out.print(z + " |");

            for(int i = 0; i < a.length; i ++){
                System.out.print(a[i] + " ");
            } 

            if(a[z] == key ){
                idx = z;
                break;
            }

            System.out.println();   
        }
        System.out.println();   
        return idx;
    }
}