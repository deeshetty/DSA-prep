/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * 
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * Example 3:
 *
 * Input: root = []
 * Output: true
 * 
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */

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
    private int compute(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftH = compute(root.left);
        int rightH = compute(root.right);

        if(leftH == -1 || rightH == -1 || Math.abs(rightH-leftH) > 1) {
            return -1;
        }

        return 1 + Math.max(leftH, rightH);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        return compute(root) != -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree, due to recursion stack.