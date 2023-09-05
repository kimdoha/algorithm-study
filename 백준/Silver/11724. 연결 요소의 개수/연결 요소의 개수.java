import java.io.*;
import java.util.*;

public class Main {
    static int N, M, connection = 0;
    static int u, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    static void dfs(int v) {
        visited[v] = true;
        
        for(int y : graph[v]) {
            if(visited[y]) continue;
            dfs(y);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        
        graph = new ArrayList[N + 1];
        for(int v = 1; v <= N; v++) {
            graph[v] = new ArrayList<Integer>();
        }
        
        visited = new boolean[N + 1];
        
        while(M --> 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()); // 간선 끝점 1
            v = Integer.parseInt(st.nextToken()); // 간선 끝점 2
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int v = 1; v <= N; v++){
            if(!visited[v]) {
                dfs(v);
                connection++;
            }
        }
        
        System.out.println(connection);
    }
}