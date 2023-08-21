import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int[] aList, bList;

  static int binary_search(int L, int R, int X) {
    int count = 0;

    while(L <= R) {
      int mid = (L + R) / 2;
      if(bList[mid] < X) {
        count = mid + 1;
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }

    return count;
  }

  static int solution() {
    int answer = 0;

    Arrays.sort(aList); // 1 1 3 7 8
    Arrays.sort(bList); // 1 3 6

    for(int i = 0; i < aList.length; i++) {
      int L = 0; int R = bList.length - 1;
      answer += binary_search(L, R, aList[i]);
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;

    while(T --> 0) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      aList = new int[N]; bList = new int[M];

      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) aList[i] = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < M; i++) bList[i] = Integer.parseInt(st.nextToken());

      System.out.println(solution());
    }
  }
}
