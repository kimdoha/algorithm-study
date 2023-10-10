import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
                    
                case "top":
                    int topResult = stack.isEmpty() ? -1 : stack.peek();
                    sb.append(topResult).append("\n");
                    break;
                    
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                    
                case "empty":
                    int emptyResult = stack.isEmpty() ? 1 : 0;
                    sb.append(emptyResult).append("\n");
                    break;
                    
                case "pop":
                    int popResult = stack.isEmpty() ? -1 : stack.pop();
                    sb.append(popResult).append("\n");
                    break;
                    
                default:
                    break;
            }
        }
        
        System.out.println(sb.toString());
    }
}