import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < prices.length; i++) {
            
            int current = prices[i];
            int seconds = 0;
            
            for(int j = i + 1; j < prices.length; j++) {
                seconds++;
                if(prices[j] < current) break;
            }
            
            answer.add(seconds);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}