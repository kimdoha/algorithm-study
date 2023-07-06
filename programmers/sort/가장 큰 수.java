import java.util.Arrays;

class Solution {

  static class Elem implements Comparable<Elem> {
    String num;
      
    @Override
    public int compareTo(Elem o) {
      return (o.num+num).compareTo(num+o.num);
    }
  }

  public String solution(int[] numbers) {
    Elem[] elms = new Elem[numbers.length];

    int zero_count = 0;
    for(int i = 0; i < numbers.length; i++) {
      elms[i] = new Elem();
      elms[i].num = String.valueOf(numbers[i]);
      if(numbers[i] == 0) zero_count++;
    }

    if(zero_count == numbers.length) return "0";

    Arrays.sort(elms);

    StringBuilder answer = new StringBuilder();
    
    for(Elem elem : elms) {
      answer.append(elem.num);
    }
    
    return answer.toString();
  }
    
}