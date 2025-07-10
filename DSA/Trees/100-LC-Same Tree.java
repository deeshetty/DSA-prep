// https://leetcode.com/problems/same-tree/

// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

// Example 1:


// Input: p = [1,2,3], q = [1,2,3]
// Output: true
// Example 2:


// Input: p = [1,2], q = [1,null,2]
// Output: false
// Example 3:


// Input: p = [1,2,1], q = [1,1,2]
// Output: false
 

// Constraints:

// The number of nodes in both trees is in the range [0, 100].
// -104 <= Node.val <= 104

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null & q == null) {
            return true;
        }

        if(p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
//TC: O(N)
//SC: O(H) for the recursion stack, where H is the height of the tree

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null || p.val != q.val) {
            return false;
        }

        Deque<TreeNode> q1 = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();

        q1.offer(p);
        q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            if(q1.size() != q2.size()) {
                return false;
            }

            int size = q1.size();

            for(int i=0; i<size; i++) {
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();

                if(node1.val != node2.val) {
                    return false;
                }

                if(node1.left != null && node2.left == null) {
                    return false;
                }
                if(node1.left == null && node2.left != null) {
                    return false;
                }
                if(node1.left != null && node2.left!= null) {
                    q1.offer(node1.left);
                    q2.offer(node2.left);
                }

                if(node1.right != null && node2.right == null) {
                    return false;
                }
                if(node1.right == null && node2.right != null) {
                    return false;
                }
                if(node1.right != null && node2.right!= null) {
                    q1.offer(node1.right);
                    q2.offer(node2.right);
                }
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
//Iterative using queue
//TC: O(N)
//SC: O(W) for the queue, where W is the maximum width of the tree