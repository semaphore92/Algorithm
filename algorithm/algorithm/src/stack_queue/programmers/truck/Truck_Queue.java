package stack_queue.programmers.truck;

import java.util.LinkedList;
import java.util.Queue;

public class Truck_Queue {

	public static void main(String[] args) {
		solution(2, 10, new int[] { 7,4,5,6 });
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		Queue<Integer> queue = new LinkedList<Integer>();   // 다리
		int len = truck_weights.length;                     // 정류장의 크기
		
		int sum_weight = 0; // 다리 위의 총 무게
		int idx = 0;        // 트럭 index
		int max = 0;        // 도착한 트럭 수
		int answer = 0;     // 소요 시간
		
		
		while(len != max) { // 시작 정류장 트럭 수 == 도착한 트럭 수
			int truck = truck_weights[idx];   
			int arrive_weight = 0;
			
			// 다리 끝에 도착한 트럭 내보내기
			if( bridge_length == queue.size() ) {
				arrive_weight = queue.poll();
				sum_weight -= arrive_weight;
			}

			// 트럭 입장 여부 판단
			if( bridge_length > queue.size() ) {
				sum_weight += truck;
				
				// 다리 무게 체크
				if(weight >= sum_weight) {
					queue.offer(truck);
					
					//★ 트럭 1대 예외처리 (트럭 1대일때 자꾸 에러나서 강제로 박음) 잘못 짠듯 구조를.....
					if(len-1 > idx) {
						idx++;
					}
				// 다리 무게 초과 시 , 0
				}else {
					queue.offer(0);
					sum_weight -= truck;
				}
			}
			
			// 도착한 트럭 수 ++ 
			if(arrive_weight != 0) {
				max++;
			}
			
			answer++;
		}
		
		System.out.println(answer);
		return answer;
	}
}
