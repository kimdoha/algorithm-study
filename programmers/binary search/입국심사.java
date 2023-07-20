import java.util.Arrays;

class Solution {
  public boolean determination(int n, long mid, int[] times) {
   long sum = 0;

   for(int time : times) {
     sum += mid / time;
   }

   return n <= sum;
  }

  public long solution(int n, int[] times) {
    Arrays.sort(times);
    long L = 0, R = (long) n * times[times.length - 1], answer = 0;
    
    while(L <= R) {
      long mid = (L + R) / 2;

      if(determination(n, mid, times)) {
        answer = mid;
        R = mid - 1;
      } else {
        L = mid + 1;
      }
    }

    return answer;
  }
}