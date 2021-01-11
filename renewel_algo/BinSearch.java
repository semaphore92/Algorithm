
public class BinSearch {
    public static void main(String[] args) {
        int num = 5;
        int[] x = new int[5];
        
        for( int i = 0; i < num; i++){
            x[i] = i+1;
        }

        int key = 5;
        int idx = binSearch(x, num, key);

        System.out.println(idx);

    }

    static int binSearch(int[] a, int n, int key){
        int pl = 0;
        int pr = n - 1;


        do {
            int pc = (pl + pr) / 2;
            // 중앙 기준 값이 키 값과 같으면 바로 Return
            if(a[pc] == key){
                return pc;
            }else if(a[pc] < key){
                pl = pc + 1;
            }else{
                pr = pc - 1;
            } 
        } while(pl <= pr);

        return -1;
    }
}