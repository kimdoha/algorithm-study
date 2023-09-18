import java.io.*;
import java.util.*;

public class Main {
  static final Integer N_POLE = 0, S_POLE = 1;
  static final Integer CLOCK = 1, UN_CLOCK = -1;
  static final Integer GEAR_SIZE = 8;
  static ArrayList<Integer>[] gear;
  static boolean[] visited;
  static int K, score = 0;

  static void clockWiseRotation(int index) {
    int value = gear[index].remove(GEAR_SIZE - 1);
    gear[index].add(0, value);
  }

  static void counterClockWiseRotation(int index) {
    int value = gear[index].remove(0);
    gear[index].add(value);
  }

  static void bfs(Rotation start) {
    List<Rotation> rotations = new ArrayList<>();
    Queue<Rotation> que = new LinkedList<>();
    que.add(start);
    visited[start.index] = true;

    while(!que.isEmpty()) {
      Rotation cur = que.poll();
      rotations.add(cur);

      int LR_DIR = cur.direction == CLOCK ? UN_CLOCK : CLOCK;
      if(cur.index >= 1) {
        int left = cur.index - 1;
        if(!visited[left] &&
            gear[left].get(2) != gear[cur.index].get(6)) {
          que.add(new Rotation(left, LR_DIR));
          visited[left] = true;
        }
      }

      if(cur.index < 3) {
        int right = cur.index + 1;
        if(!visited[right] &&
            gear[right].get(6) != gear[cur.index].get(2)) {
          que.add(new Rotation(right, LR_DIR));
          visited[right] = true;
        }
      }
    }

    for(Rotation gear : rotations) {
      if(gear.direction == CLOCK) clockWiseRotation(gear.index);
      else counterClockWiseRotation(gear.index);
    }
  }

  static class Rotation {
    int index;
    int direction;

    public Rotation(int _index, int _direction) {
      this.index= _index;
      this.direction = _direction;
    }
  }

  static void calculateScore() {
    score += gear[0].get(0) == S_POLE ? 1 : 0;
    score += gear[1].get(0) == S_POLE ? 2 : 0;
    score += gear[2].get(0) == S_POLE ? 4 : 0;
    score += gear[3].get(0) == S_POLE ? 8 : 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    gear = new ArrayList[4];
    for(int i = 0; i < 4; i++) gear[i] = new ArrayList<>();

    for(int i = 0; i < 4; i++) {
      String[] gearInfo = br.readLine().split("");
      for(String info : gearInfo) gear[i].add(Integer.parseInt(info));
    }

    K = Integer.parseInt(br.readLine());
    while(K --> 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken()) - 1;
      int direction = Integer.parseInt(st.nextToken());

      visited = new boolean[4];
      bfs(new Rotation(start, direction));
    }

    calculateScore();
    System.out.println(score);
  }
}
