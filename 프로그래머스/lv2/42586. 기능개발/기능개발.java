import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    public int calculateWorkDay(int progress, int speed) {
        return (int) Math.ceil((100 * 1.0 - progress) / speed);
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
   
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        // 1. 각 기능별 작업일 수 구하기
        for(int i = 0; i < progresses.length; i++) {
            int workDay = calculateWorkDay(progresses[i], speeds[i]);
            que.add(workDay);
        }
        
        // 2. 각 배포마다 몇 개의 기능이 배포 되는지 계산
        int i = 0;
        while(que.size() > 0) {
            
            int currentWorkDay = que.poll();
            int count = 1;
            
            while(!que.isEmpty() && que.peek() <= currentWorkDay) {
                que.poll();
                count += 1;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}