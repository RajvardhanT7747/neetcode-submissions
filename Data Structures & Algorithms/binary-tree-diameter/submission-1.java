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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0; 
        // int ans1 = height(root.left) + height(root.right);
        // int ans2 = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));  
        // return Math.max(ans1, ans2); 

        int[] res = new int[1]; // keep track of diameter  
        height(root, res);
        return res[0];
    } 
    public int height(TreeNode root, int[] res){
        if(root == null){
            return 0;
        } 
        int left = height(root.left, res);
        int right = height(root.right, res); 
        res[0] = Math.max(res[0], left + right); 

        return 1 + Math.max(left, right);
    }
}
