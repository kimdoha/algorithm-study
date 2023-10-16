import java.io.*;
import java.util.*;

public class Main {

  static HashMap<Character, Integer> map = new HashMap<>();
  static int maxCnt = 0;

  static void init(String word) {
    for(int i = 0; i < word.length(); i++) {
      map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
      maxCnt = Math.max(maxCnt, map.get(word.charAt(i)));
    }
  }

  static Character search() {
    Character result = null;
    boolean repeat = false;

    for(Map.Entry<Character, Integer> elem : map.entrySet()) {
      if(elem.getValue() == maxCnt) {
        if(repeat) result = '?';
        else {
          result = elem.getKey();
          repeat = true;
        }
      }
    }
    
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    String transWord = word.toUpperCase();

    init(transWord);
    System.out.println(search());
  }
}