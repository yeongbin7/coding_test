public class FriendsFourBlock {
    private char[][] board;
    private boolean[][] checked;
    private int m, n;

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        this.board = new char[m][n];

        for (int i = 0; i < m; i++) {
            this.board[i] = board[i].toCharArray();
        }

        int answer = 0;
        while (true) {
            int count = checkBlocks();

            if (count == 0) break;

            answer += count;

            dropBlocks();
        }

        return answer;
    }

    private int checkBlocks() {
        checked = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char current = board[i][j];

                if (current == ' ') continue;

                if (current == board[i][j + 1] &&
                    current == board[i + 1][j] &&
                    current == board[i + 1][j + 1]) {
                    checked[i][j] = true;
                    checked[i + 1][j] = true;
                    checked[i][j + 1] = true;
                    checked[i + 1][j + 1] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checked[i][j]) {
                    board[i][j] = ' ';
                    count++;
                }
            }
        }

        return count;
    }

    private void dropBlocks() {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i > 0; i--) {
                if (board[i][j] == ' ') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] != ' ') {
                            board[i][j] = board[k][j];
                            board[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
    }
}