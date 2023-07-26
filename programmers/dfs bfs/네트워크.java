import java.util.ArrayList;

class Solution {

  static boolean[] visited;
  static ArrayList<Integer>[] graph;

  public void dfs(int x) {
    visited[x] = true;
    for(int y : graph[x]) {
      if(visited[y])
        continue;
      
      dfs(y);
    }
  }
  
  public int solution(int n, int[][] computers) {
    int answer = 0;

    graph = new ArrayList[n];
    for(int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    visited = new boolean[n];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(i == j) continue;
        if(computers[i][j] == 1) {
          graph[i].add(j);
          graph[j].add(i);
        }
      }
    }

    for(int v = 0; v < n; v++) {
      if(!visited[v]){
        dfs(v);
        answer++;
      }
    }

    return answer;
  }
}