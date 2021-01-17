
public class Stack_Q3 {

    private int max;
    private int ptrA;
    private int ptrB;
    private static int[] stk;

    public static void main(String[] args) {
       Stack_Q3 stack = new Stack_Q3();
       stack.IntStack(10);

       stack.push_AStack(1);
       stack.push_AStack(2);
       stack.push_AStack(3);
       stack.push_AStack(4);
       stack.push_BStack(10);
       stack.push_BStack(9);
       stack.push_BStack(8);
       stack.push_BStack(7);
       stack.push_BStack(6);
       stack.push_BStack(5);

       for(int a : stk){
           System.out.println(a);
       }
    }
    
    public void IntStack(int capacity){
        max = capacity-1;

        //pointer Setting
        ptrA =0;
        ptrB =0;

        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e){
            max = 0;
        }

    }

    public int push_AStack(int x) {
        if((max-ptrB) < ptrA){
            return -1;
        }
        return stk[ptrA++] = x;
    }

    public int pop_AStack() {
        return stk[--ptrA];
    }

    public int push_BStack(int x) {
        if((max-ptrA) < ptrB){
            return -1;
        }

        int ptrB_pointer = max - ptrB;
        ptrB++;

        return stk[ptrB_pointer] = x;
    }

    public int pop_BStack() {
        ptrB--;
        int ptrB_pointer = max - ptrB;
        return stk[ptrB_pointer];
    }


}