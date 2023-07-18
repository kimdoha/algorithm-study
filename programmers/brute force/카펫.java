class Solution {

    static int yellow_row, yellow_col;
    static int brown_row, brown_col;
  
    public int[] solution(int brown, int yellow) {
        
        for(int n = 1; n <= yellow; n++) {
            int col = yellow / n;
            int row = yellow / col;

            if(yellow % n == 0 && col >= row) {
            yellow_col = col;
            yellow_row = row;
            }

            brown_row = yellow_row + 2;
            brown_col = yellow_col + 2;

            if(brown + yellow == brown_row * brown_col) break;
        }

        return new int[]{brown_col, brown_row};
  }
}