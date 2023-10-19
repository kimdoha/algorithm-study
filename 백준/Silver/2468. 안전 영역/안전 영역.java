import java.io.*;
import java.util.*;

public class Main {
   static int N;
  static int[][] area;
  static boolean[][] visited;
  static int maxSafeArea = 0;
  static int[][] dxdy = new int[][]{
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  static class Location {
    int x, y;

    public Location(int _x, int _y) {
      x = _x;
      y = _y;
    }
  }

  static void dfs(Location loc, int target) {
    visited[loc.x][loc.y] = true;

    for(int i = 0; i < 4; i++) {
      int tx = loc.x + dxdy[i][0], ty = loc.y + dxdy[i][1];

      if(tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
      if(visited[tx][ty]) continue;
      if(area[tx][ty] <= target) continue;

      dfs(new Location(tx, ty), target);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    area = new int[N][N];

    int maxHeight = 0;
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        area[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, area[i][j]);
      }
    }



    for(int height = 0; height <= maxHeight; height++) {
      visited = new boolean[N][N];
      int areaCnt = 0;

      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(!visited[i][j] && area[i][j] > height) {
              dfs(new Location(i, j), height);
              areaCnt++;
            }
          }
      }

      // System.out.printf( "height : %d areaCnt : %d maxSafeArea :  %d\n", height, areaCnt, maxSafeArea );
      maxSafeArea = Math.max(areaCnt, maxSafeArea);
    }

    System.out.println(maxSafeArea);
  }
}
