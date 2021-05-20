class ValidSudoku {
public:
	bool isValidSudoku(vector<vector<char>>& board) {
		vector<vector<bool>> row(9, vector<bool>(9));
        vector<vector<bool>> col(9, vector<bool>(9));
        vector<vector<bool>> block(9, vector<bool>(9));
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] != '.') {
                    int cur = board[i][j] - '1';
                    if (row[i][cur] || col[j][cur] || block[(i / 3) * 3 + (j / 3)][cur]) {
                        return false;
                    }
                    row[i][cur] = true;
                    col[j][cur] = true;
                    block[(i / 3) * 3 + (j / 3)][cur] = true;
                }
            }
        }
        return true;
	}
};
