// Given a binary array nums and an integer k, 
// return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

// Constraints:

// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length

////////

// Given a binary array arr[] (containing only 0s and 1s) and an integer k, 
// you are allowed to flip at most k 0s to 1s. 
// Find the maximum number of consecutive 1's that can be obtained in the array after performing the operation at most k times.

// Examples:

// Input: arr[] = [1, 0, 1], k = 1
// Output: 3
// Explanation: Maximum subarray of consecutive 1's is of size 3 which can be obtained after flipping the zero present at the 1st index.
// Input: arr[] = [1, 0, 0, 1, 0, 1, 0, 1], k = 2
// Output: 5
// Explanation: By flipping the zeroes at indices 4 and 6, we get the longest subarray from index 3 to 7 containing all 1’s.
// Input: arr[] = [1, 1], k = 2
// Output: 2
// Explanation: Since the array is already having the max consecutive 1's, hence we dont need to perform any operation. Hence the answer is 2
// Constraints:
// 1 <= arr.size() <= 105
// 0 <= k <= arr.size()
// 0 <= arr[i] <= 1

// User function Template for Java

class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int cnt = 0;
        int i = 0;

        for(int j=0; j<nums.length; j++) {
            if(nums[j] == 0) {
                cnt++;
            }

            while(cnt > k && i<=j) {
                if(nums[i] == 0) {
                    cnt--;
                }
                i++;
            }

            ans = Math.max(ans, j-i+1);
        }

        return ans;
    }
}

// TC: O(N)
// SC: O(1)