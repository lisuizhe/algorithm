import java.util.ArrayList;
import java.util.List;

class TreeNode<T extends Comparable<T>> {
    public T val;
    public TreeNode<T> left, right;

    public TreeNode(T val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Traversal<T extends Comparable<T>> {

    public List<T> preorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        recursivePreorder(root, result);
        return result;
    }

    private void recursivePreorder(TreeNode<T> node, List<T> result) {
        if (node != null) {
            result.add(node.val);
            recursivePreorder(node.left, result);
            recursivePreorder(node.right, result);
        }
    }

    public List<T> inorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        recursiveInorder(root, result);
        return result;
    }

    private void recursiveInorder(TreeNode<T> node, List<T> result) {
        if (node != null) {
            recursivePreorder(node.left, result);
            result.add(node.val);
            recursivePreorder(node.right, result);
        }
    }

    public List<T> postorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        recursivePostorder(root, result);
        return result;
    }

    private void recursivePostorder(TreeNode<T> node, List<T> result) {
        if (node != null) {
            recursivePreorder(node.left, result);    
            recursivePreorder(node.right, result);
            result.add(node.val);
        }
    }
}