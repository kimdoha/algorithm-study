import java.io.*;
import java.util.*;

public class Main {
       static int N, X;
    static int[] visiters, counts;
    static int maxVisitCnt = 0, periodCnt = 0;
    static StringBuilder sb = new StringBuilder();

    static void slidingWindow() {

        boolean flag = false;
        int sum = 0;

        for(int i = 0; i < N; i++) {
            if(i == X - 1) flag = true;
            if(i >= X) {
                sum -= visiters[i - X];
            }

            sum += visiters[i];
            if(sum > maxVisitCnt && flag) {
                maxVisitCnt = sum;
                periodCnt = 1;
            } else if(sum == maxVisitCnt) {
                periodCnt += 1;
            }
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visiters = new int[N];
        counts = new int[N - X + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            visiters[i] = Integer.parseInt(st.nextToken());
        }

        slidingWindow();
        if(maxVisitCnt == 0) sb.append("SAD");
        else sb.append(maxVisitCnt).append("\n").append(periodCnt);

        System.out.println(sb);
    }
}