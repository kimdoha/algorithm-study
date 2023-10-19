import java.io.*;
import java.util.*;

public class Main {
    static class Elem {
        public int idx, weight, height;
        
        public Elem(int _idx, int _weight, int _height) {
            idx = _idx;
            weight = _weight;
            height = _height;
        }
    }
    
    static Elem[] persons;
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    static void calculateRank() {
        
        for(int i = 0; i < N; i++) {
            int rank = 0;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(persons[i].height < persons[j].height &&
                  persons[i].weight < persons[j].weight) rank++;
            }
            
            sb.append(rank + 1).append(" ");
        }
    }
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    persons = new Elem[N];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      persons[i] = new Elem(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    calculateRank();
    System.out.println(sb.toString());
  }
}