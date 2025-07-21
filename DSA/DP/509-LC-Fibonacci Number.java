//https://leetcode.com/problems/fibonacci-number/

// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
// such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

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

//Optimized
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
//TC: O(n)
//SC: O(1)

//Tabulation
class Solution {
    public int fib(int n) {
        if(n == 0 || n ==1) {
            return n;
        }
        
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
//TC: O(n)
//SC: O(n) for dp array

//Recursion with Memoization
class Solution {
    private int compute(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return dp[n] = n;
        }

        if(dp[n] == 0) {
            return dp[n] = compute(n-1, dp) + compute(n-2, dp);
        }

        return dp[n];
    }

    public int fib(int n) {
        int[] dp = new int[n+1];

        return compute(n, dp);
    }
}
//TC: O(n)
//SC: O(n) for dp array + O(n) for recursion stack

//Recursion
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }
}
//TC: O(2^n)
//SC: O(n) for recursion stack