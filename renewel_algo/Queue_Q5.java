import javax.lang.model.element.Element;

import jdk.tools.jlink.resources.plugins;

public class Queue_Q5 {
    private int max; // 큐의 용량
    private int front; // 첫 번째 커서
    private int rear;  // 마지막 커서
    private static int num;   // 데이터의 수
    private static int[] que; 
    
    public static void main(String[] args) {
        Queue_Q5 q = new Queue_Q5();
        q.IntQueue(num);

        q.enque(53);
        q.enque(10);
        q.enque(9);
        q.enque(8);
        q.enque(14);
        q.enque(19);

        q.deque();
        q.deque();
        q.deque();

        q.enque(53);
        q.enque(10);
        q.enque(9);


        q.enque(88);
        q.enque(28);
        q.enque(91);


        for(int i : que){
            System.out.println(i);
        }

        System.out.println();
        System.out.println(q.search(10));

    }

    public void IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;

        que = new int[max];
    }

    public int enque(int x) {
        que[rear++] = x;
        num++;

        if(rear == max){
            rear = 0;
        }
        
        return x;
    }

    public int deque(){
        int x = que[front];
        que[front++] = 0;

        num--;

        if(front == max){
            front = 0;
        }

        return x;
    }
    
    public int search(int x){
        for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x) // 검색성공
				return i + 1;
		return 0; // 검색실패
    }

  
}