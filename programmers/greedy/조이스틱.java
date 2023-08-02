class Solution {
    public int solution(String name) {
      int answer = 0, move = name.length() - 1;
  
      for(int i = 0; i < name.length(); i++) {
        int up = name.charAt(i) - 'A';
        int down = 26 - up;
        answer += Math.min(up, down);
  
  
        int index = i + 1;
        while(index < name.length() && name.charAt(index) == 'A') {
          index++;
        }
        move = Math.min(move, 2 * i + name.length() - index);
        move = Math.min(move, (name.length() - index) * 2 + i);
      }
  
  
      return answer + move;
    }
  }