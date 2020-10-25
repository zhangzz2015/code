class JumpGame {
	// dp
	public int jump1(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int[] m = new int[nums.length];
        Arrays.fill(m, Integer.MAX_VALUE);
        m[0] = 0;
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < i; j++) {
                if (m[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    m[i] = Math.min(m[i], m[j] + 1);
                }
            }
        }
        return m[m.length - 1];
    }

	// bfs
	public int jump2(int[] nums) {
		if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
		if (nums.length == 1) return 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[nums.length];
		queue.offer(0);
		visited[0] = true;
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer curIndex = queue.poll();
				for (int j = Math.min(curIndex + nums[curIndex], nums.length - 1); j >= curIndex; j--) {
					if (j == nums.length - 1) return level + 1;
					if (!visited[j]) {
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
			level++;
		}
		return Integer.MAX_VALUE;
	}
}
