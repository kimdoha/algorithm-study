import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] field, dist;
    static boolean[][] visited;
    static int days = 0;
    
    static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Location {
        int x, y;
        
        public Location(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
    
    static void bfs(List<Location> locationList) {
        Queue<Location> que = new LinkedList<>();
        
        for(Location loc : locationList) {
            que.add(loc);
            visited[loc.x][loc.y] = true;
            dist[loc.x][loc.y] = 0;
        }
        
        while(!que.isEmpty()) {
            Location poll = que.poll();
            
            for(int i = 0; i < 4; i++) {
                int tx = poll.x + dxdy[i][0];
                int ty = poll.y + dxdy[i][1];
                
                // 1. 토마토 창고를 벗어나는 경우
                if(tx < 0 || tx >= N || ty < 0 || ty >= M) continue;
                // 2. 이미 방문한 경우
                if(visited[tx][ty]) continue;
                // 3. 토마토가 없거나 이미 토마토가 익은 경우
                if(field[tx][ty] == -1 || field[tx][ty] == 1) continue;
                
                que.add(new Location(tx, ty));
                field[tx][ty] = 1;
                visited[tx][ty] = true;
                dist[tx][ty] = dist[poll.x][poll.y] + 1;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        ArrayList<Location> bfsList = new ArrayList<>();
        
        boolean unripeTomato = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(field[i][j] == 1) bfsList.add(new Location(i, j));
                if(!unripeTomato && field[i][j] == 0) unripeTomato = true;
            }
        }
        
        bfs(bfsList);


        boolean allRipenTomato = true;
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(field[i][j] == 0) {
                    allRipenTomato = false;
                    break;
                }
                
                days = Math.max(dist[i][j], days);
            }
        }
        
        // 1) 모두 토마토가 익어있는 경우
        if(!unripeTomato) System.out.println(0);
        // 2) 토마토가 모두 익지 못하는 경우
        else if(!allRipenTomato) System.out.println(-1);
        // 3) 토마토가 모두 익은 최소 일수
        else System.out.println(days);
    }
}