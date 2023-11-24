import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] dp;
    static int answer = 0;

    static void preprocess() {
        // 초기값 채우기
        for(int num = 0; num <= 9; num++) {
            dp[1][num] = 1;
        }

        // 점화식 채우기
        for(int i = 2; i <= N; i++) {
            for(int num = 0; num <= 9; num++){
                for(int prev = 0; prev <= num; prev++) {
                    dp[i][num] += dp[i - 1][prev];
                    
                }
                dp[i][num] %= 10_007;
            }
        }

        for(int num = 0; num <= 9; num++) {
            answer += dp[N][num];
            answer %= 10_007;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];
        preprocess();
        System.out.println(answer);
    }
}
