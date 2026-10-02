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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Note: BST has one important property root root.left < root < root.right based on this property we can easily search p and q in tree but if tree were general tree then we need something to track parent at that time we need to go backward right ot find parent thats why we need to something to store parent instead of going backward and go ahead recursively 

        if(root == null) return null;
        // both p and q are smaller so explore left as per property of bst
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q); 
        }else if(p.val > root.val && q.val > root.val){
            // both p and q are larger so explore right as per property of bst
            return lowestCommonAncestor(root.right, p, q);
        } else{
            // this else means p is less than root and q is greater than root so current root is our lca 
            return root;
        }
    }
}
