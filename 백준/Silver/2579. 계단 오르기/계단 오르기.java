import java.io.*;
import java.util.*;

public class Main {
     static int N;
     static int[][] dp;
     static int[] stairs;
    
     static void preprocess() {
         dp[1][0] = 0;
         dp[1][1] = stairs[1];
         
         if(N >= 2) {
             dp[2][0] = stairs[2];
             dp[2][1] = stairs[1] + stairs[2];
         }
         
         for(int i = 3; i <= N; i++) {
             dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
             dp[i][1] = dp[i - 1][0] + stairs[i];
         }
     }
    
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1][2];

        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        preprocess();
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}