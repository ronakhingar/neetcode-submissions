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
    Map<Integer,Integer> reverseInorder = new HashMap<>();
    int preOrderIndex=-1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        

        for(int i =0;i< inorder.length;i++){
            reverseInorder.put(inorder[i],i);
        }
      return  build(preorder,reverseInorder,0,preorder.length-1);

    }

    private TreeNode build(int[] preorder,Map<Integer,Integer> reverseInorder, int minIndex ,int maxIndex){

        if(minIndex>maxIndex ){
            return null;
        }

        preOrderIndex++;

        TreeNode root = new TreeNode(preorder[preOrderIndex]);

       TreeNode left = build(preorder,reverseInorder,minIndex,reverseInorder.get(root.val)-1);
        TreeNode right = build(preorder,reverseInorder,reverseInorder.get(root.val)+1,maxIndex);

        root.left = left;
        root.right = right;

        return root;
    }
}
