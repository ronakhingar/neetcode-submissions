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
    int longest=0;
    public int diameterOfBinaryTree(TreeNode root) {
         diameter(root);
         return longest;
    }

    private int diameter(TreeNode root){

        if(root==null){
            return 0;
        }

        int leftHt= diameter(root.left);

        int rightHt= diameter(root.right);

        longest=Math.max(longest,leftHt+rightHt);
        return Math.max(1+leftHt,1+rightHt);
    }
}
