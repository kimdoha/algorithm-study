import java.io.*;
import java.util.*;


public class Main {
  static int N, M;
  static int[] numbers, selected;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  static void rec_func(int k) {
    if(k == M + 1) {
      for(int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
      sb.append("\n");
    } else {
      int lastNum = 0;
      for(int i = 1; i <= N; i++) {
        if(visited[i]) continue;
        if(lastNum == numbers[i]) continue;
          
          selected[k] = numbers[i]; visited[i] = true;
          lastNum = numbers[i];
          rec_func(k + 1);
          selected[k] = 0; visited[i] = false;
        }
     }
  }
 

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    numbers = new int[N + 1];
    visited = new boolean[N + 1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(numbers);

    selected = new int[M + 1];
    rec_func(1);
    System.out.println(sb.toString());
  }
}