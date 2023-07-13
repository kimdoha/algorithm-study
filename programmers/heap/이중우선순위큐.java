import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
  public int[] solution(String[] operations) {

    PriorityQueue<Integer> total_heap = new PriorityQueue<>();
    PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min_heap = new PriorityQueue<>();

    for(int i = 0; i < operations.length; i++) {
      String[] operation = operations[i].split(" ");
      if(operation[0].equals("I")) {
        total_heap.add(Integer.valueOf(operation[1]));
      }
      else if (operation[0].equals("D")) {
        if(total_heap.isEmpty()) continue;

        // 최대 힙 삭제
        if(operation[1].equals("1")) {
          extractedMaxOrMinValue(total_heap, max_heap);
          // 최소 힙 삭제
        } else {
          extractedMaxOrMinValue(total_heap, min_heap);
        }
      }
    }

    int max = total_heap.isEmpty() ? 0 : extractedMaxOrMinValue(total_heap, max_heap);
    int min = total_heap.isEmpty() ? 0 : extractedMaxOrMinValue(total_heap, min_heap);

    return new int[]{max, min};
  }

  private static int extractedMaxOrMinValue(PriorityQueue<Integer> total_heap, PriorityQueue<Integer> heap) {
    heap.clear();
    heap.addAll(total_heap);
    int value = heap.poll();
    total_heap.clear();
    total_heap.addAll(heap);

    return value;
  }

  public static void main(String[] args) {
    이중우선순위큐 instance = new 이중우선순위큐();
    System.out.println(instance.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
    System.out.println(instance.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
  }
}
