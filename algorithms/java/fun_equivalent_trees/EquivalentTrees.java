import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
* Given two expression trees (with operator '+' or '-'). Determine if they are literally equivalent ot each other.
*          +                            +
*        /   \                     /       \
*       1     +                  +           3
*            /  \              /   \
*           2   3             1    2
*     1 + (2 + 3)              (1 + 2) + 3
*     They are equivalent.
*/
public class EquivalentTrees {
   class TreeNode {
       char val;
       TreeNode left;
       TreeNode right;
       public TreeNode(char val) {
           this.val = val;
       }
   }

   class TreeIterator implements Iterator<TreeNode> {

       private Deque<TreeNode> stack;
       public TreeIterator(TreeNode root) {
           stack = new ArrayDeque<>();
           firstNode(root, /* shouldReverse= */false);
       }

       private void firstNode(TreeNode root, boolean shouldReverse) {
           while (root != null) {
               if (shouldReverse) {
                   root.val = root.val == '+' ? '-' : '+';
               }
               stack.push(root);
               root = root.left;
           }
       }

       @Override
       public boolean hasNext() {
           return !stack.isEmpty();
       }

       @Override
       public TreeNode next() {
           TreeNode node = stack.pop();
           firstNode(node.right, node.val == '-');
           return node;
       }
   }
   public boolean isEqual(TreeNode root1, TreeNode root2) {
       if (root1 == null || root2 == null) {
           return root1 == null && root2 == null;
       }
       TreeIterator iter1 = new TreeIterator(root1);
       TreeIterator iter2 = new TreeIterator(root2);
       while (iter1.hasNext() && iter2.hasNext()) {
           if (iter1.next().val != iter2.next().val) {
               return false;
           }
       }
       return !iter1.hasNext() && !iter2.hasNext();
   }
}