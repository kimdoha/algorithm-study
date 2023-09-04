import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[] selected;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  static void rec_func(int k, int start) {
    if(k == M + 1) {
      for(int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
      sb.append("\n");
    } else {
      for(int cand = start; cand <= N; cand++) {
        selected[k] = cand;
        rec_func(k + 1, cand);
        selected[k] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];
    selected = new int[M + 1];
    rec_func(1, 1);
    System.out.println(sb.toString());
  }
}
