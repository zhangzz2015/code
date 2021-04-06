class SlidingPuzzle {
	private final static int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int slidingPuzzle(int[][] board) {
		Queue<Node> queue = new ArrayDeque<>();
		String target = "123450";
		int row = board.length, col = board[0].length, r = 0, c = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 0) {
					r = i;
					c = j;
				}
			}
		}
		String s = toString(board);
		if (s.equals(target)) {
			return 0;
		}
		queue.offer(new Node(r, c, s));
		Set<String> visited = new HashSet<>();
		visited.add(s);
		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();
				r = cur.row;
				c = cur.col;
				for (int[] dir : DIRS) {
					int nr = r + dir[0];
					int nc = c + dir[1];
					if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
						s = swap(cur.boardString.toCharArray(), nr, nc, r, c);
						if (s.equals(target)) return steps + 1;
						if (visited.add(s)) {
							queue.offer(new Node(nr, nc, s));
						}
					}
				}
			}
			steps++;
		}
		return -1;
	}

	private String toString(int[][] m) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				sb.append(m[i][j];
			}
		}
		return sb.toString();
	}

	private String swap(char[] arr, int r1, int c1, int r2, int c2) {
		char tmp = arr[r1 * 3 + c1];
		arr[r1 * 3 + c1] = arr[r2 * 3 + c2];
		arr[r2 * 3 + c2] = tmp;
		return new String(arr);
	}

	static class Node {
		int row;
		int col;
		String boardString;
		Node (int row, int col, String boardString) {
			this.row = row;
			this.col = col;
			this.boardString = boardString;
		}
	}
}
