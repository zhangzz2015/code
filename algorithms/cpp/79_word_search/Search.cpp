class Search {
public:
	bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(), n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
private:
    int DIRS[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    bool dfs(vector<vector<char>>& board, int row, int col, string word, int index, vector<vector<bool>>& visited) {
        if (index == word.size()) {
            return true;
        }
        if (!is_valid(board, row, col) || visited[row][col] || board[row][col] != word[index]) {
            return false;
        }
        visited[row][col] = true;
        for (auto dir : DIRS) {
            int nei_x = row + dir[0];
            int nei_y = col + dir[1];
            if (dfs(board, nei_x, nei_y, word, index + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
    bool is_valid(vector<vector<char>>& board, int i, int j) {
        return i >= 0 && i < board.size() && j >= 0 && j < board[0].size();
    }
};
