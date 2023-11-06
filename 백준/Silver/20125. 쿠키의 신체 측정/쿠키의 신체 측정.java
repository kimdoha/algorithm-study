import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int map[][];
    static StringBuilder sb = new StringBuilder();

    static class Location {
        int x, y;

        public Location(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    static Location heart = null;

    // 심장부 위치 찾기
    static void findHeartLocation() {
        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < N - 1; j++) {

                if(map[i - 1][j] == 1 &&
                   map[i + 1][j] == 1 &&
                   map[i][j - 1] == 1 &&
                   map[i][j + 1] == 1) {
                    heart = new Location(i, j);
                }
            }
        }

        sb.append(heart.x + 1).append(" ").append(heart.y + 1).append("\n");
    }

    // 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리 길이 찾기
    static void findArmLength() {
        int leftArmLen = 0; int rightArmLen = 0;

        for(int i = 1; i < N; i++) {
            int ly = heart.y - i;
            if(ly < 0 || ly >= N) continue;

            if(map[heart.x][ly] == 1) leftArmLen++;
        }
        
        for(int i = 1; i < N; i++) {
            int ry = heart.y + i;
            if(ry < 0 || ry >= N) continue;
            
            if(map[heart.x][ry] == 1) rightArmLen++;
        }
        
        sb.append(leftArmLen).append(" ").append(rightArmLen).append(" ");
    }


    static void findWaistAndLegLength() {
        int waistLen = 0; int leftLegLen = 0; int rightLegLen = 0;

        for(int i = 1; i < N; i++) {
            int wx = heart.x + i;
            if(wx < 0 || wx >= N) continue;

            if(map[wx][heart.y] == 1) waistLen++;
        }

        for(int i = 1; i < N; i++) {
            int lx = heart.x + waistLen + i; int ly = heart.y - 1;

            if(lx < 0 || lx >= N || ly < 0 || ly >= N) continue;
            if(map[lx][ly] == 1) leftLegLen++;
        }

        for(int i = 1; i < N; i++) {
            int rx = heart.x + waistLen + i; int ry = heart.y + 1;

            if(rx < 0 || rx >= N || ry < 0 || ry >= N) continue;
            if(map[rx][ry] == 1) rightLegLen++;
        }

        sb.append(waistLen).append(" ").append(leftLegLen).append(" ").append(rightLegLen).append(" ");
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String info = br.readLine();

            for(int j = 0; j < N; j++) {
                if(info.charAt(j) == '*') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }

        findHeartLocation();
        findArmLength();
        findWaistAndLegLength();

        System.out.println(sb);
    }
}
