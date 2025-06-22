// https://leetcode.com/problems/longest-repeating-character-replacement/description/

// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
 

// Constraints:

// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length

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
                low++;  //here we do not update max, but its okay as it doesnt impact the answer, updating max would mean scanning arr again to fine the maximum
            }
            ans = Math.max(ans, high-low+1);
            high++;
        }

        return ans;
    }
}

TC:O(N)
SC:O(1)