import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    
    int solution(int[] priorities, int location) {
        int answer = 1;
    
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        for(int priority : priorities) {
          queue.add(priority);
        }
    
        while(!queue.isEmpty()){
          for(int i = 0; i < priorities.length; i++)
    
            if(queue.peek() == priorities[i]) {
              if(i == location) return answer;
    
              queue.poll();
              answer++;
            }
        }
    
        return answer;
    }
}