//https://neetcode.io/problems/min-cost-climbing-stairs

// You are given an array of integers cost where cost[i] is the cost of taking a step from the ith floor of a staircase. After paying the cost, you can step to either the (i + 1)th floor or the (i + 2)th floor.

// You may choose to start at the index 0 or the index 1 floor.

// Return the minimum cost to reach the top of the staircase, i.e. just past the last index in cost.

// Example 1:

// Input: cost = [1,2,3]

// Output: 2
// Explanation: We can start at index = 1 and pay the cost of cost[1] = 2 and take two steps to reach the top. The total cost is 2.

// Example 2:

// Input: cost = [1,2,1,2,1,1,1]

// Output: 4

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <= 1) {
            return 0;
        }

        int prev1 = 0;
        int prev2 = 0;

        for(int i=2; i<n+1; i++) {
            int cur = Math.min(
                prev1 + cost[i-1],
                prev2 + cost[i-2]
            );

            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}


// TC: O(N)
// SC: O(1)

//Bottom Up
class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <= 1) {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<n+1; i++) {
            dp[i] = Math.min(
                dp[i-1] + cost[i-1],
                dp[i-2] + cost[i-2]
            );
        }
        return dp[n];
    }
}


// TC: O(N)
// SC: O(N)

//Memoization
//has recursion stack space as well
class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <= 1) {
            return 0;
        }

        int[] dp = new int[n+1];
        return compute(cost, n, dp);
    }

    private int compute(int[] cost, int n, int[] dp) {
        if(n <= 1) {
            return dp[n] = 0;
        }

        if(dp[n] == 0) {
            dp[n] =  Math.min(
                compute(cost, n-1, dp) + cost[n-1],
                compute(cost, n-2, dp) + cost[n-2]
            );
        }

        return dp[n];
    }
}

//Recurion
class Solution0 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length <= 1) {
            return 0;
        }
        return compute(cost, cost.length);
    }

    private int compute(int[] cost, int n) {
        if(n <= 1) {
            return 0;
        }

        return Math.min(
            compute(cost, n-1) + cost[n-1],
            compute(cost, n-2) + cost[n-2]
        );
    }
}

