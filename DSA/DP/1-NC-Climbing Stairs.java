/**
 * Climbing Stairs
 * https://neetcode.io/problems/climbing-stairs
 *
 * You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.
 *
 * Return the number of distinct ways to climb to the top of the staircase.
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation:
 * 1 + 1 = 2
 * 2 = 2
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation:
 * 1 + 1 + 1 = 3
 * 1 + 2 = 3
 * 2 + 1 = 3
 * Constraints:
 * 1 <= n <= 30
 */

class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int cur = 0;
        int prev1= 1;
        int prev2 = 1;

        for(int i=2; i<=n; i++) {
            cur = prev1 + prev2;
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
    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

// TC: O(N)
// SC: O(N)

//Memoization
//has recursion stack space as well
class Solution1 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if(dp[n] == 0) {
            dp[n] = climbStairs(n-1) + climbStairs(n-2);
        }

        return dp[n]
    }
}


//Recurion
class Solution0 {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}


// The Core Idea
// Think of it like this: "To reach step n, you can either come from step n-1 (take 1 step) or from step n-2 (take 2 steps)."

// So, the number of ways to reach step n = ways to reach n-1 + ways to reach n-2.

// Why Does This Work?
// Imagine you're at the bottom and want to reach step 5:

// To reach step 5, you must have been at either:

// Step 4 (then take 1 step) → all ways to reach step 4
// Step 3 (then take 2 steps) → all ways to reach step 3
// That's it! No other way exists because you can only take 1 or 2 steps at a time.