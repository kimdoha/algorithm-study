import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static class Location {
        int x, y;
        
        public Location(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
    
    static void bfs(Location start) {
        Queue<Location> que = new LinkedList<>();
        que.add(start);
        visited[start.x][start.y] = true;
        
        while(!que.isEmpty()) {
            Location cur = que.poll();
            
            for(int i = 0; i < 4; i++) {
                int tx = cur.x + dxdy[i][0];
                int ty = cur.y + dxdy[i][1];
                
                if(tx < 0 || tx >= N || ty < 0 || ty >= M) continue; // 1. 미로 범위를 벗어난 경우
                if(visited[tx][ty]) continue; // 2. 이미 방문한 경우
                if(map[tx][ty] == 0) continue; // 3. 이동할 수 없는 칸인 경우
                
                que.add(new Location(tx,ty));
                visited[tx][ty] = true;
                map[tx][ty] = map[cur.x][cur.y] + 1;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
         String info = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = info.charAt(j) - '0';
            }
        }
        
        bfs(new Location(0,0));
        System.out.println(map[N - 1][M - 1]);
    }
}