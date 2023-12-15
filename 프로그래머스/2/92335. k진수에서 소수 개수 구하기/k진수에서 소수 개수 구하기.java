import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String change = Integer.toString(n, k);
        
        for(String item : change.split("0")) {
            if(item.equals("")) continue;
            if(check(item) == false) answer++;
        }
        
        return answer;
    }
    
    public static boolean check(String num) {
        long n = Long.parseLong(num);
        
        if(n == 1) return true;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return true;
        }
        
        return false;
    }
}