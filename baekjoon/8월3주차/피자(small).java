import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Solution {
        static int[] DP;

        int solution(int pizza) {
        DP = new int[pizza + 2];

        DP[1] = 0;
        DP[2] = 1;

        for(int i = 3; i <= pizza; i++) {
            DP[i] = i - 1 + DP[i - 1];
        }

        return DP[pizza];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Solution instance = new Solution();
        System.out.println(instance.solution(num));
    }
}
