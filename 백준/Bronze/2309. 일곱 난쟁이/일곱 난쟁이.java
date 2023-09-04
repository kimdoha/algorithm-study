import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    
    static int N = 9, M = 7;
    static int[] dwarfs, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int k, int sum) {
        if(k == M + 1) {
            if(sum == 100 && sb.toString().length() == 0) {
                for(int i = 1; i <= M; i++) sb.append(selected[i]).append("\n");
            }
        } else {
            for(int cand = 1; cand <= N; cand++) {
                if(!visited[cand]) {
                    selected[k] = dwarfs[cand];
                    visited[cand] = true;
                    dfs(k + 1, sum + dwarfs[cand]);
                    selected[k] = 0;
                    visited[cand] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dwarfs = new int[N + 1];
        visited = new boolean[N + 1];
        selected = new int[M + 1];
        
        for(int i = 1; i <= N; i++) {
          dwarfs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarfs);

        dfs(1, 0);
        System.out.println(sb.toString());
    }
}