import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        double r = 0, c = 0;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++) {
            if(dirs.charAt(i) == 'U' && c + 1 <= 5) {
                set.add(r + " " + (c + 0.5));
                c++;
            }
            else if(dirs.charAt(i) == 'D' && c - 1 >= -5) {
                set.add(r + " " + (c - 0.5));
                c--;
            }
            else if(dirs.charAt(i) == 'R' && r + 1 <= 5) {
                set.add((r + 0.5) + " " + c);
                r++;
            }
            else if(dirs.charAt(i) == 'L' && r - 1 >= -5) {
                set.add((r - 0.5) + " " + c);
                r--;
            }
            
            answer = set.size();
        }
        
        return answer;
    }
}