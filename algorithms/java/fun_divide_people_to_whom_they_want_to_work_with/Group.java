import java.util.*;

class Group {
	public List<List<Character>> devidePeople(char[][] edges, int n) {
		List<Character> one = new ArrayList<>();
		List<Character> two = new ArrayList<>();
		List<List<Character>> res = new ArrayList<>();
		Map<Character, List<Character>> graph = buildGraph(edges);
		Map<Character, Integer> visited = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!bfs((char)('A' + i), visited, one, two, graph)) {
				return res;
			}
		}
		res.add(one);
		res.add(two);
		return res;
	}
	private Map<Character, List<Character>> buildGraph(char[][] edges) {
		Map<Character, List<Character>> map = new HashMap<>();
		for (char[] e : edges) {
			map.putIfAbsent(e[0], new ArrayList<>());
			map.putIfAbsent(e[1], new ArrayList<>());
			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}
		return map;
	}
	private boolean bfs(Character node, Map<Character, Integer> visited, List<Character> one, List<Character> two, Map<Character, List<Character>> map) {
		if (visited.containsKey(node)) {
			return true;
		}
		Queue<Character> queue = new ArrayDeque<>();
		queue.offer(node);
		one.add(node);
		visited.put(node, 0);
		while (!queue.isEmpty()) {
			Character cur = queue.poll();
			int curGroup = visited.get(cur);
			int neiGroup = curGroup == 0 ? 1 : 0;
			for (Character nei : map.get(cur)) {
				Integer group = visited.get(nei);
				if (group == null) {
					visited.put(nei, neiGroup);
					if (neiGroup == 0) {
						one.add(nei);
					} else {
						two.add(nei);
					}
					queue.offer(nei);
				} else if (group != neiGroup) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Group solve = new Group();
		char[][] input = {{'A', 'B'}, {'C', 'D'}, {'B', 'E'}};
		List<List<Character>> res = solve.devidePeople(input, 5);
		for (List<Character> r : res) {
			for (Character c : r) {
				System.out.print(c);
			}
			System.out.println("");
		}
	}
}
