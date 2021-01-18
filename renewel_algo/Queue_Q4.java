import java.util.Deque;

public class Queue_Q4 {

    private static int max;
    private static int num = 0;
    private static int[] que;

    public static void main(String[] args) {
        max = 5;
        IntAryQueue();
        inQueue(5);


        Deque
    }
    
    public static void IntAryQueue(){
        try {
            que = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public static int inQueue(int x) {
        return que[num++] = x;
    }

    public int deQueue() {
        int result = que[0];

        for(int i = 0; i < que.length-1; i++){
            que[i] = que[i+1];
        }
        num--;
        return result;
    }


}