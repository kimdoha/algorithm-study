import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  static Word[] words;
  static String begin, target;
  static boolean[] visited;
  static int min_count = Integer.MAX_VALUE;

  class Word {
    String s;
    int dist;

    public Word(String _s, int _dist) {
      this.s = _s;
      this.dist = _dist;
    }
  }

  public boolean canTranslateWord(String s1, String s2) {
    int count = 0;

    for(int i = 0; i < s1.length(); i++) {
      if(s1.charAt(i) != s2.charAt(i)) count++;
    }
    return count == 1;
  }

  public void bfs() {
    Queue<Word> que = new LinkedList<>();
    que.add(new Word(this.begin, 0));

    while(!que.isEmpty()) {
      Word current = que.poll();

      if(current.s.equals(target)) {
        min_count = Math.min(min_count, current.dist);
      }

      for(int i = 0; i < words.length; i++) {
        if(!visited[i] && canTranslateWord(current.s, words[i].s)) {
          que.add(words[i]);
          visited[i] = true;
          words[i].dist = current.dist + 1;
        }
      }
    }
  }


  public int solution(String begin, String target, String[] words) {
    this.words = new Word[words.length];
    for(int i = 0; i < words.length; i++) {
      this.words[i] = new Word(words[i], 0);
    }
    this.visited = new boolean[words.length];
    this.target = target;
    this.begin = begin;

    if(Arrays.stream(words).noneMatch(word -> word.equals(target))) return 0;

    bfs();
    return min_count;
  }

}