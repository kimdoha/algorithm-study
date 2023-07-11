import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
  public int solution(String[][] clothes) {
    int answer = 1;

    HashMap<String, Integer> closet = new HashMap<>();
    for(String[] cloth : clothes) {
      closet.put(cloth[1], closet.getOrDefault(cloth[1], 0) + 1);
    }
   
    for(Entry<String, Integer> entry : closet.entrySet()) {
      answer *= entry.getValue() + 1;
    }
    
    return answer - 1;
  }
}