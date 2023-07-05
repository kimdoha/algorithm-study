import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] solution(int[] prices) {
    List<Integer> answer = new ArrayList<>();

    for(int i = 0; i < prices.length; i++) {
      int seconds = 0;
      int price = prices[i];

      for(int j = i + 1; j < prices.length; j++) {
        seconds++;

        if (price > prices[j])
          break;
      }

      answer.add(seconds);
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}