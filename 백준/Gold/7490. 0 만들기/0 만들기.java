import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static StringBuilder sb = new StringBuilder();

  static int extractOperator(String expression) {
    int op_index = expression.length() - 1;

    while(op_index >= 0) {
      char current = expression.charAt(op_index);
      if(current == '+' || current == '-') {
        break;
      }
      op_index--;
    }
    return op_index;
  }

  static void makeZero(int n, int k, int num, int sign, int sum, String expression) {

    if(k == n) {
      sum = sum + sign * num;
      if(sum == 0) {
        sb.append(expression).append("\n");
      }
    } else {
      makeZero(n, k + 1, num * 10 + (k + 1), sign, sum, expression + " " + (k + 1));
      makeZero(n, k + 1 , k + 1, 1, sum + (sign * num),expression + "+" + (k + 1));
      makeZero(n, k + 1 , k + 1, -1, sum + (sign * num) ,expression + "-" + (k + 1));
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while(T --> 0) {
      int N = Integer.parseInt(br.readLine());
      makeZero(N, 1,1, 1, 0,  "1");
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}
