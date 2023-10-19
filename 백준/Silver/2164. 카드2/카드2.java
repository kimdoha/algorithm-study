import java.io.*;
import java.util.*;

public class Main {
    
    static Queue<Integer> que = new LinkedList<>();
    
    static void getLastCardNum() {
        for(int i = 1; i <= N; i++) {
            que.add(i);
        }        
        
        
        while(que.size() > 1) {
            que.poll();
            que.add(que.poll());
        }
    }
    
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        getLastCardNum();
        
        System.out.println(que.poll());
    }
}