import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M, K, X, Y;
    static int[][] field;
    static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) return; // 필드를 벗어나는 경우
        if(field[x][y] == 0) return; // 배추가 없는 땅인 경우
        
        field[x][y] = 0; // 배추가 있는 땅인 경우
        
        for(int i = 0; i < 4; i++) {
            dfs(x + dxdy[i][0], y + dxdy[i][1]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            field = new int[N][M];
        
            while(K --> 0) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                field[X][Y] = 1;
            }
        
            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(field[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
        
            sb.append(count).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}