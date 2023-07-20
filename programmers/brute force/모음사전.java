import java.util.ArrayList;
import java.util.List;

class Solution {
    
  static List<String> dictionary;
  static String[] alphabets = {"A", "E", "I", "O", "U"};

  public void rec_func(int k, String word) {
    if(k == alphabets.length) {
      return;
    } else {
      for ( int i = 0; i < alphabets.length; i++ ) {
        dictionary.add( word + alphabets[i] );
        rec_func( k + 1, word + alphabets[i] );
      }
    }
  }

  public int solution(String word) {
    dictionary = new ArrayList<>();
    rec_func(0, "");
    return dictionary.indexOf(word) + 1;
  }
}