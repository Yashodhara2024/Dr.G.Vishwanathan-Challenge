LeetCode Problem 124 : Binary Tree Maximum Path Sum
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:
Input: root = [1,2,3]
Output: 6

Code:
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }
    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
