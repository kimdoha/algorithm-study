import java.io.*;
import java.util.*;

public class Main {
  
  static int getMaxSeat(int W, int H, int N, int M) {
    int colMax = (int) Math.ceil(H * 1.0 / (M + 1));
    int rowMax = (int) Math.ceil(W * 1.0 / (N + 1));
    return colMax * rowMax;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

    System.out.println(getMaxSeat(W, H, N, M));
  }
}
