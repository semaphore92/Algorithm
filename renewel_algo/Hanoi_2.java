
public class Hanoi_2 {
    
    static void move(int no, int x, int y){
        if(no > 1){
            move(no-1, x, 6-x-y);
        }

        // n번째 원반을 x기둥에서 y기둥으로 옮김
        System.out.println("원반["+no+"]을"+ x + "기둥에서" + y +" 기둥으로 옮김");

        if(no > 1){
            move(no - 1, 6-x-y, y);
        }
    }

    public static void main(String[] args) {
        move(3,1,3);
    }

  
}