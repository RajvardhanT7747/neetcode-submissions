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
    List<Integer> ans = new ArrayList<>(); 
    public List<Integer> rightSideView(TreeNode root) {
        // List<Integer> ans = new ArrayList<>(); 
        // Queue<TreeNode> q = new LinkedList<>(); 
        // q.add(root);

        // while(!q.isEmpty()){
        //     TreeNode rightSide = null; 
        //     int n = q.size(); 

        //     for(int i=0; i<n; i++){
        //         TreeNode node = q.poll(); 
        //         if(node != null){
        //             rightSide = node;
        //             q.add(node.left);
        //             q.add(node.right);
        //         }

        //     } 
        //     if(rightSide != null){
        //         ans.add(rightSide.val);
        //     }
        // }
        // return ans;
        solve(root, 0);
        return ans;
    } 
    public void solve(TreeNode root, int depth){
        if(root == null) return; 

        if(ans.size() == depth){
            ans.add(root.val); 
        }  

        // first explore right then left such taht after right we can move to left remaining and depth is key to skip first ones behind right ones 
        solve(root.right, depth + 1);
        solve(root.left, depth + 1);
    }
}
