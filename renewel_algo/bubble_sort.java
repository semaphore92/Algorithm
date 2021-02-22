public class bubble_sort {

    public static void main(String[] args) {
        int[] arr = {10,50,80,90,70};
        quick_Sort(arr,0,arr.length-1);
    }
    

    public void bubble (int[] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }

        }



    }
}