public class BubbleSort_Q1 {
    
    public static void main(String[] args) {
        int[] arry = new int[]{1,8,5,3,7};

        bubbleSort(arry, 5);

        for (int i : arry) {
            System.out.println(i);
        }

    }

    static void swap(int [] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n){
        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
    }
}