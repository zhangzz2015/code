import java.util.*;
class Traverse {
	public List<String> getPath(String[][] roads) {
        if (roads == null || roads.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = buildMap(roads);
        List<String> res = new ArrayList<>();
        dfs(map, res, new HashSet<>(), roads[0][0]);
        return res;
    }

    private boolean dfs(Map<String, List<String>> map, List<String> res, Set<String> visited, String cur) {
        if (res.size() == map.size() && cur.equals(res.get(0))) {
            res.add(cur);
            return true;
        }
        if (!visited.add(cur)) {
            return false;
        }
        res.add(cur);
        for (String neiCity : map.get(cur)) {
            if (dfs(map, res, visited, neiCity)) {
                return true;
            }
        }
        visited.remove(cur);
        res.remove(res.size() - 1);
        return false;
    }

    private Map<String, List<String>> buildMap(String[][] roads) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] r : roads) {
            map.putIfAbsent(r[0], new ArrayList<>());
            map.putIfAbsent(r[1], new ArrayList<>());
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }
        return map;
    }

	public static void main(String[] args) {
        Traverse solve = new Traverse();
        String[][] roads1 = {{"a", "b"}, {"b", "c"}, {"c", "d"}, {"d", "a"}};
        String[][] roads2 = {{"a", "b"}, {"b", "c"}, {"c", "a"}, {"d", "a"}};
		String[][] roads3 = {{"a", "b"}, {"b", "c"}, {"b", "d"}, {"d", "c"}, {"c", "a"}};
		// expect abcda
        solve.getPath(roads1).forEach(System.out::print);
        System.out.println("");
		// expect empty
        solve.getPath(roads2).forEach(System.out::print);
		System.out.println("");
		// expect abdca
		solve.getPath(roads3).forEach(System.out::print);
    }
}
