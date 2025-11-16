/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */

//We cant use just the sliding window for this, as this can consist of negative numbers,
// addition of negative number can make or break a valid window
//Ex: 1,2,-2,-1,3; k=3; ans: 2
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        if(n==0 && k==0) {
            return 1;
        }
        if(n==0 && k!=0) {
            return 0;
        }

        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;

        int curSum=0;
        hm.put(0, 1);

        for(int i=0; i<n; i++) {
            curSum+=nums[i];
            if(hm.containsKey(curSum - k)) {
                ans += hm.get(curSum-k);
            }
            hm.put(curSum, hm.getOrDefault(curSum, 0)+1);
        }

        return ans;
    }
}

// Time Complexity (TC):
// O(n), where n is the length of the input array.
// Each element is processed once, and all hash map operations are O(1) on average.

// Space Complexity (SC):
// O(n) in the worst case, for storing up to n different prefix sums in the hash map.