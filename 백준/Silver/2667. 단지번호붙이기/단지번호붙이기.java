import java.io.*;
import java.util.*;

public class Main {
    static int N, apartmentCnt = 0;
    static ArrayList<Integer> apartmentInfo = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[][] dxdy = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    
    static StringBuilder sb = new StringBuilder();
    
    static class Location {
        int x, y;
        
        public Location(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    
    static void dfs(Location loc) {
        visited[loc.x][loc.y] = true;
        apartmentCnt++;
        
        for(int i = 0; i < 4; i++) {
            int tx = loc.x + dxdy[i][0], ty = loc.y + dxdy[i][1];
            
            if(tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
            if(visited[tx][ty]) continue;
            if(map[tx][ty] == 0) continue;
            
            dfs(new Location(tx, ty));
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        
        visited = new boolean[N][N];
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    apartmentCnt = 0; // 각 단지내 집의 수
                    dfs(new Location(i, j));
                    apartmentInfo.add(apartmentCnt);
                    count++; // 총 단지수
                }
            }
        }
        
        Collections.sort(apartmentInfo);
        sb.append(count).append("\n");
        apartmentInfo.forEach(info -> sb.append(info).append("\n"));
        
        System.out.println(sb.toString());
    }
}