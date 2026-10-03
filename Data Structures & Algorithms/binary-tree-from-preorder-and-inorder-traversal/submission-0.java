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

    int pre_idx = 0;
    HashMap<Integer, Integer> mpp = new HashMap<>(); 

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            mpp.put(inorder[i], i); 
        } 
        return dfs(preorder, 0, inorder.length - 1);     
    } 
    public TreeNode dfs(int[] preorder, int left, int right){
        if(left > right) return null; 

        int currentRoot = preorder[pre_idx++]; 
        int mid = mpp.get(currentRoot); 
        TreeNode node = new TreeNode(currentRoot);  

        node.left = dfs(preorder, left, mid-1); 
        node.right = dfs(preorder, mid+1, right); 

        return node;
    }
}
