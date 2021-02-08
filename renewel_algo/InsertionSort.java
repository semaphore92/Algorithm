public class InsertionSort {
    
    public static void main(String[] args) {
        insertionSort(new int[]{6,4,1,7,3,9,8}, 7);
    }

    static void insertionSort(int[] a, int n){
        for (int i =1; i < n; i ++){
            int j;
            int tmp = a[i];
            for(j =i ; j > 0 && a[j-1] > tmp; j--){
                System.out.println(j);

                a[j] = a[j-1];
            }
            System.out.println("패스");
            a[j] = tmp;
        }
    }
}