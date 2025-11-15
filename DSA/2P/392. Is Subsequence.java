/**
 * Problem: Is Subsequence (LeetCode 392)
 * Link: https://leetcode.com/problems/is-subsequence/
 *
 * Summary:
 *   Given two strings s and t, return true if s is a subsequence of t, otherwise false.
 *
 * Definition:
 *   A subsequence is formed by deleting zero or more characters from the original string
 *   without changing the relative order of the remaining characters. Example: "ace" is a
 *   subsequence of "abcde" but "aec" is not.
 *
 * Examples:
 *   s = "abc", t = "ahbgdc" -> true
 *   s = "axc", t = "ahbgdc" -> false
 *
 * Constraints:
 *   0 <= s.length <= 100
 *   0 <= t.length <= 10^4
 *   s and t only contain lowercase English letters
 *
 * Approach:
 *   Two-pointer greedy scan: advance pointer on t until matching characters for s are found.
 *   Time: O(|t|)  Space: O(1)
 *
 * Follow-up hint:
 *   If there are many s queries, preprocess t to build a next-index table for fast lookups.
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.isEmpty()) {
            return true;
        }

        if(t == null || t.isEmpty()) {
            return false;
        }

        int m = s.length();
        int n = t.length();

        if(m > n) {
            return false;
        }

        int l = 0, r = 0;

        while(l < m && r < n) {
            if(s.charAt(l) == t.charAt(r)) {
                l++;
            }
            r++;
        }

        return l == m;
    }
}

//TC: O(n) where n is length of t
//SC: O(1)