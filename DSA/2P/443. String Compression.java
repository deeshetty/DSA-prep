/**
 * Problem: 443. String Compression (LeetCode 443)
 * Link: https://leetcode.com/problems/string-compression/
 *
 * Given an array of characters chars, compress it using the following algorithm: groups of
 * consecutive repeating characters are replaced by the character followed by the group's length
 * (if >1). Return the new length after compression.
 *
 * Examples:
 *   Input: chars = ["a","a","b","b","c","c","c"] -> Output: 6, ["a","2","b","2","c","3"]
 *   Input: chars = ["a"] -> Output: 1
 *   Input: chars = ["a", repeated 12 times of 'b'] -> Output: 4, ["a","b","1","2"]
 *
 * Constraints:
 *   1 <= chars.length <= 2000
 */

//My Implementation
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n <= 1) {
            return n;
        } 

        int left=0, right=0, cur=chars[0];
        int i = 0;

        while(right < n) {
            if(chars[right] != cur) {
                int len = right-left;

                chars[i++] = chars[left];

                if(len > 1) {
                    for(char ch : Integer.toString(len).toCharArray()) {
                        chars[i++] = ch;
                    }
                }

                cur = chars[right];
                left = right;
            }
            right++;
        }

        int len = right-left;

        chars[i++] = chars[left];

        if(len > 1) {
            for(char ch : Integer.toString(len).toCharArray()) {
                chars[i++] = ch;
            }
        }

        return i;
    }
}

//TC: O(N)
//SC: O(1)

//Copilot Generated
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int writeIdx = 0;
        int readIdx = 0;

        while(readIdx < n) {
            char currentChar = chars[readIdx];
            int count = 0;

            while(readIdx < n && chars[readIdx] == currentChar) {
                readIdx++;
                count++;
            }

            // Write the character
            chars[writeIdx++] = currentChar;

            // Write the count if greater than 1
            if(count > 1) {
                String countStr = Integer.toString(count);
                for(char c : countStr.toCharArray()) {
                    chars[writeIdx++] = c;
                }
            }
        }

        return writeIdx;
    }
}

/*
 * Approach:
 *   Two-pointer read/write scan; count repeats and write the character and its count when done.
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(1)
 */