class MinConnect {
	// 1. Kruskal
	int[] ids;
	int[] sizes;
	private int find(int x) {
		int root = x;
		while (root != ids[root]) {
			root = ids[root];
		}
		while (x != root) {
			int next = ids[x];
			ids[x] = root;
			x = next;
		}
		return root;
	}
	private void union(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);
        if (root1 == root2) {
            return;
        }
        if (sizes[root1] < sizes[root2]) {
            sizes[root2] += sizes[root1];
            ids[root1] = root2;
        } else {
            sizes[root1] += sizes[root2];
            ids[root2] = root1;
        }
    }
	public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        this.ids = new int[n];
        this.sizes = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a,b) -> Integer.compare(a.dis, b.dis));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new Edge(dis, i, j));
            }
        }
        int res = 0;
        int count = 1;
        while (count < n) {
            Edge edge = pq.poll();
            int start = edge.start;
            int end = edge.end;
            int dis = edge.dis;
            if (find(start) != find(end)) {
                union(start, end);
                count++;
                res += dis;
                if (count == n) {
                    break;
                }
            }
        }
        return res;
    }
	static class Edge {
        int dis;
        int start;
        int end;
        Edge(int dis, int start, int end) {
            this.dis = dis;
            this.start = start;
            this.end = end;
        }
    }


	// 2. Prim
	public int minCostConnectPoints1(int[][] points) {
		int n = points.length;
		if (n == 1) {
			return 0;
		}
		boolean[] visited = new boolean[n];
		int[] minDis = new int[n];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		minDis[0] = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			int next = i;
			int minCost = Iteger.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (!visited[j] && minDis[j] <= minCost) {
					minCost = minDis[j];
					next = j;
				}
			}
			visited[next] = true;
			res += minCost;
			for (int j = 0; j < n; j++) {
				if (!visited[j]) {
					int newDis = Math.abs(points[j][0] - points[next][0]) + Math.abs(points[j][1] - points[next][1]);
					minDis[j] = Math.min(minDis[j], newDis);
				}
			}
		}
		return res;
	}
}
