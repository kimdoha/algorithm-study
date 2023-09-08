import java.io.*;
import java.util.*;

class Main {
  static int n, m;
  static int[] parents;
  static StringBuilder sb = new StringBuilder();

  static int find(int a) {
    if(parents[a] == a) return a;
    return parents[a] = find(parents[a]);
  }

  static void union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if(aRoot < bRoot) {
      parents[bRoot] = aRoot;
    } else {
      parents[aRoot] = bRoot;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    parents = new int[n + 1];
    for(int i = 1; i <= n; i++) {
      parents[i] = i;
    }

    while(m --> 0) {
      st = new StringTokenizer(br.readLine());

      int type = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(type == 0) {
        union(a, b);
      } else {
        if(find(a) == find(b)) sb.append("YES").append("\n");
        else sb.append("NO").append("\n");
      }
    }



    System.out.println(sb.toString());
  }
}