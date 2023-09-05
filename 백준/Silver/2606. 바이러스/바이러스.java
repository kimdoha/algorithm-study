import java.io.*;
import java.util.*;

public class Main {
    static int vertex, edge, computerNum = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    
    static void dfs(int v) {
        visited[v] = true;
        computerNum++;
        
        for(int y : graph[v]) {
            if(visited[y]) continue;
            dfs(y);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[vertex + 1];
        for(int v = 1; v <= vertex; v++) {
            graph[v] = new ArrayList<Integer>();
        }
        
        visited = new boolean[vertex + 1];
        
        while(edge --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        dfs(1);
        System.out.println(computerNum - 1); // 1을 통해 감염된 컴퓨터 수(-1)
    }
}