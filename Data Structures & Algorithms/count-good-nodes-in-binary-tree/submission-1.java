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
    public int goodNodes(TreeNode root) {
        // problem is simple good node means node which is greater or equal to prev visited nodes from root simple if it is not then taht current node is not a good node 

        // return dfs(root, root.val);
        int ans = 0; 
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>(); 
        q.add(new Pair<>(root, Integer.MIN_VALUE));  

        while(!q.isEmpty()){
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey(); 
            int maxSoFar = pair.getValue(); 

            if(node.val >= maxSoFar){
                ans++;
            } 
            if(node.left != null){
                q.add(new Pair<>(node.left, Math.max(node.val, maxSoFar)));
            }  
            if(node.right != null){
                q.add(new Pair<>(node.right, Math.max(node.val, maxSoFar)));
            } 
        } 
        return ans; 
    } 
    public int dfs(TreeNode root, int maxSoFar){
        if(root == null) return 0;
        int count = 0 ; 

        if(root.val >= maxSoFar){
            count++; 
            maxSoFar = Math.max(maxSoFar, root.val);
        } 
        count += dfs(root.left, maxSoFar);
        count += dfs(root.right, maxSoFar); 

        return count;
    }
}
