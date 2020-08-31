import java.util.Set;

public class ProctToTarget {
    public boolean findPathProduct(TreeNode root, int target) {
        Set<Double> prefixProds = new HashSet<>();
        prefixProds.add(Double.valueOf(1));
        return backtracking(root, target, 1, prefixProds);
    }
    private boolean backtracking(TreeNode root, int target, int prevProd, Set<Double> prefixProds) {
        if (root == null) return false;
        booean notExist = false;
        double newProd = prevProd * root.val;
        // case 1: when target == 0, then we need to find if there is 0 in the tree
        // case 2: target != 0 && root.val == 0, skip this 0 ans start a new state preix
        // case 3: target != 0 && root.val != 0, check prefixProds
        if (target == 0) {
            if (newProd == 0) return true;
        } else if (newProd == 0) {
            prefixProds = new HashSet<>();
            prefixProds.add(Double.valueOf(1));
            newProd = 1;
        } else {
            if (prefixProds.contains(newProd / target)) return true;
            notExist = prefixProds.add(newProd);
        }
        if (backtracking(root.left, target, newProd, prefixProds)) return true;
        if (backtracking(root.right, target, newProd, prefixProds)) return true;
        // recover
        if (notExist) {
            prefixProds.remove(newProd);
        }
        return false;
    }
}