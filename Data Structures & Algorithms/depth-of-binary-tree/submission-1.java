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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        // if(root != null) return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); // 1 is for current node so logic is take current node and explore along with below everything thats why 
    }
}
