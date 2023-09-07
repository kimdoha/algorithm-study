import java.io.*;
import java.util.*;

public class Main {
    
    static int N, K;
    static int minTime = 0;
    static boolean[] visited = new boolean[100001];
    
    static class Location {
        int x, time;
        
        public Location(int _x, int _time) {
            this.x = _x;
            this.time = _time;
        }
    }

    static void bfs(Location start) {
        Queue<Location> que = new LinkedList<>();
        que.add(start);
        visited[start.x] = true;
        
        while(!que.isEmpty()) {
            Location cur = que.poll();
            
            if(cur.x == K) {
                minTime = cur.time;
                break;
            }

            int[] moveList = {cur.x - 1, cur.x + 1, cur.x * 2};
            
            for(int move : moveList) {
                if(move < 0 || move > 100000) continue; // 1. 이동 범위를 벗어난 경우
                if(visited[move]) continue; // 2. 이미 방문한 경우
 
                que.add(new Location(move, cur.time + 1));
                visited[move] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bfs(new Location(N, 0));
        System.out.println(minTime);
    }
}