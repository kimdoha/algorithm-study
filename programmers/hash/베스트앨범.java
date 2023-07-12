import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
 public class Genre implements Comparable<Genre> {
    String name;
    int total_play;
    public Genre(String name, int total_play) {
      this.name = name;
      this.total_play = total_play;
    }
    @Override
    public int compareTo(Genre o) {
      return o.total_play - total_play;
    }
  }

  public class Song implements Comparable<Song>{
    int id, play;
    public Song(int id, int play) {
      this.id = id;
      this.play = play;
    }
    @Override
    public int compareTo(Song o) {
      return o.play - play;
    }
  }

  public int[] solution(String[] genres, int[] plays) {
    List<Integer> answer = new ArrayList<>();

    HashMap<String, List<Song>> map = new HashMap<>();

    for(int i = 0; i < genres.length; i++) {
      if(map.get(genres[i]) == null) {
        map.put(genres[i], new ArrayList<>());
      }
      map.get(genres[i]).add(new Song(i, plays[i]));
    }

    List<Genre> list = new ArrayList<>();

    for(String genre : map.keySet()) {
      int total_sum = 0;
      for(Song song : map.get(genre)) {
        total_sum += song.play;
      }
      list.add(new Genre(genre, total_sum));
    }

    Collections.sort(list);


    for(Genre genre: list) {
      Collections.sort(map.get(genre.name));

      for(int i = 0; i < map.get(genre.name).size() ; i++) {
        if(i == 2) break;
        answer.add(map.get(genre.name).get(i).id);
      }
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}