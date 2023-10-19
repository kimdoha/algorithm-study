import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        while(N --> 0) {
          int x = Integer.parseInt(br.readLine());
          
         if(x > 0) {
            pq.add(x); 
         } else if(x == 0) {
              if(pq.isEmpty()) sb.append("0\n");
              else sb.append(pq.poll()).append("\n");
          }
        }
        
        System.out.println(sb.toString());
    }
}