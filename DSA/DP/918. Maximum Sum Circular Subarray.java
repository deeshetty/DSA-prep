// https://leetcode.com/problems/maximum-sum-circular-subarray/description/

// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

// Example 1:

// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3.
// Example 2:

// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// Example 3:

// Input: nums = [-3,-2,-3]
// Output: -2
// Explanation: Subarray [-2] has maximum sum -2.
 

// Constraints:

// n == nums.length
// 1 <= n <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104

//Copilot gen
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int total = 0;
        int curMax = Integer.MIN_VALUE;
        int curMin = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            total += nums[i];

            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, curMax);

            curMin = Math.min(curMin + nums[i], nums[i]);
            minSoFar = Math.min(minSoFar, curMin);
        }

        if(total == minSoFar) {
            return maxSoFar;
        }

        return Math.max(maxSoFar, total - minSoFar);
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

class Solution {
    private int maxSubArray(int[] arr) {
        int max = arr[0];
        int prev = arr[0];
        int n = arr.length;

        for(int i=1; i<n; i++) { //TC: O(N)
            int cur = Math.max(arr[i] + prev, arr[i]);

            max = Math.max(max, cur);

            prev = cur;
        }

        return max;
    }

    private int minSubArray(int[] arr) {
        int min = arr[0];
        int prev = arr[0];
        int n = arr.length;

        for(int i=1; i<n; i++) { //TC: O(N)
            int cur = Math.min(arr[i] + prev, arr[i]);

            min = Math.min(min, cur);

            prev = cur;
        }

        return min;
    }

    private int total(int[] arr) { //TC: O(N)
        int total = 0;

        for(int ele : arr) {
            total += ele;
        }

        return total;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return 0;
        }

        int total = total(nums);
        int max = maxSubArray(nums);
        int min = minSubArray(nums);

        if(total == min) {
            return max;
        }

        return Math.max(max, total-min);
    }
}

//TC: O(N)
//SC: O(1)