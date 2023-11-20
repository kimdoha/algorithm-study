import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static void preprocess(int n) {
        // dp 초기화
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        // dp 점화식 채우기
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        preprocess(n);
        System.out.println(dp[n]);
    }
}