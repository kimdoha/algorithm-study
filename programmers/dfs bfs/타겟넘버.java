class Solution {
    
    static int answer;
      
    public void dfs(int[] numbers, int target, int k, int sum) {
      if(k == numbers.length) {
        if (sum == target) answer++;
        return;
      } else {
          dfs( numbers, target, k + 1, sum + numbers[k] );
          dfs( numbers, target, k + 1, sum - numbers[k] );
      }
    }
  
    public int solution(int[] numbers, int target) {
      answer = 0;
      dfs(numbers, target, 0, 0);
      return answer;
    }
  }