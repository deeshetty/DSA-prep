// https://leetcode.com/problems/factorial-trailing-zeroes/description/

// Given an integer n, return the number of trailing zeroes in n!.

// Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

// Example 1:

// Input: n = 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.
// Example 2:

// Input: n = 5
// Output: 1
// Explanation: 5! = 120, one trailing zero.
// Example 3:

// Input: n = 0
// Output: 0
 

// Constraints:

// 0 <= n <= 104

class Solution {
    private int factorial(int n) {
        if(n == 1) {
            return 1;
        }

        return n * factorial(n-1);
    }

    public int trailingZeroes(int n) {
        if(n <= 1) {
            return 0;
        }

        int factorialValue = factorial(n);
        System.out.println(factorialValue);

        String value = String.valueOf(factorialValue);
        int ans = 0;
        
        for(char c : value.toCharArray()) {
            if(c == '0') {
                ans++;
            }
        }
        
        return ans;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n) for the recursion stack

//Efficient 
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while(n > 0) {
            n = n/5;
            count += n;
        }

        return count;
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(1)

// Why do trailing zeroes appear in factorials?
// A trailing zero is created every time you multiply by 10.
// 10 = 2 × 5, so you need both a 2 and a 5 as factors.
// In any factorial, there are usually more 2s than 5s, so the number of 5s determines the number of trailing zeroes.
// How do we count the number of 5s in n!?
// Every multiple of 5 (like 5, 10, 15, ...) contributes at least one 5.
// Numbers like 25, 125, etc., contribute more than one 5 (because 25 = 5×5, 125 = 5×5×5).