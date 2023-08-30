import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 1. 우선 순위 큐(내림 차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities) {
            pq.add(priority);
        }
        
        // 2. 해당 프로세스(location)가 몇 번째로 실행되는지 계산
        int answer = 1;
        while(!pq.isEmpty()) {

            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    if(i == location) return answer;
                    
                    pq.poll();
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}