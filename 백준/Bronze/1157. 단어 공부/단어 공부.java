import java.io.*;
import java.util.*;

public class Main {
    
    static HashMap<Character, Integer> map = new HashMap<>();
    static int maxCnt = 0;
    
    static void mapInit(String word) {
        for(int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
    }
    
    static char getMaxAlphabet() {
        char result = '?';
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                result = entry.getKey().charValue();
            } else if(entry.getValue() == maxCnt) {
                result = '?';
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String upperWord = br.readLine().toUpperCase();
        mapInit(upperWord);
        System.out.println(getMaxAlphabet());
    }
}