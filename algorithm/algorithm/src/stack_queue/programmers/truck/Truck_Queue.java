package stack_queue.programmers.truck;

import java.util.LinkedList;
import java.util.Queue;

public class Truck_Queue {

	public static void main(String[] args) {
		solution(2, 10, new int[] { 7,4,5,6 });
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		Queue<Integer> queue = new LinkedList<Integer>();   // �ٸ�
		int len = truck_weights.length;                     // �������� ũ��
		
		int sum_weight = 0; // �ٸ� ���� �� ����
		int idx = 0;        // Ʈ�� index
		int max = 0;        // ������ Ʈ�� ��
		int answer = 0;     // �ҿ� �ð�
		
		
		while(len != max) { // ���� ������ Ʈ�� �� == ������ Ʈ�� ��
			int truck = truck_weights[idx];   
			int arrive_weight = 0;
			
			// �ٸ� ���� ������ Ʈ�� ��������
			if( bridge_length == queue.size() ) {
				arrive_weight = queue.poll();
				sum_weight -= arrive_weight;
			}

			// Ʈ�� ���� ���� �Ǵ�
			if( bridge_length > queue.size() ) {
				sum_weight += truck;
				
				// �ٸ� ���� üũ
				if(weight >= sum_weight) {
					queue.offer(truck);
					
					//�� Ʈ�� 1�� ����ó�� (Ʈ�� 1���϶� �ڲ� �������� ������ ����) �߸� §�� ������.....
					if(len-1 > idx) {
						idx++;
					}
				// �ٸ� ���� �ʰ� �� , 0
				}else {
					queue.offer(0);
					sum_weight -= truck;
				}
			}
			
			// ������ Ʈ�� �� ++ 
			if(arrive_weight != 0) {
				max++;
			}
			
			answer++;
		}
		
		System.out.println(answer);
		return answer;
	}
}