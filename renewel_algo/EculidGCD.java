public class EculidGCD {
    
    static int gcd(int x, int y){
        if(y==0){
            return x;
        }else{
            return gcd(y, x%y);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(8,22));
    }
  
}