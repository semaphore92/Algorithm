import javax.lang.model.element.Element;

import jdk.tools.jlink.resources.plugins;

public class Queue_Q6<T> {
    private int max; // 큐의 용량
    private int front; // 첫 번째 커서
    private int rear;  // 마지막 커서
    private static int num;   // 데이터의 수
    private static Object[] que; 
    
    public static void main(String[] args) {
       Queue_Q6<Integer> q = new Queue_Q6<Integer>();
       q.IntQueue(10);
    }

    public void IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;

        que = new Object[max];
    }

    public void enque(T x) {
        que[rear++] = x;
        num++;

        if(rear == max){
            rear = 0;
        }
    }

    public T deque(){
        T x = (T)que[front];
        que[front++] = 0;

        num--;

        if(front == max){
            front = 0;
        }

        return x;
    }
    
    public int search(T x){
        for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x) // 검색성공
				return i + 1;
		return 0; // 검색실패
    }

  
}