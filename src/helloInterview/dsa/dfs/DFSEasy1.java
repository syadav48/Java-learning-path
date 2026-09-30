package helloInterview.dsa.dfs;

import com.sun.source.tree.Tree;

public class DFSEasy1 {
    int sum = 0;
    private TreeNode current;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(root.val >= low && high >= root.val){
                sum += root.val;
            }
        }
        sum = rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        return sum;
    }

    public int rangeSumBSTOpt(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int total = 0;
        if(root.val >= low && root.val <= high){
            total += root.val;
        }
        if(root.val > low){
            total += rangeSumBSTOpt(root.left, low, high);
        }
        if(root.val < high){
            total += rangeSumBSTOpt(root.right, low, high);
        }
        return total;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        return dfs1(cloned.right, target);
    }

    private TreeNode dfs1(TreeNode node, TreeNode target) {
        if(node.val == target.val){
            return node;
        }
        dfs1(node.left, target);
        dfs1(node.right, target);
        return new TreeNode();
    }

    public final TreeNode getTargetCopyOpt(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        if(original == target){
            return cloned;
        }
        TreeNode left = getTargetCopyOpt(original.left, cloned.left, target);
        if(left != null){
            return left;
        }
        return getTargetCopyOpt(original.right, cloned.right, target);
    }

    public boolean evaluateTree(TreeNode root) {
        if(root == null){
            return false;
        }
        if(root.val == 0){
            return false;
        }
        if(root.val == 1){
            return true;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if(root.val == 2){
            return left && right;
        }
        return left || right;
    }

    public boolean evaluateTreeOpt(TreeNode root) {
        // Leaf nodes: 0 = false, 1 = true
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // Internal nodes: 2 = AND, 3 = OR
        boolean left = evaluateTreeOpt(root.left);
        boolean right = evaluateTreeOpt(root.right);

        if (root.val == 2) {
            return left && right;
        }
            return left || right;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode dummy = new TreeNode();
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        dummy.val = root1.val + root2.val;
        dummy.left = mergeTrees(root1.left, root2.left);
        dummy.right = mergeTrees(root1.right, root2.right);
        return dummy;
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        current = dummy;
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);

        current.right = root;
        root.left = null;
        current = root;

        inorder(root.right);
    }


    public static void main(String[] args) {
        DFSEasy1 dfsEasy1 = new DFSEasy1();
        TreeNode treeNode = new TreeNode(18);
        TreeNode treeNode1 = new TreeNode(15, null, treeNode);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5, treeNode3, treeNode2);
        TreeNode treeNode5 = new TreeNode(10, treeNode4, treeNode1);
        System.out.println(dfsEasy1.rangeSumBSTOpt(treeNode5, 7, 15));
        System.out.println(dfsEasy1.rangeSumBST(treeNode5, 7, 15));


        TreeNode treeNode6 = new TreeNode(19);
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(3, treeNode7, treeNode6);
        TreeNode treeNode9 = new TreeNode(4);
        TreeNode treeNode10 = new TreeNode(7, treeNode9, treeNode8);
        CloneTree cloneTree = new CloneTree();
        TreeNode cloned = cloneTree.clone(treeNode10);

        dfsEasy1.getTargetCopyOpt(treeNode10, cloned, treeNode8);
        System.out.println(cloned.val + "cloned");
        System.out.println(treeNode10.val + "cloned");
        System.out.println("are they same obj:"  + (cloned == treeNode10));

        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(0);
        TreeNode treeNode13 = new TreeNode(3, treeNode12, treeNode11);
        TreeNode treeNode14 = new TreeNode(1);
        TreeNode treeNode15 = new TreeNode(2, treeNode14, treeNode13);

        System.out.println(dfsEasy1.evaluateTree(treeNode15));


        TreeNode treeNode16 = new TreeNode(7);
        TreeNode treeNode17 = new TreeNode(2);
        TreeNode treeNode18 = new TreeNode(4, treeNode17, treeNode16);

        System.out.println(dfsEasy1.invertTree(treeNode18));

        TreeNode treeNode19 = new TreeNode(2);
        TreeNode treeNode20 = new TreeNode(3);
        TreeNode treeNode21 = new TreeNode(1, treeNode20, treeNode19);

        TreeNode treeNode22 = new TreeNode(1);
        TreeNode treeNode23 = new TreeNode(3);
        TreeNode treeNode24 = new TreeNode(2, treeNode22, treeNode23);

        System.out.println(dfsEasy1.mergeTrees(treeNode21, treeNode24));

        TreeNode treeNode25 = new TreeNode(1);
        TreeNode treeNode26 = new TreeNode(7);
        TreeNode treeNode27 = new TreeNode(5, treeNode25, treeNode26);

        System.out.println(dfsEasy1.increasingBST(treeNode27));








    }
}
