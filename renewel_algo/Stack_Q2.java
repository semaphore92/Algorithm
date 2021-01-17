
public class Stack_Q2<T> {

    private int max;
    private int ptr;
    private T[] stk;

    public static void main(String[] args) {
       Stack_Q2<String> stack = new Stack_Q2<>();
       stack.IntStack(5);

       stack.push("abc");
       System.out.println(stack.pop());
    }
    
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException(){}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public void IntStack(int capacity){
        ptr = 0;
        max = capacity;

        try {
            stk = (T[])new Object[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }

    }

    public T push(T x) throws OverflowIntStackException {
        if(ptr >= max){
            throw new OverflowIntStackException();
        }

        return stk[ptr++] = x;
    }

    public T pop() throws EmptyIntStackException {
        if (ptr <= 0){
            throw new EmptyIntStackException();
        }

        return stk[--ptr];
    }

    public T peek() throws EmptyIntStackException{
        if(ptr <= 0 ){
            throw new EmptyIntStackException();
        }
        return stk[ptr-1];
    }

}