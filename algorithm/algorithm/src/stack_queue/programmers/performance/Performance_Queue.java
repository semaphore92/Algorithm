package stack_queue.programmers.performance;

import java.util.LinkedList;
import java.util.Queue;

public class Performance_Queue {

	class Develop {
		int progresses;
		int speeds;
		int idx;

		public Develop(int progresses, int speeds, int idx) {
			this.progresses = progresses;
			this.speeds = speeds;
			this.idx = idx;
		}

		public void commit() {
			progresses += speeds;
		}

		public int getProgresses() {
			return progresses;
		}

		public int getSpeeds() {
			return speeds;
		}

		public int getIdx() {
			return idx;
		}

	}

	public static void main(String[] args) {

		Performance_Queue performance = new Performance_Queue();
		performance.solution(new int[] { 93 , 30 , 55 , 60 }, new int[] { 1, 30 , 5 , 40  });
	}

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Develop> queue = new LinkedList<>();
		Queue<Develop> queue2 = new LinkedList<>();
		Queue<Integer> queue3 = new LinkedList<>();

		int finallyCnt = 0;  // 최종 완료 개수 
		int forwardIdx = 0;  // 최전방 Inx

		int progress = 0;
		int index  = 0;

		// Queue Setting
		for (int i = 0; i < progresses.length; i++) {
			queue.offer(new Develop(progresses[i], speeds[i], i));
		}

		while (finallyCnt != progresses.length) {   // 최종 완료 개수 == 프로세스 수 
			Develop develop = queue.poll();
			
			// 개발 진행
			if(develop != null) {
				develop.commit();
				// 진행률 / 인덱스 가져옴
				progress = develop.getProgresses();
				index    = develop.getIdx();
			}

			// 개발 완료된 건은 따로 보관 첫번째 순서부터
			if (progress >= 100 & forwardIdx == index) {
				queue2.offer(develop);
				forwardIdx++;
			} else {
				queue.offer(develop);
				
				// 100% 개발 건 내보내기
				if(!queue2.isEmpty()) {
					queue3.offer(queue2.size());
					finallyCnt += queue2.size();
					queue2.clear();
				}
			}
		}

		
		//결과 담기
		int[] answer = new int[queue3.size()];
		for (int i = 0; i < answer.length; i++) {
			System.out.println(queue3.peek());
			answer[i] = queue3.poll();
		}

		return answer;
	}
}
