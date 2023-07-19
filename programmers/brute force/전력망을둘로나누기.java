import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
  static ArrayList<Integer>[] adj;
  static Boolean[] checked;
  
  public int solution(int n, int[][] wires) {
    int answer = n;

    adj = new ArrayList[n + 1];

    for(int i = 1; i <= n; i++) {
      adj[i] = new ArrayList<>();
    }

    for(int[] wire : wires) {
      adj[wire[0]].add(wire[1]);
      adj[wire[1]].add(wire[0]);
    }

    for(int v = 1; v <= n; v++) {
      for(int child : adj[v]) {
        checked = new Boolean[n + 1];
        Arrays.fill(checked, false);

        dfs(v, v, child);

        int count = (int) Arrays.stream( checked ).filter(ch -> ch).count();
        int another = n - count;

        answer = Math.min(answer, Math.abs(another - count));

      }
    }

    return answer;
  }
  
  void dfs(int v, int x, int y) {
    checked[v] = true;

      for (int child : adj[v]) {
        
        if(v == x && child == y) continue;
        if(v == y && child == x) continue;

        if (!checked[child]) {
          dfs(child, x, y);
        }
      }
  }

}