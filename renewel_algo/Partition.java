public class Partition {

    public static void main(String[] args) {
        int[] arr = {10,50,80,90,70};

        quick_Sort(arr,0,arr.length-1);
    }
    private static void quick_Sort(int[] arr, int start, int end){

        int left = start;
        int right = end;
        int pivot = arr[(left+right)/2];

        do{
            // 0부터 피벗까지 
            while(arr[left]<pivot){
                left++;
            }
         
            // 끝에서부터 피벗까지
            while(arr[right]>pivot){
                right--;
            }
            
            // 만약에 같으면 ++, --로 교차 
            // 그리고 탈출
            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left ++;
                right --;
            }

        }while(left<= right);

        //교차되니까
        if (start < right) {
            quick_Sort(arr, start, right);
 
        }
        if (end > left) {
            quick_Sort(arr, left, end);
        }
    }
}