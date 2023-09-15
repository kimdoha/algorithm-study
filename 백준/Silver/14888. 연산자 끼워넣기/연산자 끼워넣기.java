import java.io.*;
import java.util.*;

public class Main {
  static int N, max_sum = Integer.MIN_VALUE, min_sum = Integer.MAX_VALUE;
  static int[] numbers;
  static char[] operators, selected;
  static boolean[] visited;

  static void rec_func(int k) {
    if(k == N) {
      int sum = numbers[1], opIndex = 1;
      for(int i = 2; i <= N; i++, opIndex++) {
        if(selected[opIndex] == '+') sum += numbers[i];
        else if(selected[opIndex] == '-') sum -= numbers[i];
        else if(selected[opIndex] == '*') sum *= numbers[i];
        else if(selected[opIndex] == '/') sum /= numbers[i];
      }

      if(max_sum < sum) max_sum = sum;
      if(min_sum > sum) min_sum = sum;

    } else {
      for(int cand = 1; cand < N; cand++) {
        if(visited[cand]) continue;

        selected[k] = operators[cand]; visited[cand] = true;
        rec_func(k + 1);
        selected[k] = 0; visited[cand] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    numbers = new int[N + 1];
    visited = new boolean[N];
    operators = new char[N];
    selected = new char[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) numbers[i] = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    int addCount = Integer.parseInt(st.nextToken());      // 덧셈 카운트
    int minusCount = Integer.parseInt(st.nextToken());    // 마이너스 카운트
    int multipleCount = Integer.parseInt(st.nextToken()); // 곱셈 카운트
    int divideCount = Integer.parseInt(st.nextToken());   // 나눗셈 카운트

    for(int i = 1; i <= addCount; i++) sb.append('+');
    for(int i = 1; i <= minusCount; i++) sb.append('-');
    for(int i = 1; i <= multipleCount; i++) sb.append('*');
    for(int i = 1; i <= divideCount; i++) sb.append('/');

    String expression = sb.toString();
    for(int i = 0; i < expression.length(); i++) operators[i + 1] = expression.charAt(i);

    rec_func(1); // 연산자에 대한 Brute Force
    System.out.println(max_sum);
    System.out.println(min_sum);
  }
}