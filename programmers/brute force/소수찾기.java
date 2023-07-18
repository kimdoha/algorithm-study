import java.util.HashSet;

class Solution {

  static String[] strings;
  static boolean[] checked;
  static HashSet<Integer> set;

  void rec_func(int k, String temp) {
    if(k == strings.length) return;

    for(int i = 0; i < strings.length; i++) {
      if(!checked[i]) {
        checked[i] = true;
        set.add(Integer.valueOf(temp + strings[i]));
        rec_func(k + 1, temp + strings[i]);
        checked[i] = false;
      }
    }
  }

  public int solution(String numbers) {
    strings = numbers.split("");
    checked = new boolean[strings.length];
    set = new HashSet<>();
    
    rec_func(0, "");

    return (int) set.stream().filter( v -> isPrimeNumber(v) == true ).count();
  }

  public boolean isPrimeNumber(Integer n) {
    if(n < 2) return false;

    for(int i = 2; i <= Math.sqrt(n); i++) {
      if(n % i == 0) return false;
    }

    return true;
  }
}