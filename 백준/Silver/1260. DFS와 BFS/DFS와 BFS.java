import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int u, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");
        
        for(int y : graph[x]) {
            if(visited[y]) continue;
            dfs(y);
        }
    }
    
    
    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visited[x] = true;
        sb.append(x).append(" ");
        
        while(!que.isEmpty()) {
            int poll = que.poll();
            
            for(int y : graph[poll]) {
                if(visited[y]) continue;
                
                que.add(y);
                visited[y] = true;
                sb.append(y).append(" ");
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
            graph[i] = new ArrayList<Integer>();
        }
        
        while(M --> 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb.toString());
        

    }
}