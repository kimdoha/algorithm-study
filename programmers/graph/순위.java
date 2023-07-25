class Solution {
  
    static int[][] graph;
  
    public int solution(int n, int[][] results) {
      graph = new int[n + 1][n + 1];
      for(int[] result : results) {
        graph[result[0]][result[1]] = 1;
        graph[result[1]][result[0]] = -1;
      }
  
  
      floyd(n);
      int answer = 0;
      for(int v = 1; v <= n; v++) {
        int count = 0;
        
        for(int w = 1; w <= n; w++) {
          if(v == w) continue;
          if(graph[v][w] != 0) count++;
        }
        
        if(count == n - 1) answer++;
      }
  
      return answer;
    }
  
    public void floyd(int n) {
      for ( int k = 1; k <= n; k++ ) {
        for ( int i = 1; i <= n; i++ ) {
          for ( int j = 1; j <= n; j++ ) {
            if(graph[i][k] == 1 && graph[k][j] == 1) {
              graph[i][j] = 1;
              graph[j][i] = -1;
            }
            if(graph[i][k] == -1 && graph[k][j] == -1) {
              graph[i][j] = -1;
              graph[j][i] = 1;
            }
          }
        }
      }
    }
  }