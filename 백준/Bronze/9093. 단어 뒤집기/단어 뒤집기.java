import java.io.*;
import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static void backward(String[] words) {
        Stack<Character> stack = new Stack<>();
        for(String word : words) {
            char[] chars = word.toCharArray();
            for(char ch : chars) stack.push(ch);
            while(!stack.isEmpty()) sb.append(stack.pop());
            sb.append(" ");
        }
        
        sb.append("\n"); 
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            String[] words = br.readLine().split(" ");
            backward(words);
        }
        
        System.out.println(sb.toString());
    }   
}