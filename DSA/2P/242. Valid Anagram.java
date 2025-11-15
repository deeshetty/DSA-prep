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

//Copilot gen
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int count : freq) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}

//My implementation

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for(char ch : s.toCharArray()) {
            counts[ch-'a']++;
        }

        for(char ch : t.toCharArray()) {
            if(counts[ch-'a'] == 0) {
                return false;
            }
            counts[ch-'a']--;
        }

        for(int count : counts) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}

//TC: O(N)
//SC: O(1) since freq array size is constant 26