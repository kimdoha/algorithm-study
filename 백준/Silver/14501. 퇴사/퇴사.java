import java.io.*;
import java.util.*;


public class Main {
  static int N, max_cost = 0;;
  static Consult[] consults;

  static class Consult {
    int day;
    int cost;

    public Consult(int _day, int _cost) {
      this.day = _day;
      this.cost = _cost;
    }
  }

  static void dfs(int k, int sum) {
    if(k == N) {
      max_cost = Math.max(max_cost, sum);
    } else {
      int next = k + consults[k].day;
      if(next <= N) dfs(next, sum + consults[k].cost);
      dfs(k + 1, sum);
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    consults = new Consult[N + 1];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      consults[i] = new Consult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    dfs(0, 0);
    System.out.println(max_cost);
  }
}