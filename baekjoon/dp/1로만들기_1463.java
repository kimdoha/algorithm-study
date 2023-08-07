import java.io.*;

class Solution {
    
    static int[] DP;
    
    public int solution(int num) {
      DP = new int[num + 1];
  
      DP[1] = 0;
      for(int i = 2; i <= num; i++) {
        DP[i] = DP[i - 1] + 1;
        if(i % 3 == 0) DP[i] = Math.min(DP[i], DP[i / 3] + 1);
        if(i % 2 == 0) DP[i] = Math.min(DP[i], DP[i / 2] + 1);
      }
  
      return DP[num];
    }
  }
  
  public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
  
      Solution instance = new Solution();
      System.out.println(instance.solution(num));
    }
  }
  