import javax.lang.model.element.Element;

import jdk.tools.jlink.resources.plugins;

public class IntQueue {
    private int max; // 큐의 용량
    private int front; // 첫 번째 커서
    private int rear;  // 마지막 커서
    private int num;   // 데이터의 수
    private int[] que; 
    
    public static void main(String[] args) {
    
    }

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;

        que = new int[max];
    }

    public int enque(int x) {
        que[rear++] = x;
        num++;

        if(rear == max){
            rear =0;
        }
        
        return x;
    }

    public int deque(){
        int x = que[front++];
        num--;

        if(front == max){
            front = 0;
        }

        return x;
    }

  
}