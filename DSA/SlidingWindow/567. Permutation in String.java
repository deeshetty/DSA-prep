/**
 * Problem: Permutation in String (LeetCode 567)
 * Link: https://leetcode.com/problems/permutation-in-string/
 *
 * Summary:
 *   Given two strings s1 and s2, return true if s2 contains any permutation of s1 as a
 *   substring (i.e., some permutation of s1 appears contiguously in s2).
 *
 * Examples:
 *   s1 = "ab", s2 = "eidbaooo"  -> true  ("ba" is a permutation)
 *   s1 = "ab", s2 = "eidboaoo"  -> false
 *
 * Constraints:
 *   1 <= s1.length, s2.length <= 10^4
 *   s1 and s2 consist of lowercase English letters
 *
 */

//Copilot gen
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0; i<n1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if(matches(freq1, freq2)) {
            return true;
        }

        for(int i=n1; i<n2; i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - n1) - 'a']--;

            if(matches(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] freq1, int[] freq2) {
        for(int i=0; i<26; i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}

//TC: O(N)
//SC: O(1)

//My Implementation

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m == 0) {
            return true;
        }

        if(m > n || n == 0) {
            return false;
        }

        int[] arr = new int[26];
        for(char ch : s1.toCharArray()) { //TC: O(M)
            arr[ch-'a']++;
        }

        int l=0, r=0;

        while(r < n) { //O(N)
            while(arr[s2.charAt(r) - 'a'] == 0 && l <= r) { //shrink
                arr[s2.charAt(l) - 'a']++;
                l++;
            }

            arr[s2.charAt(r) - 'a']--;
            if(arr[s2.charAt(r) - 'a'] >= 0) {
                if(r-l+1 == m) {
                    return true;
                }
            }
            r++;
        }

        return false;
    }
}

//TC: O(M+N)
//SC: O(1)

/*
 * Approach:
 *   Sliding window of size |s1| with frequency arrays (26). Update counts as window slides and
 *   compare arrays (or maintain a match counter) to detect a permutation in O(1) per step.
 *
 * Complexity:
 *   Time: O(|s2|)  Space: O(1) (26-size arrays)
 */

/*
 * Approach:
 *   Sliding window of size |s1| with frequency arrays (26). Update counts as window slides and
 *   compare arrays (or maintain a match counter) to detect a permutation in O(1) per step.
 *
 * Complexity:
 *   Time: O(|s2|)  Space: O(1) (26-size arrays)
 */