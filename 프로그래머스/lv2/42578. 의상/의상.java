import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> closet = new HashMap<>();
        
        for(String[] cloth : clothes) {
            closet.put(cloth[1], closet.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        for(Integer value : closet.values()) answer *= value + 1;  
        
        // 옷을 입지 않는 경우 예외 처리
        return answer - 1;
    }
}