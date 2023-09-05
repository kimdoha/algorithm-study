import java.io.*;
import java.util.*;

public class Main {
    static int N, count, block = 0;
    static List<Integer> apartmentInfo = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static void dfs(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N) return; // 지도에서 벗어난 경우
        if(map[x][y] == 0 || visited[x][y]) return; // 방문했거나 집이 없는 곳
        
        map[x][y] = 0;
        visited[x][y] = true;
        count++;
        
        for(int i = 0; i < 4; i++) {
            dfs(x + dxdy[i][0], y + dxdy[i][1]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(map[x][y] == 1) {
                    count = 0; // 단지 내 아파트 수
                    dfs(x, y);
                    apartmentInfo.add(count);
                    block++;
                }
            }
        }
        
        System.out.println(block);
        Collections.sort(apartmentInfo);
        apartmentInfo.stream().forEach(info -> System.out.println(info));
    }
}