import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int solution(String document, String find) {
    int index = 0, count = 0;

    while(index < document.length()) {
      if(document.startsWith(find, index)) {
        count += 1;
        index += find.length();
      } else {
        index += 1;
      }
    }

    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String document = br.readLine();
    String find = br.readLine();

    System.out.println(solution(document, find));
  }
}
