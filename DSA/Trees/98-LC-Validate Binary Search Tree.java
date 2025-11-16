/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
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
    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }

        if(root.val <= min) {
            return false;
        }
        if(root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val) && 
        helper(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        // if(root == null) {
        //     return true;
        // }
        // if(root.left == null && root.right == null) {
        //     return true;
        // }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

//TC: O(N)
//SC: O(H) where H is the height of the tree

//Note:
// Use long for min and max to handle edge cases where the node values are at the limits of int range.
//This prevents overflow when comparing node values with min and max.