import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[] solution(int[] array, int[][] commands) {

    List<Integer> answer = new ArrayList<>();

    for(int[] command : commands) {
      int i = command[0] - 1, j = command[1], k = command[2] - 1;

      int[] sub_array = Arrays.copyOfRange(array, i, j);
      Arrays.sort(sub_array);
      answer.add(sub_array[k]);
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}