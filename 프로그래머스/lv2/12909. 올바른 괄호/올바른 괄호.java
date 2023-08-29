import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        char[] characters = s.toCharArray();
        
        // '(' : stack push
        // ')' : stack pop
        for(int i = 0; i < characters.length; i++) {
            if(characters[i] == '(') stack.push(characters[i]);
            else if(characters[i] == ')') {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        return stack.size() == 0 ? true : false;
    }
}