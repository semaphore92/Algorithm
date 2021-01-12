
public class Search_Q3 {
    public static void main(String[] args) {
        int[] x = new int[]{1,9,2,9,4,6,7,9};

        int key = 9;
        int[] idx = SearchQ3(x, x.length, key);

        for(int a : idx){
            System.out.println(a);
        }
        System.out.println(idx);

    }

    static int[] SearchQ3(int[] a, int n, int key){

        int[] result = new int[n];
        int cnt = 0;

        for(int i = 0; i < a.length; i ++){
            if(a[i] == key){
                result[cnt++]= i;
            }
        }

        return result;
    }
}