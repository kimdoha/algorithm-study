import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
   static int[][] games;
  static boolean[] checked;
  static List<Integer> answers;

  public void rec_func(int k, int index, int cnt) {
    if(index == games.length) {
      answers.add(cnt);
    } else {
      for(int i = 0; i < games.length; i++) {
        if(!checked[i]) {
          checked[i] = true;
          
          if (k < games[i][0]) {
            rec_func( k, index + 1, cnt );
          } else {
            rec_func(k - games[i][1], index + 1, cnt + 1 );
          }

          checked[i] = false;
        }
      }
    }
  }

  public int solution(int k, int[][] dungeons) {

    games = dungeons;
    checked = new boolean[dungeons.length];
    answers = new ArrayList<>();

    rec_func(k, 0, 0);

    return Collections.max(answers).intValue();
  }
}
