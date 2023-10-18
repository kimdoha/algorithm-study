import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int x, boolean[] visited) {
        visited[x] = true;
        sb.append(x).append(" ");
        
        for(int y : graph[x]) {
            if(visited[y]) continue;
            dfs(y, visited);
        }
    }
    
    static void bfs(int x, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visited[x] = true;
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            sb.append(cur).append(" ");
            
            for(int y : graph[cur]) {
                if(visited[y]) continue;
                que.add(y);
                visited[y] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();    
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
           for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        dfs(V, new boolean[N + 1]); sb.append("\n");
        bfs(V, new boolean[N + 1]); sb.append("\n");
        
        System.out.println(sb.toString());
    }
}