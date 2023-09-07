import java.io.*;
import java.util.*;

public class Main {
    static int V, E, S, T;
    static int u, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;
    
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        
        que.add(start);
        visited[start] = true;
        dist[start] = 0;
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            
            
            for(int y : graph[cur]) {
                if(visited[y]) continue; // 1. 이미 방문한 경우
                
                que.add(y);
                visited[y] = true;
                dist[y] = dist[cur] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        
        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        E = Integer.parseInt(br.readLine());
        while(E --> 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        bfs(S);
        
        if (dist[T] == 0) System.out.println(-1); // 촌수 계산을 할 수 없는 경우
        else System.out.println(dist[T]);
    }
}