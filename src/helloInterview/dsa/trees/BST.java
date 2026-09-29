package helloInterview.dsa.trees;

import helloInterview.dsa.dfs.TreeNode;

import java.util.List;
import java.util.Stack;

public class BST {
    private int diameter = 0;
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }
        if (target < root.val) {
            return searchBST(root.left, target);
        }
        return searchBST(root.right, target);
    }
    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            // No left child
            if (root.left == null) {
                return root.right;
            }
            // No right child
            if (root.right == null) {
                return root.left;
            }
            // Two children
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(
                    root.right,
                    successor.val
            );
        }
        return root;
    }
    public boolean isValidBST(TreeNode root) {
        return validate(
                root,
                Long.MIN_VALUE,
                Long.MAX_VALUE
        );
    }
    private boolean validate(
            TreeNode root,
            long min,
            long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return validate(root.left, min, root.val)
                && validate(root.right, root.val, max);
    }
    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        if (root == null ||
                root == p ||
                root == q) {

            return root;
        }
        TreeNode left =
                lowestCommonAncestor(root.left, p, q);
        TreeNode right =
                lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
    public TreeNode lowestCommonAncestorBST(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(
                    root.left, p, q
            );
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
    public boolean hasPathSum(
            TreeNode root,
            int target) {

        if (root == null) {
            return false;
        }

        if (root.left == null &&
                root.right == null) {

            return target == root.val;
        }

        int remaining = target - root.val;

        return hasPathSum(root.left, remaining)
                || hasPathSum(root.right, remaining);
    }
    void dfs(
            TreeNode root,
            List<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        // process leaf

        dfs(root.left, path);
        dfs(root.right, path);

        path.remove(path.size() - 1);
    }


    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }
    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(
                diameter,
                left + right
        );

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        return heightB(root) != -1;
    }

    private int heightB(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);

        if (left == -1) {
            return -1;
        }

        int right = height(root.right);

        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left, root.right);
    }

    private boolean mirror(
            TreeNode a,
            TreeNode b) {

        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        return a.val == b.val
                && mirror(a.left, b.right)
                && mirror(a.right, b.left);
    }
    public boolean isSameTree(
            TreeNode p,
            TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public int kthSmallest(
            TreeNode root,
            int k) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (true) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            k--;

            if (k == 0) {
                return curr.val;
            }

            curr = curr.right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(
            int[] nums,
            int left,
            int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {

    }
}
