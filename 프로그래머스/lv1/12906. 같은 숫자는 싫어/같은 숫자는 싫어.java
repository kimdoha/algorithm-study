import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        int i = 0;
        while(i < arr.length) {
            int current = arr[i];
            answer.add(current);
            
            int index = i + 1;
            while(index < arr.length && arr[index] == current) {
                index += 1;
            }
            
            i = index;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}