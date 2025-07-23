//https://leetcode.com/problems/partition-equal-subset-sum/

// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 

// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

//Memoization + Recursion
//TC: O(N * sum)
//SC: O(N * sum) + recursion stack space
class Solution {
    private int findTotal(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        return total;
    }

    private boolean isTargetFound(int idx, int sum, int[] nums, int n, int target, int[][] dp) {
        if(sum == 0) {
            return true;
        }

        if(idx <= 0) {
            return false;
        }

        if(dp[idx][sum] != 0) {
            return dp[idx][sum] == 1;
        }

        if(nums[idx-1] > sum) {
            dp[idx][sum] = isTargetFound(idx-1, sum, nums, n, target, dp) ? 1 : 0;
        } else {
            dp[idx][sum] = isTargetFound(idx-1, sum - nums[idx-1], nums, n, target, dp) || 
            isTargetFound(idx-1, sum, nums, n, target, dp) ? 1 : 0;
        }

        return dp[idx][sum] == 1;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        if(n < 2) {
            return false;
        }

        int total = findTotal(nums);

        if(total % 2 != 0) {
            return false;
        }

        int targetValue = total/2;

        int[][] dp = new int[n+1][targetValue+1];

        return isTargetFound(n, targetValue, nums, n, total/2, dp);
    }
}

//////
//Tabulation
//TC: O(N * sum)
//SC: O(N * sum)
class Solution {
    private int findTotal(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        return total;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        if(n < 2) {
            return false;
        }

        int total = findTotal(nums);

        if(total % 2 != 0) {
            return false;
        }

        int target = total/2;

        boolean[][] dp = new boolean[n][target+1];

        for(int i=0; i<n; i++) {
            dp[i][0] = true;
        }

        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i=1; i<n; i++) {
            for(int sum=1; sum<=target; sum++) {
                if(nums[i] > sum) {
                    dp[i][sum] = dp[i-1][sum];
                } else {
                    dp[i][sum] = dp[i-1][sum] || dp[i-1][sum-nums[i]];
                }
            }
        }

        return dp[n-1][target];
    }
}

//////
//Optimized solution using 2 arrays, prev, cur
//TC: O(N * sum)
//SC: O(sum) ; 2 arrays
class Solution {
    private int findTotal(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        return total;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        if(n < 2) {
            return false;
        }

        int total = findTotal(nums);

        if(total % 2 != 0) {
            return false;
        }

        int sum = total/2;

        boolean[] prev = new boolean[sum+1];
        boolean[] curr = new boolean[sum+1];

        prev[0] = true;
        
        if(nums[0] <= sum) {
            prev[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i]) {
                    curr[j] = prev[j];
                }
                else {
                    curr[j]
                        = prev[j] || prev[j - nums[i]];
                }
            }

            System.arraycopy(curr, 0, prev, 0, sum + 1);
        }
        return prev[sum];
    }
}
//////

//Most optimized solution with a single array
//TC: O(N * sum)
//SC: O(sum)
class Solution {
    private int findTotal(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        return total;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        if(n < 2) {
            return false;
        }

        int total = findTotal(nums);

        if(total % 2 != 0) {
            return false;
        }

        int sum = total/2;

        boolean[] prev = new boolean[sum+1];

        prev[0] = true;
        
        if(nums[0] <= sum) {
            prev[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j < nums[i]) {
                    prev[j] = prev[j];
                }
                else {
                    prev[j]
                        = prev[j] || prev[j - nums[i]];
                }
            }
        }
        return prev[sum];
    }
}