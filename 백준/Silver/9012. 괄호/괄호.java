import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
    static boolean validParenthesis(String ps) {
        for(int i = 0; i < ps.length(); i++) {
            if(ps.charAt(i) == '(') stack.push('(');
            else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
            
        }
        
        return stack.isEmpty() ? true : false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        T = Integer.parseInt(br.readLine());
        
        while(T --> 0) {
            stack.clear();
            
            String ps = br.readLine();
            if(validParenthesis(ps)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        
        System.out.println(sb.toString());
    }
}