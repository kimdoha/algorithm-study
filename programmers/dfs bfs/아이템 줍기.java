import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
  static int[][] map, dist, dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static boolean[][] visited;
  static int characterX, characterY, itemX, itemY;
  static int answer;
    
  class Location {
    int x;
    int y;
    public Location(int _x, int _y) {
      this.x = _x;
      this.y = _y;
    }
  }
  public boolean isValidLocation(int x, int y) {
    return x >= 1 && x <= 100 &&
        y >= 1 && y <= 100 &&
        map[y][x] == 1 &&
        !visited[y][x];
  }

  public void bfs() {
    Queue<Location> que = new LinkedList<>();

    que.add(new Location(characterX, characterY));
    visited[characterY][characterX] = true;
    dist[characterY][characterX] = 1;

    while(!que.isEmpty()) {
      Location current = que.poll();

      if(current.x == itemX && current.y == itemY) {
        answer = dist[current.y][current.x];
        return;
      }

      for(int i = 0; i < 4; i++) {
        int tempX = current.x + dir[i][0];
        int tempY = current.y + dir[i][1];

        if(isValidLocation(tempX, tempY)){
          que.add(new Location(tempX, tempY));
          visited[tempY][tempX] = true;
          dist[tempY][tempX] = dist[current.y][current.x] + 1;
        }
      }

    }
  }

  public void fillBorderToOne(int l_x, int l_y, int r_x, int r_y) {
    for(int i = l_y; i <= r_y; i++) {
      for(int j = l_x; j <= r_x; j++) {
        if(map[i][j] == 2) continue;
        if(i == l_y ||
           i == r_y ||
           j == l_x ||
           j == r_x) map[i][j] = 1;
        else map[i][j] = 2;
      }
    }
  }

  public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    map = new int[51 * 2][51 * 2];
    visited = new boolean[51 * 2][51 * 2];
    dist = new int[51 * 2][51 * 2];

    this.characterX = characterX * 2;
    this.characterY = characterY * 2;
    this.itemX = itemX * 2;
    this.itemY = itemY * 2;

    for(int[] rect : rectangle) {
      int left_x = rect[0] * 2,
          left_y = rect[1] * 2;
      int right_x = rect[2] * 2,
          right_y = rect[3] * 2;

      fillBorderToOne(left_x, left_y, right_x, right_y);
    }


    bfs();

    return answer / 2;
  }
}