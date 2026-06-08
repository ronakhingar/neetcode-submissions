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

    boolean found= false;
    int number=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return number;
    }

    private void traverse(TreeNode root, int k){
        
        if(root==null){
            return ;
        }

        
      kthSmallest(root.left,k);
count++;
    if(found){
        return ;
    }
      if(k==count){
        found=true;
        number=root.val;
        return;
      }
    
    
         kthSmallest(root.right,k);   
       
        

    }
}
