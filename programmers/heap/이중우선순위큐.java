import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
   public int[] solution(String[] operations) {

    PriorityQueue<Integer> min_heap = new PriorityQueue<>();
    PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

    for(int i = 0; i < operations.length; i++) {
      String[] operation = operations[i].split(" ");
      if(operation[0].equals("I")) {
        int value = Integer.valueOf(operation[1]);
        min_heap.add(value);
        max_heap.add(value);
      } else if (operation[0].equals("D")) {
        // 최대 힙 삭제
        if(operation[1].equals("1")) {
          if(max_heap.isEmpty()) continue;
          int value = max_heap.poll();
          min_heap.remove(value);
          // 최소 힙 삭제
        } else {
          if(min_heap.isEmpty()) continue;
          int value = min_heap.poll();
          max_heap.remove(value);
        }
      }
    }

    int max = max_heap.isEmpty() ? 0 : max_heap.poll();
    int min = min_heap.isEmpty() ? 0 : min_heap.poll();

    return new int[]{max, min};
  }
}