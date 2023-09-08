import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parents, city;
    static StringBuilder sb = new StringBuilder();
    
    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot != bRoot) parents[aRoot] = bRoot;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시 수
        M = Integer.parseInt(br.readLine()); // 계획에 속한 도시 수
        
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) parents[i] = i;
        
        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 1; j <= N; j++) {
                if(st.nextToken().equals("1")) union(i, j); // 합집합
            }
        }
        
        st = new StringTokenizer(br.readLine());
        city = new int[M + 1];
        for(int i = 1; i <= M; i++) city[i] = Integer.parseInt(st.nextToken());
        
        boolean available = true;
        for(int i = 1; i <= M - 1; i++) {
            if(find(city[i]) != find(city[i + 1])) available = false;
        }
        
        if(available) System.out.println("YES");
        else System.out.println("NO");
    }
}