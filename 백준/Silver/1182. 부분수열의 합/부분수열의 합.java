import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] numbers;
    static int expression = 0;
 
    static void dfs(int k, int sum) {
        if(k == N) {
            if(sum == S) expression++;
        } else {
            dfs(k + 1, sum + numbers[k + 1]);
            dfs(k + 1, sum);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= N; i++) dfs(i, numbers[i]);
        System.out.println(expression);
    }
}