package stack_queue.programmers.top;

import java.util.LinkedList;
import java.util.Queue;

public class Tower_Queue {

	public static void main(String[] args) {
		solution(new int[] { 6, 9, 5, 7, 4 });
	}

	public static int[] solution(int[] heights) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int size = heights.length ;    // int[] Size
		int[] answer = new int[size];  // answer 길이 설정

		// Queue Setting
		for(int i = size - 1; 0 <= i ; i--) {
			queue.offer(heights[i]);
		}

		//Queue가 Empty일까지 실행
		while(!queue.isEmpty()) {
			int first = queue.poll();
			
			for(int i = queue.size(); 0 <= i ; i--) {
				if(heights[i] > first) {
					answer[queue.size()] = i+1;
					break;
				}else {
					answer[queue.size()] = 0;
				}
			}	
		}
		
		return answer;
	}
}
