import java.util.Stack;

class Solution {
  
  public String solution(String number, int k) {
    Stack<Character> stack = new Stack<>();
    int remove = k;

    for(int i = 0; i < number.length(); i++) {
      char currentCharacter = number.charAt(i);
      while(!stack.isEmpty() &&
          stack.peek() < currentCharacter &&
          remove --> 0) {
        stack.pop();
      }
      stack.push(currentCharacter);

    }
    StringBuilder sb = new StringBuilder();
    stack.forEach(digit -> sb.append(digit));
    return sb.toString().substring(0, number.length() - k);
  }
}