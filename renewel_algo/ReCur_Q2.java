public class ReCur_Q2 {
    
    static int gcd(int x, int y){
        if(y==0){
            return x;
        }else{
            return gcd(y, x%y);
        }
    }

    public static void main(String[] args) {
        int y = 8;
        int x = 22;
        while (y != 0) {
			int temp = y;
			y = x % y;
            x = temp;
            System.out.println(y);
		}
        
        System.out.println(x);
    }
  
}