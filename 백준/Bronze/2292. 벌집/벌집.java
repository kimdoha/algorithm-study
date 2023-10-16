import java.io.*;
import java.util.*;

public class Main {

  static int getStartNum(int step) {
    int sum = 2, k = 2;
    while(k <= step) {
      sum += 6 * (k - 2);
      k++;
    }

    return sum;
  }

  static int getEndNum(int step) {
    int sum = 1, k = 2;
    while(k <= step) {
      sum += 6 * (k - 1);
      k++;
    }

    return sum;
  }

  static boolean validate(int step, int n) {
    int start = getStartNum(step);
    int end = getEndNum(step);
    return start <= n && n <= end;
  }

  static int calculate(int n) {
    if(n == 1) return 1;

    int step = 2;
    while(!validate(step, n)) step++;
    return step;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(calculate(n));
  }
}