import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab, copyLab;
    static boolean[][] wall, visited;
    static int MAX_SAFE_AREA = 0;
    static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static void createWall(int k) {
        if(k == 3) {
            for(int i = 0; i < N; i++) {
                copyLab[i] = Arrays.copyOf(lab[i], lab[i].length);
            }
            
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(copyLab[i][j] == 2 && !visited[i][j]) {
                        dfs(i, j);
                    }
                }
            }
            
            MAX_SAFE_AREA = Math.max(MAX_SAFE_AREA, countSafeArea());
        } else {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(wall[i][j]) continue;
                    if(lab[i][j] == 1 || lab[i][j] == 2) continue;
                    
                    lab[i][j] = 1; wall[i][j] = true;
                    createWall(k + 1);
                    lab[i][j] = 0; wall[i][j] = false;
                }
            }
        }
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        copyLab[x][y] = 2;
        
        for(int i = 0; i < 4; i++) {
            int tx = x + dxdy[i][0];
            int ty = y + dxdy[i][1];
            
            if(tx < 0 || tx >= N || ty < 0 || ty >= M) continue; // 1. map 범위를 벗어난 경우
            if(visited[tx][ty]) continue; // 2. 이미 방문한 경우
            if(copyLab[tx][ty] == 1 || copyLab[tx][ty] == 2) continue;
            
            dfs(tx, ty);
        }
    }
    
    static int countSafeArea() {
        int count = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyLab[i][j] == 0) count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lab = new int[N][M]; 
        copyLab = new int[N][M];
        wall = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            lab[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        createWall(0);
        System.out.println(MAX_SAFE_AREA);
    }
}