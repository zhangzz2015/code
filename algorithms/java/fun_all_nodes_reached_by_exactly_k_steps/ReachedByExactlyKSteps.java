import java.util.*;
class ReachedByExactlyKSteps {
	static class Node {
		int val;
		List<Node> neighbors;
		Node(int val) {
			this.val = val;
			this.neighbors = new ArrayList<>();
		}
	}
	// bfs
	public List<Node> bfs(Node root, int k) {
		Set<Node> curLevel = new HashSet<>();
		curLevel.add(root);
		int level = 0;
		while (level < k && !curLevel.isEmpty()) {
			Set<Node> nextLevel = new HashSet<>();
			for (Node cur : curLevel) {
				for (Node nei : cur.neighbors) {
					nextLevel.add(nei);
				}
			}
			curLevel = nextLevel;
			level++;
		}
		if (level == k) return new ArrayList<>(curLevel);
		return new ArrayList<Node>();
	}

	// dfs
	public List<Node> dfs(Node root, int k) {
		Set<Node> res = new HashSet<>();
		Set<Node> path = new HashSet<>();
		dfs(res, k, root, path, 0);
		return new ArrayList<>(res);
	}

	private void dfs(Set<Node> res, int k, Node root, Set<Node> path, int level) {
		if (level == k) {
			res.add(root);
			return;
		}
		for (Node nei : root.neighbors) {
			if (path.add(nei)) {
				dfs(res, k, nei, path, level + 1);
				path.remove(nei);
			}
		}
	}

	public static void main(String[] args) {
		ReachedByExactlyKSteps solve = new ReachedByExactlyKSteps();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.neighbors.add(n2);
		n1.neighbors.add(n4);
		n2.neighbors.add(n3);
		n3.neighbors.add(n1);
		n4.neighbors.add(n3);
		n4.neighbors.add(n5);
		n5.neighbors.add(n3);
		List<Node> bfsResult = solve.bfs(n1, 3);
		List<Node> dfsResult = solve.dfs(n1, 3);
		for (Node node : bfsResult) {
			System.out.print(node.val + " ");
		}
		System.out.println(" ");
		for (Node node : dfsResult) {
			System.out.print(node.val + " ");
		}
	}
}
