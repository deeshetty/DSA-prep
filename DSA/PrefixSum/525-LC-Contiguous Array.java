/**
 * Contiguous Array
 * https://leetcode.com/problems/contiguous-array/description/?envType=problem-list-v2&envId=prefix-sum
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 * Example 1:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Example 3:
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 * How it works:
 * Replace each 0 with -1 in the prefix sum calculation.
 * Use a HashMap to store the first occurrence of each prefix sum.
 * If the same prefix sum is seen again, the subarray between those indices has equal numbers of 0s and 1s.
 * Update the answer with the maximum length found.
 */


class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int n = nums.length;

        int prefSum = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                prefSum--;
            } else {
                prefSum++;
            }

            if(hm.containsKey(prefSum)) {
                int curAns = i - hm.get(prefSum);
                ans = Math.max(ans, curAns);
            }

            hm.putIfAbsent(prefSum, i);
        }

        return ans;
    }
}

// TC: O(N)
// SC: O(N) for the hashmap
// Note: The prefix sum is calculated by treating 0 as -1, so that when we find the same prefix sum again, it indicates that the number of 0s and 1s in between are equal.

// Note: 
// To find the longest subarray with equal 0s and 1s, we treat every 0 as -1.
// As we go through the array, we keep a running sum (prefSum).
// If we ever see the same sum again at a later index, 
// it means the number of 1s and 0s between those two spots is the same (because the sum "balanced out" in between).
// We use a HashMap to remember the first time we saw each sum, so we can quickly check and update our answer.
// This way, we can solve the problem in one pass, and everything runs super fast!