import java.io.*;
import java.util.*;

public class Main {
  static int n, target;
  static int[] numbers;
  static int expression = 0;

  static void dfs(int k, int sum) {
    if(k == n) {
      if(sum == target) expression++;
    } else {
      dfs(k + 1, sum + numbers[k]); 
      dfs(k + 1, sum);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    target = Integer.parseInt(st.nextToken());

    numbers = new int[n];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());;

    dfs(0, 0);
      
    if(target == 0) expression = expression - 1; // 공집합 제외
    System.out.println(expression);
  }
}
