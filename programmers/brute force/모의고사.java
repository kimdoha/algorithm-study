import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public int[] solution(int[] answers) {

    int[] person1 = new int[]{1, 2, 3, 4, 5};
    int[] person2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] person3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int[] counts = new int[4];

    for(int i = 0; i < answers.length; i++) {
      if(person1[i % person1.length] == answers[i]) counts[1]++;
      if(person2[i % person2.length] == answers[i]) counts[2]++;
      if(person3[i % person3.length] == answers[i]) counts[3]++;
    }

    ArrayList<Integer> result = new ArrayList<>();
    int max = Arrays.stream(counts).max().getAsInt();

    for(int person = 1; person <= 3; person++) {
      if(max == counts[person]) result.add(person);
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}