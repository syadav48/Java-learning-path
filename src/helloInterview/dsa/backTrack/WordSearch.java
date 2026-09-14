package helloInterview.dsa.backTrack;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(board[row][col] == word.charAt(0)){
                    if(dfs(board, word, row, col, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int index){
        if(index == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)){
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = (
                    dfs(board, word, r + 1, c, index + 1) ||
                    dfs(board, word, r - 1, c, index + 1) ||
                    dfs(board, word, r, c + 1, index + 1) ||
                    dfs(board, word, r, c - 1, index + 1)
                );
        board[r][c] = temp;
        return found;
    }
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'B', 'L', 'C', 'H'}, {'D', 'E', 'L', 'T'}, {'D', 'A', 'K', 'A'}};
        String word = "BLEAK";
        System.out.println(wordSearch.exist(board, word));
    }
}
