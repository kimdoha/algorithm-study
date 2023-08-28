import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    class Genre implements Comparable<Genre>{
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
    
    class Album implements Comparable<Album> {
        int id;
        int play;
        String genre;
        
        public Album(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Album o) {
            // 3. 장르 내에서 재생 횟수가 같은 경우, 고유 번호 오름 차순
            // 2. 장르 내에서 재생 횟수 내림 차순
            // 1. 장르 사전 오름차순
            if(genre.equals(o.genre) && play == o.play) return id - o.id;
            else if(genre.equals(o.genre)) return o.play - play;
            else return genre.compareTo(o.genre);
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
       
        // 1. 많이 재생된 장르별 조회수 내림차순
        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Genre> genreSort = new ArrayList<>();
        for(Entry<String, Integer> entry : genreMap.entrySet()) {
            genreSort.add(new Genre(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(genreSort);
        
        // 2. 많이 재생된 장르별 앨범 정렬
        List<Album> albumSort = new ArrayList<>();
        for(int i = 0; i < genres.length; i++) {
            albumSort.add(new Album(i, plays[i], genres[i]));
        }
        
        Collections.sort(albumSort);
        

            
        // 3. 앨범 수록(2개 이하)
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < genreSort.size(); i++) {
            String current = genreSort.get(i).name;
            int count = 0;
            
            for(int j = 0; j < albumSort.size(); j++) {
                Album album = albumSort.get(j);
                if(count == 2) break;
                if(album.genre.equals(current)) {
                    answer.add(album.id);
                    count += 1;
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}