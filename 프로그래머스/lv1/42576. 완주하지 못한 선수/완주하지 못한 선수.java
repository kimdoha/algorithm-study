import java.util.HashMap;

class Solution {
  public String solution(String[] participants, String[] completions) {
    HashMap<String, Integer> completionList = new HashMap<>();
    // 시간 복잡도 O(N)
    for(String completion : completions) {
      completionList.put(completion, completionList.getOrDefault(completion, 0) + 1);
    }

    // 1. 완주자 명단에 없는 경우
    // 2. 동명이인이 있는 경우
    for(String participant : participants) {
      if(completionList.containsKey(participant)
          && completionList.get(participant) > 0) {
        completionList.put(participant, completionList.get(participant) - 1);
      }
      else return participant;
    }
    return "";
  }
}