Leetcode Problem 105 : Construct Binary Tree from Preorder and Inorder Traversal
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Code:
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {   
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int index = inStart;
        while (inorder[index] != rootValue)
            index++;
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                          inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                           inorder, index + 1, inEnd);
        return root;
    }
}
