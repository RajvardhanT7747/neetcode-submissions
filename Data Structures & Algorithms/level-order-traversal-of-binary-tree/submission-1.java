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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) { 
        // List<List<Integer>> list = new ArrayList<>(); 

        // if(root == null) return list; 

        // Queue<TreeNode> q = new LinkedList<>(); 
        // q.add(root);
        
        // while(!q.isEmpty()){
        //     int n = q.size(); 
        //     List<Integer> current = new ArrayList<>();
        //     for(int i=0; i<n; i++){
        //         TreeNode currentNode = q.poll();
        //         current.add(currentNode.val);
        //         if(currentNode.left != null) q.offer(currentNode.left);
        //         if(currentNode.right != null) q.offer(currentNode.right);
        //     }
        //     list.add(current);
        // }
        // return list; 
        dfs(root, 0);
        return result;
    } 
    public void dfs(TreeNode root, int depth){
        if(root == null) return; 

        if(result.size() == depth){ // that means we are done with current level move to next level 
            result.add(new ArrayList<>()); 
        } 
        result.get(depth).add(root.val); // now main question is how to insert current element into current index in list that is where depth comes in first fetch dpeth then add 
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
