import java.util.*;

class Solution {
  
    public int calculateWorkdays(int progress, int speed) {
        return (int) Math.ceil((100.0 - progress) / speed);
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
          int day = calculateWorkdays(progresses[i], speeds[i]);
          queue.add(day);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty()) {
          int minDays = queue.poll();
          int count = 1;

          while(!queue.isEmpty() && queue.peek() <= minDays){
            count++;
            queue.poll();
          }
          answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}