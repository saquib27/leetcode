class Solution {

    private boolean isWordExist(char[][] board, char[] letters, int row, int col, int index, int rows, int cols) {

        if (index == letters.length) {
            return true;
        }
        else if (row < 0 || row == rows || col < 0 || col == cols || board[row][col] != letters[index]) {
            return false;
        }

        char c = board[row][col];
        board[row][col] = '#';

        boolean up = isWordExist(board, letters, row - 1, col, index + 1, rows, cols);
        boolean down = isWordExist(board, letters, row + 1, col, index + 1, rows, cols);
        boolean left = isWordExist(board, letters, row, col - 1, index + 1, rows, cols);
        boolean right = isWordExist(board, letters, row, col + 1, index + 1, rows, cols);

        if (up || down || left || right) {
            return true;
        }

        board[row][col] = c;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = rows == 0 ? 0 : board[0].length;

        char[] letters = word.toCharArray();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == letters[0] && isWordExist(board, letters, row, col, 0, rows, cols)) {
                    return true;
                }
            }
        }

        return false;
    }
}