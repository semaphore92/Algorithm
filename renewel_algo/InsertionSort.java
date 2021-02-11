public class InsertionSort {
    
    public static void main(String[] args) {
        insertionSort(new int[]{6,4,1,7,3,9,8}, 7);
    }

    static void insertionSort(int[] a, int n){
        
        // 단순 삽입 정렬을 2번째 순서부터 시작하고
        for(int i = 1; i < n; i++){
            int j;
            // tmp 변수에 넣어 놓는다.
            int tmp = a[i];
            
            // i에서 0이전까지 tmp의 값보다 앞의 값이 크면 땡김
            for(j = i; j > 0 && a[j-1] > tmp; j --){
                a[j] = a[j -1];
            }

            a[j] = tmp;
        }
    }
}