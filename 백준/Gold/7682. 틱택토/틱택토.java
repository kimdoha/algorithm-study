import java.io.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int XCnt = 0, OCnt = 0, blackCnt = 0;
  static int XBingoCnt = 0, OBingoCnt = 0;

  static void checkRowBingo(char[][] board) {
    for(int i = 0; i < 3; i++) {
      if(board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        if(board[i][0] == 'X') XBingoCnt++;
        else if(board[i][0] == 'O') OBingoCnt++;
      }
    }
  }

  static void checkColumnBingo(char[][] board) {
    for(int i = 0; i < 3; i++) {
      if(board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        if(board[0][i] == 'X') XBingoCnt++;
        else if(board[0][i] == 'O') OBingoCnt++;
      }
    }
  }

  static void checkDiagonalBingo(char[][] board) {
    if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      if(board[0][0] == 'X') XBingoCnt++;
      else if(board[0][0] == 'O') OBingoCnt++;
    } else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
      if(board[0][2] == 'X') XBingoCnt++;
      else if(board[0][2] == 'O') OBingoCnt++;
    }
  }

  static void calculateBingoCnt(char [][] board) {
    checkColumnBingo(board);
    checkRowBingo(board);
    checkDiagonalBingo(board);
    // System.out.printf("X-Bingo : %d, O-Bingo%d\n",XBingoCnt, OBingoCnt);
  }

  static boolean validTestCase(char[][] board) {
    if(blackCnt == 0) { // 게임판이 가득 채워진 경우
      calculateBingoCnt(board);

      if(XBingoCnt > 0 && OBingoCnt == 0 || XBingoCnt == 0 && OBingoCnt == 0) {
        if(XCnt - OCnt == 1) return true;
        else return false;
      }
      else if(OBingoCnt > 0 && XBingoCnt == 0){
        if(XCnt == OCnt) return true;
        else return false;
      }

    } else { // 게임판에 빈칸이 있는 경우
      calculateBingoCnt(board);
      if(XBingoCnt > 0 && OBingoCnt == 0) {
        if(XCnt - OCnt == 1) return true;
      }
      else if(OBingoCnt > 0 && XBingoCnt == 0){
        if(XCnt == OCnt) return true;
      }
      else return false;
    }

    return false;
  }

  static void printResult(boolean result) {
    if(result) sb.append("valid\n");
    else sb.append("invalid\n");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true) {
      String info = br.readLine();
      if(info.equals("end")) break;
      XBingoCnt = 0; OBingoCnt = 0; XCnt = 0; OCnt = 0; blackCnt = 0;
      // 배열 초기화
      char[][] board = new char[3][3];
      for(int i = 0, k = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          char current = info.charAt(k++);

          if(current == 'X') XCnt++;
          else if(current == 'O') OCnt++;
          else blackCnt++;

          board[i][j] = current;
        }
      }

      printResult(validTestCase(board));
    }

    System.out.println(sb.toString());
  }
}
