/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * 
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * 
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if(l != null && r != null) {
            return root;
        }

        if(l != null) {
            return l;
        } else {
            return r;
        }
    }
}
//TC: O(N)
//SC: O(H) where H is the height of the tree, due to recursion stack
//This works fine when both p and q are present in the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private class Result {
        TreeNode node;
        boolean foundP;
        boolean foundQ;

        Result(TreeNode node, boolean foundP, boolean foundQ) {
            this.node = node;
            this.foundP = foundP;
            this.foundQ = foundQ;
        }
    }

    private Result helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Result(null, false, false);
        }

        Result left = helper(root.left, p, q);
        Result right = helper(root.right, p, q);

        boolean foundP = left.foundP || right.foundP || root == p;
        boolean foundQ = left.foundQ || right.foundQ || root == q;

        if (root == p || root == q) {
            return new Result(root, foundP, foundQ);
        }
        
        if(left.node != null && right.node != null) {
            return new Result(root, foundP, foundQ);
        }

        if(left.node != null) {
            return new Result(left.node, foundP, foundQ);
        }

        if(right.node != null) {
            return new Result(right.node, foundP, foundQ);
        }

        return new Result(null, foundP, foundQ);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result res = helper(root, p, q);

        if(res.foundP && res.foundQ && res.node != null) {
            return res.node;
        }
        return null;
    }
}
//TC: O(N)
//SC: O(H) where H is the height of the tree, due to recursion stack
// This version handles the case where either p or q might not be present in the tree.
// It returns the LCA only if both nodes are found in the tree, otherwise it returns null.