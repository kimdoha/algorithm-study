import java.util.LinkedList;
import java.util.Queue;

class Solution {

  static int N, M;
  static int[][] map;
  static int[][] dist;
  static boolean[][] visited;
  static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

  class Location {
    int x;
    int y;
    public Location(int _x, int _y) {
      this.x = _x;
      this.y = _y;

    }
  }
  
  public boolean isValid(Location location) {
    return location.x >= 0
        && location.x < N
        && location.y >= 0
        && location.y < M;
  }

  public boolean isWall(Location location) {
    return map[location.x][location.y] == 0;
  }

  public void bfs(Location start) {
    Queue<Location> que = new LinkedList<>();

    que.add(start);
    visited[start.x][start.y] = true;
    dist[start.x][start.y] = 1;

    while(!que.isEmpty()) {
      Location current = que.poll();

      for(int i = 0; i < 4; i++) {
        int temp_x = current.x + dir[i][0];
        int temp_y = current.y + dir[i][1];

        Location move = new Location(temp_x, temp_y);
        if(isValid(move) &&
            !isWall(move) &&
            !visited[move.x][move.y]) {
          que.add(move);
          visited[move.x][move.y] = true;
          dist[move.x][move.y] = dist[current.x][current.y] + 1;
        }
      }
    }
  }
  public int solution(int[][] maps) {

    N = maps.length;
    M = maps[0].length;
    map = maps;
    visited = new boolean[N][M];
    dist = new int[N][M];

    bfs(new Location(0, 0));

    return dist[N - 1][M - 1] > 0 ? dist[N - 1][M - 1] : -1;
  }
}