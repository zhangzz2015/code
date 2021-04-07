import java.util.*;

class SerDes {
	static class TreeNode {
        String val;
        TreeNode left,right;
        TreeNode(String val) {
            this.val = val;
        }
    }

    private static final String DELIMITER = ",";
    private static final String NN = "#";
    private static final String ESCAPE = "/";


    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(DELIMITER);
            return;
        }
        if (root.val.equals(DELIMITER) || root.val.equals(ESCAPE) || root.val.equals(NN)) {
            sb.append(ESCAPE).append(root.val);
        } else {
            sb.append(root.val);
        }
        sb.append(DELIMITER);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        int[] index = new int[1];
        return construct(data, index);
    }
    private TreeNode construct(String data, int[] index) {
        if (NN.equals(new String(new char[]{data.charAt(index[0])}))) {
            index[0] += 2;
            return null;
        }
        TreeNode root;
        if (ESCAPE.equals(new String(new char[]{data.charAt(index[0])}))) {
            root = new TreeNode(new String(new char[]{data.charAt(++index[0])}));
        } else {
            root = new TreeNode(new String(new char[]{data.charAt(index[0])}));
        }
        index[0] += 2;
        root.left = construct(data, index);
        root.right = construct(data, index);
        return root;
    }


	// used only for test
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Test SerDes = new Test();
        TreeNode node1 = new TreeNode(",");
        TreeNode node2 = new TreeNode("/");
        TreeNode node3 = new TreeNode("#");
        node1.left = node2;
        node1.right = node3;
        String res = SerDes.serialize(node1);
        System.out.println(res);
        TreeNode root = SerDes.deserialize(res);
        System.out.println("*******");
        SerDes.printTree(root);
    }
}
