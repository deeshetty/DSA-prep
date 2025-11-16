/**
 * Problem: 424-LC-Longest Repeating Character Replacement (LeetCode 424)
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given a string s and integer k, return the length of the longest substring containing the same
 * letter after at most k character replacements.
 *
 * Examples:
 *   s = "ABAB", k = 2 -> 4
 *   s = "AABABBA", k = 1 -> 4
 *
 * Constraints:
 *   1 <= s.length <= 10^5
 *   s consists of only uppercase English letters
 */

class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() <=1 || k == s.length()) {
            return s.length();
        }

        int low = 0;
        int high = 0;
        int[] arr = new int[26]; //only uppercase characters
        int ans = 0;
        int max = 0;

        while(high < s.length()) {
            arr[s.charAt(high) - 'A']++;
            max = Math.max(max, arr[s.charAt(high) - 'A']);
            while((high - low + 1) - max > k) {
                arr[s.charAt(low) - 'A']--;
                low++;  //here we do not update max, but its okay as it doesnt impact the answer, updating max would mean scanning arr again to find the maximum
            }
            ans = Math.max(ans, high-low+1);
            high++;
        }

        return ans;
    }
}

// TC:O(N)
// SC:O(1) as we are using a fixed size array of 26 elements for uppercase letters.

/*
 * Approach:
 *   Sliding window with tracking of most frequent character count inside the window. Expand right and shrink left when
 *   window_size - max_count > k.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */