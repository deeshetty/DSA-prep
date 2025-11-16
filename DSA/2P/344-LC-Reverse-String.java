/**
 * Problem: 344-LC-Reverse-String (LeetCode 344)
 * Link: https://leetcode.com/problems/reverse-string/
 *
 * Write a function that reverses a string given as a char array, modifying it in-place.
 *
 * Examples:
 *   Input: s = ["h","e","l","l","o"] -> Output: ["o","l","l","e","h"]
 *   Input: s = ["H","a","n","n","a","h"] -> Output: ["h","a","n","n","a","H"]
 */

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;

        int i = 0;
        int j = n - 1;

        while(i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

//TC: O(N)
// SC: O(1)