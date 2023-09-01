import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[] selected, numbers;
  static StringBuilder sb = new StringBuilder();

  static void rec_func(int k) {
    if(k == M + 1) {
      for(int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
      sb.append("\n");
    } else {
      for(int cand = 1; cand <= N; cand++) {
        selected[k] = numbers[cand];
        rec_func(k + 1);
        selected[k] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    numbers = new int[N + 1];
    selected = new int[M + 1];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());;
    }

    Arrays.sort(numbers);
    rec_func(1);
    System.out.println(sb.toString());
  }
}