import java.io.*;
import java.util.*;

public class Main {
 static int N, maxBudget, funds;
  static int[] budgets;

  static boolean determination(int target) {
    int sum = 0;

    for(int i = 0; i < N; i++) {
      if(budgets[i] > target) sum += target;
      else sum += budgets[i];
    }

    return sum <= funds;
  }

  static void search() {
    Arrays.sort(budgets);

    int L = 1, R = budgets[N - 1];
    while(L < R) {
      int M = (L + R) / 2;

      if(determination(M)) {
        maxBudget = M;
        L = M + 1;
      } else {
        R = M - 1;
      }
    }
     
    if(determination(L)) maxBudget = L;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    budgets = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      budgets[i] = Integer.parseInt(st.nextToken());
    }

    funds = Integer.parseInt(br.readLine());
    search();

    System.out.println(maxBudget);
  }
}