/**
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * 
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * 
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();

            if(node1 == null && node2 == null) {
                continue;
            }

            if(node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            q.offer(node1.left);
            q.offer(node2.right);
            q.offer(node1.right);
            q.offer(node2.left);
        }

        return true;
    }
}
//TC: O(n)
//SC: O(n) for the queue
//Here we use a queue to store pairs of nodes. We compare the left and right children of the nodes in each pair. If they are equal, we continue; if not, we return false. If both nodes are null, we continue to the next pair.
//This approach ensures that we check the symmetry of the tree in a level-order manner, which is efficient and straightforward.


//Can also be implemented with 2 stacks by pushing left child to 1 stack, right child to the other stack, and then comparing the top elements of both stacks. If they are equal, pop them and continue. If not, return false.
//This is similar to the queue approach but uses stacks instead. The logic remains the same:

//Note:
//Since in queue approach, we are pushing null nodes as well, we need to use LinkedList version, not ArrayDeque, as ArrayDeque does not allow null elements.
