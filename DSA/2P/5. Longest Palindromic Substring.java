/**
 * Problem: 5. Longest Palindromic Substring (LeetCode 5)
 * Link: https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Examples:
 *   Input: s = "babad" -> Output: "bab" ("aba" is also valid)
 *   Input: s = "cbbd"  -> Output: "bb"
 *
 * Constraints:
 *   1 <= s.length <= 1000
 *   s consists of only digits and English letters.
 */

class Solution {

    // Expand around center (l, r) and return length of palindrome
    private int expand(String s, int l, int r) {
        int n = s.length();

        // Expand outward while left == right
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        // When loop stops, l and r are 1 step beyond the palindrome
        return r - l - 1; // correct palindrome length
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Case 1: odd-length palindrome centered at i
            int len1 = expand(s, i, i);

            // Case 2: even-length palindrome centered between i and i+1
            int len2 = expand(s, i, i + 1);

            // Longer of the two palindromes
            int len = Math.max(len1, len2);

            // If new palindrome is longer than current best
            if (len > end - start + 1) {

                // Update start and end using derived formulas
                // (derived from expansion behavior)
                start = i - (len - 1) / 2;
                end   = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }
}

// TC: O(n^2) -> for each character, we may expand up to n times
// SC: O(1)

// Center
// Core idea:

// Every palindrome can be expanded from its center.
// There are 2 types of centers:

// Odd-length palindromes → center at a character
// Example: "aba" → center = 'b'

// Even-length palindromes → center between two characters
// Example: "abba" → center between the two 'b'

// So for every index i, check:

// expand from (i, i) → odd

// expand from (i, i+1) → even

// Take the longer palindrome.

// Why it works

// Because a palindrome mirrors around its center.
// If you expand outward while characters match,
// you get the maximum palindrome for that center.