package Q0297_Serialize_and_Deserialize_Binary_Tree;

import java.util.Arrays;
import java.util.LinkedList;

// Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    private static final String separator = ",";
    private static final String nullStr = "#"; 

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(nullStr + separator);
        } else {
            sb.append(node.val).append(separator);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(separator)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(LinkedList<String> nodes) {
        String val = nodes.remove();
        if (val.equals(nullStr)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));