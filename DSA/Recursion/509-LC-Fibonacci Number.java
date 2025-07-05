// https://leetcode.com/problems/fibonacci-number/description/

// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

// F(0) = 0, F(1) = 1
// F(n) = F(n - 1) + F(n - 2), for n > 1.
// Given n, calculate F(n).

 

// Example 1:

// Input: n = 2
// Output: 1
// Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// Example 2:

// Input: n = 3
// Output: 2
// Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// Example 3:

// Input: n = 4
// Output: 3
// Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

// Constraints:

// 0 <= n <= 30

//Recursion
class Solution {
    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }
}

// Time Complexity: O(2^n) - Exponential time complexity due to the recursive calls.
// Space Complexity: O(n) - The maximum depth of the recursion stack is n, which is the height of the recursion tree.


//Memoization
// Time Complexity: O(n) - Each Fibonacci number is computed only once and stored in the
// memoization array, leading to linear time complexity.
// Space Complexity: O(n) - The memoization array stores the Fibonacci numbers up to n,
// and the recursion stack can go up to n levels deep in the worst case.
class Solution {
    private int compute(int n, int[] dp) {
        if(n <= 1) {
            return dp[n] = n;
        }

        if(dp[n] == -1) {
            return dp[n] = compute(n-1, dp) + compute(n-2, dp);
        }

        return dp[n];
    }

    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++) {
            dp[i] = -1;
        }

        return compute(n, dp);
    }
}

//Tabulation
// Time Complexity: O(n) - The loop iterates n times to fill the dp array.
// Space Complexity: O(n) - The dp array stores the Fibonacci numbers up to n.
class Solution {
    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

//Optimization
// Time Complexity: O(n)
// Space Complexity: O(1) - Only two variables are used to store the previous two Fibonacci numbers.
class Solution {
    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        int prev = 0;
        int cur = 1;

        for(int i=2; i<=n; i++) {
            int temp = cur + prev;
            prev = cur;
            cur = temp;
        }

        return cur;
    }
}