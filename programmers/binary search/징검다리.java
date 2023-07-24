import java.util.Arrays;

class Solution {
    
public int determination(int[] rocks, int mid, int end) {

    int prev = 0, removeRockCount = 0;

    for(int i = 0; i < rocks.length; i++) {
      if(rocks[i] - prev < mid) {
        removeRockCount++;
      } else {
        prev = rocks[i];
      }
    }

    return removeRockCount;
  }

  public int solution(int distance, int[] rocks, int n) {

    Arrays.sort(rocks);
    int L = 0, R = distance, answer = 0;

    while(L <= R) {
      int mid = (L + R) / 2; 

      if(determination(rocks, mid, distance) <= n) {
        answer = mid;
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }

    return answer;
  }
}