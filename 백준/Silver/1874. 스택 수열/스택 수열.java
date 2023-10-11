import java.io.*;
import java.util.*;

public class Main {
    
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
    static boolean makeSequence(int n, int[] answer) {
        int k = 0;
        for(int i = 1; i <= n; i++) {
            while(!stack.isEmpty() && stack.peek() == answer[k]) {
                stack.pop(); sb.append("-\n"); 
                k++;
            }
            
            stack.push(i); sb.append("+\n");
        }    
        
        while(!stack.isEmpty() && stack.peek() == answer[k]) {
            stack.pop(); sb.append("-\n"); 
            k++;
        }
        
        return stack.isEmpty() ? true : false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) answer[i] = Integer.parseInt(br.readLine());
        
        if(makeSequence(n, answer)) System.out.println(sb.toString());
        else System.out.println("NO");
    }
}