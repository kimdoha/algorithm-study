class Solution {
    public int solution(int[] scovilles, int K) {
    int answer = 0;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int scovile : scovilles) {
      minHeap.add(scovile);
    }

    while(minHeap.size() > 1 && minHeap.peek() < K) {
      int first_scovile = minHeap.poll(),
          second_scovile = minHeap.poll();
      minHeap.add(first_scovile + (second_scovile * 2));
      answer++;
    }

    return minHeap.peek() >= K ? answer : -1;
  }
}