import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String mode;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        mode = st.nextToken();

        while(N --> 0) {
            String person = br.readLine();
            map.putIfAbsent(person, 1);
        }


        int YCnt = 1, FCnt = 2, OCnt = 3;
        StringBuilder sb = new StringBuilder();
        switch (mode) {

            case "Y":
                sb.append(map.size() / YCnt);
                break;
            case "F":
                sb.append(map.size() / FCnt);
                break;
            case "O":
                sb.append(map.size() / OCnt);
                break;
            default:
                break;
        }

        System.out.println(sb);
    }
}