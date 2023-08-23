import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static final int MOD = 1_000_000_007;
  static long[] dp = new long[5001];

  static void solution() {
    dp[0] = 1;
    dp[2] = 1;

    for(int i = 4; i <= 5001; i += 2) {
      for(int j = 0; j < i; j += 2) {
        dp[i] += dp[i - j - 2] * dp[j];
        dp[i] %= MOD;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    solution();

    StringBuilder sb = new StringBuilder();
    while(T --> 0) {
      int L = Integer.parseInt(br.readLine());

      if (L % 2 == 1) {
        sb.append(0).append("\n");
      } else {
        sb.append(dp[L]).append("\n");
      }
    }

    System.out.println(sb.toString());
  }
}
