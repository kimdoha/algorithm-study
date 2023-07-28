import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
  static String[][] s_tickets;
  static boolean[] visited;
  static ArrayList<String> answer;
    
  public void dfs(String start, String route, int k) {

    if(k == s_tickets.length) {
      answer.add(route);
      return;
    } else {
      for ( int i = 0; i < s_tickets.length; i++) {
        if (!visited[i] && s_tickets[i][0].equals( start )) {
          visited[i] = true;
          dfs(s_tickets[i][1], route + " " + s_tickets[i][1], k + 1 );
          visited[i] = false;
        }
      }
    }
  }

  public String[] solution(String[][] tickets) {

    s_tickets = tickets;
    visited = new boolean[tickets.length];
    answer = new ArrayList<>();


    Arrays.sort(s_tickets, (t1, t2) -> {
      if(t1[0].equals(t2[0])) return t1[1].compareTo(t2[1]);
      else return t1[0].compareTo(t2[0]);
    });
      
    dfs("ICN", "ICN", 0);

    return answer.get(0).split(" ");
  }
}