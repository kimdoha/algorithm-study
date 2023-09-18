import java.io.*;
import java.util.*;

public class Main {
    static int N, teamNum;
    static int minDiff = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] visited;

    
    static void rec_func(int start, int depth) {
        if(depth == teamNum + 1) {
            int startPower = 0, linkPower = 0;
            
            for(int i = 1; i < N; i++) {
                for(int j = i + 1; j <= N; j++) {
                    if(visited[i] && visited[j]) {
                        startPower += S[i][j] + S[j][i];
                    } else if(!visited[i] && !visited[j]) {
                        linkPower += S[i][j] + S[j][i];
                    }
                }
            }
            
            minDiff = Math.min(minDiff, Math.abs(startPower - linkPower));
        } else {
            for(int cand = start; cand <= N; cand++) {
                if(visited[cand]) continue;
                
                visited[cand] = true;
                rec_func(cand + 1, depth + 1);
                visited[cand] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N + 1][N + 1];
        visited = new boolean[N + 1];        
        teamNum = N / 2;

        
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        rec_func(1, 1);
        System.out.println(minDiff);
    }
}