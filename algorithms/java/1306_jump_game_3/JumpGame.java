class JumpGame {
	public boolean canReach(int[] arr, int start) {
		if (arr == null || arr.length == 0) return false;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[arr.length];
		queue.offer(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			Integer curIndex = queue.poll();
			if (curIndex + arr[curIndex] < arr.length) {
				if (arr[curIndex + arr[curIndex]] == 0) return true;
				if (!visited[curIndex + arr[curIndex]]) {
					queue.offer(curIndex + arr[curIndex]);
					visited[curIndex + arr[curIndex]] = true;
				}
			}
			if (curIndex - arr[curIndex] >= 0) {
				if (arr[curIndex - arr[curIndex]] == 0) return true;
				if (!visited[curIndex - arr[curIndex]]) {
					queue.offer(curIndex - arr[curIndex]);
					visited[curIndex - arr[curIndex]] = true;
				}
			}
		}
		return false;
	}
}
