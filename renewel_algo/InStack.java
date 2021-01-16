
public class InStack {

    private int max;
    private int ptr;
    private int[] stk;
    
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException(){}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public IntStack(int capacity){
        ptr = 0;
        max = capacity;

        try {
            stk = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }

    }

    public int push(int x) throws OverflowIntStackException {
        if(ptr >= max){
            throw new OverflowIntStackException();
        }

        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0){
            throw new EmptyIntStackException();
        }

        return stk[--ptr];
    }

    public int peek() throws EmptyIntStackException{
        if(ptr <= 0 ){
            throw new EmptyIntStackException();
        }
        return stk[ptr-1];
    }

}