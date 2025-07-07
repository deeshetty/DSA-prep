// https://leetcode.com/problems/binary-tree-level-order-traversal/

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode top = q.poll();
                ls.add(top.val);

                if(top.left != null) {
                    q.offer(top.left);
                }

                if(top.right != null) {
                    q.offer(top.right);
                }
            }

            ans.add(new ArrayList<>(ls));
        }

        return ans;
    }
}

//TC: O(N)
//SC: O(N) queue and ans list
// where N is the number of nodes in the tree.