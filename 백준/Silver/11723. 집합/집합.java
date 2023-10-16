import java.io.*;
import java.util.*;

public class Main {
  static Set<Integer> set = new HashSet();
  static StringBuilder sb = new StringBuilder();
    
  static void add(int x) {
    set.add(x);
  }

  static void remove(int x) {
    set.remove(x);
  }

  static boolean check(int x) {
    return set.contains(x);
  }

  static void toggle(int x) {
    if(check(x)) remove(x);
    else add(x);
  }

  static void all() {
    empty();
    for(int i = 1; i <= 20; i++) add(i);
  }

  static void empty() {
    set.clear();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while(T --> 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String op = st.nextToken();
      if(op.equals("add")) {
        add(Integer.parseInt(st.nextToken()));
      } else if(op.equals("check")) {
        if(check(Integer.parseInt(st.nextToken()))) sb.append("1\n");
        else sb.append("0\n");
      } else if(op.equals("remove")) {
        remove(Integer.parseInt(st.nextToken()));
      } else if(op.equals("toggle")) {
        toggle(Integer.parseInt(st.nextToken()));
      } else if(op.equals("all")) {
        all();
      } else if(op.equals("empty")) {
        empty();
      }
    }
      
      System.out.println(sb.toString());
  }
}