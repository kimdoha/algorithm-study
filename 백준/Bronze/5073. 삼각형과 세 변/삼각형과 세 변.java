import java.io.*;
import java.util.*;

public class Main {
    
    static boolean isEquilateral(int s1, int s2, int s3) {
        return s1 == s2 && s2 == s3;
    }
    
    static boolean isIsosceles(int s1, int s2, int s3) {
        return 
            (s1 == s2 && s3 != s2) || 
            (s2 == s3 && s1 != s3) || 
            (s1 == s3 && s2 != s3); 
    }
    
    static boolean isScalene(int s1, int s2, int s3) {
        return s1 != s2 && s2 != s3 && s3 != s1;
    }
    
    static boolean isInvalid(int s1, int s2, int s3) {
        int max = Math.max(Math.max(s1, s2), s3);
        
        if(s1 == max && s1 >= s2 + s3) return true;
        else if(s2 == max && s2 >= s1 + s3) return true;
        else if(s3 == max && s3 >= s1 + s2) return true;
        
        return false;
    }
    
    static void validateTriangle(int s1, int s2, int s3) {
        if(isInvalid(s1, s2, s3)) System.out.println("Invalid");
        else if(isEquilateral(s1, s2, s3)) System.out.println("Equilateral");
        else if(isIsosceles(s1, s2, s3)) System.out.println("Isosceles");
        else if(isScalene(s1, s2, s3)) System.out.println("Scalene");
        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            
            if(s1 == 0 && s2 == 0 && s3 == 0) break;
            validateTriangle(s1, s2, s3);
        }
    }
}