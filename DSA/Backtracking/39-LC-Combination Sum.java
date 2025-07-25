// https://leetcode.com/problems/combination-sum/

// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []
 

// Constraints:

// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// All elements of candidates are distinct.
// 1 <= target <= 40

class Solution {
    private void compute(int i, int sum, List<Integer> ls, int n, int target, List<List<Integer>> ans, int[] candidates) {
        if(sum == target) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(sum > target || i == n) {
            return;
        }

        
        ls.add(candidates[i]);
        compute(i, sum + candidates[i], ls, n, target, ans, candidates);
        ls.remove(ls.size() - 1);
        
        compute(i+1, sum, ls, n, target, ans, candidates);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = candidates.length;

        compute(0, 0, new ArrayList<>(), n, target, ans, candidates);

        return ans;
    }
}

// TC: O(2^n) in the worst case, where n is the number of candidates
// SC: O(n) for the recursion stack and O(k) for storing each combination,