import java.util.Stack;

class Solution {

  boolean solution(String s) {

    Stack<Character> stack = new Stack<>();

    for(char ch : s.toCharArray()) {
      if(ch == '(') {
        stack.add(ch);
      }
      else {
        if(stack.isEmpty()) return false;
        else if(stack.peek() == '(') stack.pop();
      }
    }

    return stack.isEmpty() ? true : false;
  }
}