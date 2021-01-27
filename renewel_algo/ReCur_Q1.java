public class ReCur_Q1 {
    
    static int factorial(int n){
        if(n > 0) {
            return n * factorial(n - 1);
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {

        int num = 10;
        int sum = 1;
        for(int i = num; 1 < i; i--){
            sum *= i;
            System.out.println(sum);
        }
        System.out.println();
        System.out.println(sum);


    }
  
}