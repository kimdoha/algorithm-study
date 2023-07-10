import java.util.HashMap;

class Solution {
  public String solution(String[] participants, String[] completions) {
    HashMap<String, Integer> completed = new HashMap<>();

    for(String completion : completions) {
     completed.put(completion, completed.getOrDefault(completion, 0) + 1);
    }

    for(String paricipant : participants) {
      if(!completed.containsKey(paricipant) || completed.get(paricipant) == 0) return paricipant;
      else completed.put(paricipant, completed.get(paricipant) - 1);
    }
    
    return "";
  }
}