public class Hanoi {
    
    public static void main(String[] args) {
        move(3,1,3);
        // 1번 기둥의 3개의 원반을 3번 기둥으로 옮김
    }

    static void move(int no, int x, int y){
        if(no > 1){
            move(no -1, x, 6-x-y);
        }
        
        if(no > 1){
            move(no -1 , 6 -x -y,y);
        }

    }
}