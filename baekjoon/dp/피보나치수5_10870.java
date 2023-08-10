import java.io.*;

class Solution {
  
  static int[] DP;
    
  public int solution(int n) {
    DP = new int[n + 2];

    DP[0] = 0;
    DP[1] = 1;

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