/**
 * Subsets
 * https://leetcode.com/problems/subsets/description/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */

class Solution {
    private void compute(int idx, int[] arr, List<List<Integer>> ans, List<Integer> ls, int n) {
        if(idx == n) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        //Include current element
        ls.add(arr[idx]);
        compute(idx+1, arr, ans, ls, n);

        //Exclude current element
        ls.remove(ls.size() - 1);
        compute(idx+1, arr, ans, ls, n);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        compute(0, nums, ans, new ArrayList<>(), nums.length);

        return ans;
    }
}

// Time Complexity: O(2^N) - Each element can either be included or excluded, leading to 2^N subsets.
// Space Complexity: O(N) - The space used by the recursion stack and the list to store the current subset. The maximum depth of the recursion is N, where N is the length of the input array.