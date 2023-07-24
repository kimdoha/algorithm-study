import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  static ArrayList<Integer>[] graph;
  static int[] dist;
  static boolean[] visited;
    
  public int solution(int n, int[][] edges) {
    int answer = 0;

    graph = new ArrayList[n + 1];
    for(int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    visited = new boolean[n + 1];
    dist = new int[n + 1];

    for(int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    bfs(1);
    int maxEdgeCount = Arrays.stream(dist).max().getAsInt();

    return (int) Arrays.stream(dist).filter(v -> v == maxEdgeCount).count();
  }

  public void bfs(int start) {
    Queue<Integer> que = new LinkedList<>();

    que.add(start);
    visited[start] = true;

    dist[start] = 1;

    while(!que.isEmpty()) {
      int x = que.poll();

      for(int y : graph[x]) {
        if(visited[y])
          continue;

        dist[y] = dist[x] + 1;
        que.add(y);
        visited[y] = true;
      }
    }
  }
}