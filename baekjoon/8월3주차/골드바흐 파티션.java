import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 골드바흐파티션 {

  static boolean[] primeNumbers = new boolean[1000001];

  static class Solution {

    int getNumberOfPartition(int num) {
      int answer = 0;
      
      for(int i = 1; i <= num / 2; i++) {
        if(primeNumbers[i] && primeNumbers[num - i]) answer++;
      }

      return answer;
    }
  }

  static boolean isPrimeNumber(int num) {
    for (int decimal = 2; decimal <= Math.sqrt(num); decimal++ ) {
      if (num % decimal == 0) return false;
    }

    return true;
  }

  static void init() {

    for(int find = 2; find <= 1000000; find++) {
      if(isPrimeNumber(find)) primeNumbers[find] = true;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    int T = Integer.parseInt(br.readLine());
    init();

    Solution solution = new Solution();
    while (T-- > 0) {
      int num = Integer.parseInt(br.readLine());
      System.out.println(solution.getNumberOfPartition(num));
    }
  }
}