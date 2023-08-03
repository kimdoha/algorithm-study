import java.util.Arrays;

class Solution {
  public int solution(int[] people, int limit) {
    int answer = 0;

    Arrays.sort(people);
    
    int L = 0;
    int R = people.length - 1;

    while(L <= R){
      if(people[L] + people[R] <= limit) {
        L++;
      }
      R--;
      answer++;
    }

    return answer;
  }
}