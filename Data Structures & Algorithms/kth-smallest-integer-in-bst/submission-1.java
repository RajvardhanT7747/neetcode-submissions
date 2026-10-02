/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k);
    } 
    public int dfs(TreeNode root, int k){
        // left then root then right 
        if(root == null) return -1; 

        int left = dfs(root.left, k); 
        if(left != -1){
            // means we got ans 
            return left;
        } 
        count++; // processed one node 

        if(count == k) return root.val; 

        // right 
        int right = dfs(root.right, k); 
        return right; 
    }
}
