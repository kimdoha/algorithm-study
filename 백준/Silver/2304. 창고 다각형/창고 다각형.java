import java.io.*;
import java.util.*;

public class Main {
    static int N, L, H;
    static List<Column> columns = new ArrayList<>();
    static int sum = 0, maxIndex = 0, maxHeight = 0;

    static class Column implements Comparable<Column> {
        int L, H;

        public Column(int _L, int _H) {
            L = _L;
            H = _H;
        }

        @Override
        public int compareTo(Column o) {
            return L - o.L;
        }
    }

    static void solution() {
        Collections.sort(columns);

        int maxCount = 0;
        for(int i = 0; i < columns.size(); i++) {
            if(maxHeight < columns.get(i).H) {
                maxHeight = columns.get(i).H;
                maxIndex = i;
            }
        }


        for(int i = 0; i < maxIndex; i++) {
            for(int j = i + 1; j <= maxIndex; j++) {
                if(columns.get(i).H <= columns.get(j).H) {
                    sum += (columns.get(j).L - columns.get(i).L) * columns.get(i).H;
                    i = j;

                }
            }
        }

        for(int i = columns.size() - 1; i > maxIndex; i--) {
            for(int j = i - 1; j >= maxIndex; j--) {
                if(columns.get(i).H <= columns.get(j).H) {
                    sum += (columns.get(i).L - columns.get(j).L) * columns.get(i).H;
                    i = j;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L =  Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            columns.add(new Column(L, H));
        }

        solution();
        System.out.println(sum + maxHeight);
    }
}