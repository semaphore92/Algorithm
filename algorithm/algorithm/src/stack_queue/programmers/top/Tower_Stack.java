package stack_queue.programmers.top;

import java.util.Stack;

public class Tower_Stack {
	public static void main(String[] args) {
		solution(new int[] { 6, 9, 5, 7, 4 });
	}
	
	public static int[] solution(int[] heights) {
		int size = heights.length - 1 ;
	    int a = 0;
	    int inx = size;
	
	
	    //결과값 선언
	    int[] answer = new int[size + 1];	        
	    Stack<Integer> stack = new Stack<Integer>(); 
	    
	    //Stack Setting
	    for( int num : heights ){
	        stack.push(num);
	    }
	    
	    while( !stack.isEmpty() ){
	    	//후입선출
	    	a = stack.pop();
	    	
	    	while( 0 < inx ){
	    		
	    		if(a < heights[inx-1] ){
	    			answer[size] = inx;
	    			break;
	    		}
	    		
	    		inx--;
	    	}
	    	
	    	//
	    	if(inx==0){
	    		answer[size] = 0;
	    	}
	    	
	    	size--;
	    	inx = size;
	        
	    }
	    return answer;
	}
}
