import java.util.Arrays;

class Solution {
   public int solution(int n, int[] lost, int[] reserve) {
    int[] clothes = new int[n];
    for(int lostPerson : lost) {
      clothes[lostPerson - 1]--;
    }

    for(int reservePerson : reserve) {
      clothes[reservePerson - 1]++;
    }

    int readyCount = n;
    for(int i = 0; i < clothes.length; i++) {

      if(clothes[i] == -1) {
        if(i > 0 && clothes[i - 1] == 1) {
          clothes[i - 1]--;
          clothes[i]++;
        } else if(i < clothes.length - 1 && clothes[i + 1] == 1) {
          clothes[i + 1]--;
          clothes[i]++;
        } else {
          readyCount--;
        }
      }
    }

    return readyCount;
  }
}