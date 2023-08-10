import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
  static int[][] DP;

  public void fillCombination() {
    DP = new int[31][31];

    for(int i = 0; i <= 30; i++){
      DP[i][0] = 1;
      DP[i][i] = 1;
    }

    for(int i = 1; i <= 30; i++){
      for(int j = 1; j <= i; j++) {
        DP[i][j] = DP[i-1][j] + DP[i-1][j-1];
      }
    }
  }
  public int solution(int N, int M) {

    return DP[M][N];
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    Solution instance = new Solution();
    instance.fillCombination();
      
    while(T --> 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      System.out.println(instance.solution(N, M));
    }
  }
}