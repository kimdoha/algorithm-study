import java.io.*;
import java.util.*;

public class Main {
    static int N, M, MAX_SUM = 0;
    static int[][] paper;
    static boolean[][] visited;
    static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static void dfs(int x, int y, int sum, int count) {
        if(count == 4) {
            MAX_SUM = Math.max(MAX_SUM, sum);
        } else {
            for(int i = 0; i < 4; i++) {
                int tx = x + dxdy[i][0];
                int ty = y + dxdy[i][1];
                
                if(tx < 0 || tx >= N || ty < 0 || ty >= M) continue; // 1. 종이 범위를 벗어난 경우
                if(visited[tx][ty]) continue; // 2. 이미 방문한 경우
                
                if(count == 2) {
                    visited[tx][ty] = true;
                    dfs(x, y, sum + paper[tx][ty], count + 1);
                    visited[tx][ty] = false;
                }
                
                visited[tx][ty] = true;
                dfs(tx, ty, sum + paper[tx][ty], count + 1);
                visited[tx][ty] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                visited[i][j] = false;
            }
        }
        
        System.out.println(MAX_SUM);
    }
}