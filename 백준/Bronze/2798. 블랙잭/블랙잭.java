import java.io.*;
import java.util.*;

public class Main {
    static int N, M = 3;
    static int target, maxSum;
    static int[] selected, numbers;
    static boolean[] visited;
    
    static void dfs(int k, int sum) {
        if(k == M + 1) {
            if(sum <= target && maxSum < sum) {
                maxSum = sum;
            }
        } else {
            for(int cand = 1; cand <= N; cand++) {
                if(!visited[cand]){
                    selected[k] = numbers[cand];
                    visited[cand] = true;
                    dfs(k + 1, sum + numbers[cand]);
                    selected[k] = 0;
                    visited[cand] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        selected = new int[M + 1];
        visited = new boolean[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, 0);
        System.out.println(maxSum);
    }
}