class FindJudge {
	public int findJudge(int N, int[][] trust) {
		int[] indegrees = new int[N + 1];
		int[] outdegrees = new int[N + 1];
		for (int[] edge : trust) {
			indegrees[edge[1]]++;
			outdegrees[edge[0]]++;
		}
		for (int i = 1; i <= N; i++) {
			if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
				return i;
			}
		}
		return -1;
	}
}
