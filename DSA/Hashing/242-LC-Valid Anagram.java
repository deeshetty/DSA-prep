// https://leetcode.com/problems/valid-anagram/description/

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true

// Example 2:

// Input: s = "rat", t = "car"

// Output: false

 

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for(char c : s.toCharArray()) {
            arr[c-'a']++;
        }

        for(char c : t.toCharArray()) {
            if(arr[c-'a'] == 0) {
                return false;
            }

            arr[c-'a']--;
        }

        for(int freq : arr) {
            if(freq != 0) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(N)
// SC: O(1)