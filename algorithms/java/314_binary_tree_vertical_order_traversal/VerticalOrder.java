import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {

    static class Element {
        TreeNode node;
        int col;
        Element(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    // 1. BFS
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Element> queue = new ArrayDeque<>();
        queue.offer(new Element(root, 0));
        while (!queue.isEmpty()) {
            Element cur = queue.poll();
            map.putIfAbsent(cur.col, new ArrayList<>());
            map.get(cur.col).add(cur.node.val);
            if (cur.node.left != null) {
                queue.offer(new Element(cur.node.left, cur.col - 1));
            }
            if (cur.node.right != null) {
                queue.offer(new Element(cur.node.right, cur.col + 1));
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    // 2. DFS
    private int minCol = 0;
    public List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        minCol = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        dfs(root, map, 0, 0);
        while (map.containsKey(minCol)) {
            List<int[]> list = map.get(minCol);
            Collections.sort(list, new Comparator<int[]>() {
                @Override 
                public int compare(int[] arr1, int[] arr2) {
                    return arr1[0] - arr2[0];
                }
            });
            List<Integer> l = new ArrayList<Integer>();
            for (int[] arr : list) {
                l.add(arr[1]);
            }
            result.add(l);
            minCol++;
        }
        return result;
    }

    private void dfs(TreeNode cur, Map<Integer, List<int[]>> map, int col, int row) {
        if (cur == null) return;
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, cur.val});
        minCol = Math.min(minCol, col);
        dfs(cur.left, map, col - 1, row + 1);
        dfs(cur.right, map, col + 1, row + 1);
    }
}