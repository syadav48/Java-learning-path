package helloInterview.dsa.trees;

import helloInterview.dsa.dfs.TreeNode;

public class SortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstBuilder(nums, 0, nums.length - 1);
    }

    private TreeNode bstBuilder(int[] nums, int left, int right) {
        if(left > right) return null;
        int mid = left + (right - left)/2;
        int val = nums[mid];
        TreeNode node = new TreeNode(val);
        node.left = bstBuilder(nums, left, mid - 1);
        node.right = bstBuilder(nums, mid + 1, right);
        return node;
    }



    public static void main(String[] args) {
        SortedArraytoBST arraytoBST = new SortedArraytoBST();
        int[] nums = {-10, -3, 0, 5, 9};
        arraytoBST.sortedArrayToBST(nums);
    }

}
