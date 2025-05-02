//https://neetcode.io/problems/invert-a-binary-tree
// You are given the root of a binary tree root. Invert the binary tree and return its root.

// Example 1:

// Input: root = [1,2,3,4,5,6,7]

// Output: [1,3,2,7,6,5,4]

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
    public TreeNode invertTree(TreeNode root) {
        if(
            root == null || 
            (root.left == null && root.right == null)
        ) {
            return root;
        }

        //Swapping before recursion avoids unnecessary recursion for full nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

// TC: O(N)
// SC: O(h)

//Iterative
class Solution0 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode cur = st.pop();

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if(cur.left != null) {
                st.push(cur.left);
            }
            if(cur.right != null) {
                st.push(cur.right);
            }
        }
        return root;
    }
}