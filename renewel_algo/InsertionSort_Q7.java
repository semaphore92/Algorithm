public class InsertionSort_Q7 {
    
    public static void main(String[] args) {
        insertionSort(new int[]{6,4,1,7,3,9,8}, 7);
    }

    static void insertionSort(int[] a, int n){
        
        for(int i = 0; i < n; i++){
            int key = a[i];
            int pl = 0; //검색범위 맨 앞의 인덱스
            int pr = i-1; // 검색범위 맨 뒤의 인덱스
            int pc; // 중앙 인덱스
            int pd; // 삽입하는 위치의 인덱스
   
            // 이진 검색
            do{
                pc = (pl+pr) /2;

                if(a[pc] == key){
                    break;
                }else if(a[pc] < key){
                    pl = pc+1;
                }else{
                    pr = pc -1;
                }
            }while(pl <= pr);

            pd = (pl <= pr) ? pc + 1: pr +1;

            for(int j = i; j > pd; j--){
                a[j] = a[j-1];
            }
            a[pd] = key;

        }
    }
}