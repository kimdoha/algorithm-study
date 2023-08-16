import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분문자열의개수 {
  static class Solution {
    int getNumberOfSubStrings(String s) {

      Set<String> set = new HashSet<>();
      for(int slice = 1; slice <= s.length(); slice++){
        for (int start = 0; start < s.length(); start++ ) {
          if (start + slice <= s.length())
            set.add(s.substring(start, start + slice));
        }
      }

      return set.size();
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    Solution solution = new Solution();
    System.out.println(solution.getNumberOfSubStrings(s));
  }
}