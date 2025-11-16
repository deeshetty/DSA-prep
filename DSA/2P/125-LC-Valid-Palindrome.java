/**
 * Problem: 125-LC-Valid-Palindrome (LeetCode 125)
 * Link: https://leetcode.com/problems/valid-palindrome/
 *
 * A phrase is a palindrome after lowercasing and removing non-alphanumeric characters.
 * Given s, return true if it is a palindrome.
 *
 * Examples:
 *   Input: s = "A man, a plan, a canal: Panama" -> true
 *   Input: s = "race a car" -> false
 *   Input: s = " " -> true
 *
 * Constraints:
 *   1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 */

class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        if(n == 0 || n == 1) {
            return true;
        }

        int i = 0;
        int j = n - 1;

        while(i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}

//TC: O(N)
// SC: O(1)

/*
 * Approach:
 *   Two-pointer scan with alphanumeric filtering and lowercasing.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */