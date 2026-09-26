package helloInterview.dsa.dfs;

import java.util.*;
import java.util.stream.Collectors;

public class FindModes {
    List<Integer> list = new ArrayList<>();
    private Integer prev = null;
    private int count = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        list.add(root.val);
        findMode(root.left);
        findMode(root.right);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(Integer num: list){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long maxFreq = map.values().stream().mapToLong(Integer::longValue).max().orElse(0);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == maxFreq){
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }

    public int[] findModeOpt(TreeNode root){
        inorder(root);
        return modes.stream().mapToInt(x -> x).toArray();
    }

    private void inorder(TreeNode node) {
        if(node == null) return;

        inorder(node.left);
        if(prev == null || node.val != prev){
            count = 1;
        } else {
            count++;
        }
        prev = node.val;
        if(count > maxCount){
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }
        inorder(node.right);
    }

    public static void main(String[] args) {
        FindModes findModes = new FindModes();
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, null);
        TreeNode treeNode = new TreeNode(1, null, treeNode2);
        System.out.println(Arrays.toString(findModes.findModeOpt(treeNode)));
    }
}
