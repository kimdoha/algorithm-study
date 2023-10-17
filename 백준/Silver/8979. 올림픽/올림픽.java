import java.io.*;
import java.util.*;

public class Main {
   static class Elem implements Comparable<Elem> {
    public int idx;
    public int gold, silver, bronze;
    public int rank;

    public Elem(int _idx, int _gold, int _silver, int _bronze) {
      this.idx = _idx;
      this.gold = _gold;
      this.silver = _silver;
      this.bronze = _bronze;
      this.rank = 0;
    }

    public void setElemRank(int _rank) {
      this.rank = _rank;
    }

    @Override
    public int compareTo(Elem o) {
      if(gold != o.gold) return o.gold - gold;
      else if(silver != o.silver) return o.silver - silver;
      else if(bronze != o.bronze) return o.bronze - bronze;
      else return idx - o.idx;
    }
  }

  static Elem[] countries;
  static int N, K;


  static boolean isSame(Elem o1, Elem o2) {
    return o1.gold == o2.gold && o1.silver == o2.silver && o1.bronze == o2.bronze;
  }

  static void setAllRank() {
    countries[0].setElemRank(1);

    for(int i = 1; i < N; i++) {
      if(isSame(countries[i - 1], countries[i])) {
        countries[i].rank = countries[i - 1].rank;
      } else {
        countries[i].rank = countries[i - 1].rank + 1;
      }

    }
  }

  static int getCountryRank(int k) {
    int result = 0;

    for(int i = 0; i < N; i++) {
      if(countries[i].idx == k) {
        result = countries[i].rank;
        break;
      }
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    countries = new Elem[N];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int idx = Integer.parseInt(st.nextToken());
      int goldCnt = Integer.parseInt(st.nextToken());
      int silverCnt = Integer.parseInt(st.nextToken());
      int bronzeCnt = Integer.parseInt(st.nextToken());

      countries[i] = new Elem(idx, goldCnt, silverCnt, bronzeCnt);
    }

    Arrays.sort(countries);
    setAllRank();
    System.out.println(getCountryRank(K));
  }
}