LeetCode Problem 106 : Construct Binary Tree from Inorder and Postorder Traversal
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Code:
class Solution {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = postorder[index--];
        TreeNode root = new TreeNode(val);
        int i = start;
        while (inorder[i] != val) {
            i++;
        }
        root.right = build(inorder, postorder, i + 1, end);
        root.left = build(inorder, postorder, start, i - 1);
        return root;
    }
}


