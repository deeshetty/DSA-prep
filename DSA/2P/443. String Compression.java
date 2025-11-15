// https://leetcode.com/problems/string-compression/description/

// Given an array of characters chars, compress it using the following algorithm:

// Begin with an empty string s. For each group of consecutive repeating characters in chars:

// If the group's length is 1, append the character to s.
// Otherwise, append the character followed by the group's length.
// The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

// After you are done modifying the input array, return the new length of the array.

// You must write an algorithm that uses only constant extra space.

// Note: The characters in the array beyond the returned length do not matter and should be ignored.

 

// Example 1:

// Input: chars = ["a","a","b","b","c","c","c"]
// Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
// Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
// Example 2:

// Input: chars = ["a"]
// Output: Return 1, and the first character of the input array should be: ["a"]
// Explanation: The only group is "a", which remains uncompressed since it's a single character.
// Example 3:

// Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
// Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
// Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 

// Constraints:

// 1 <= chars.length <= 2000
// chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.

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