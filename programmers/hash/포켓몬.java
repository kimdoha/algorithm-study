import java.util.HashSet;

class Solution {
    
  public int solution(int[] nums) {

    HashSet<Integer> poketmons = new HashSet<>();
    for(int num : nums) poketmons.add(num);
    
    return Math.min(poketmons.size(), nums.length / 2);
  }
}