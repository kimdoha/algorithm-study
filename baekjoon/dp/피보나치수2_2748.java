import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
  static Long[] DP;
  
  public Long solution(int n) {
    DP = new Long[91];

    DP[0] = 0L;
    DP[1] = 1L;

    for(int i = 2; i <= n; i++) {
      DP[i] = DP[i-1] + DP[i-2];
    }

    return DP[n];
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Solution instance = new Solution();
    System.out.println(instance.solution(n));
  }
}