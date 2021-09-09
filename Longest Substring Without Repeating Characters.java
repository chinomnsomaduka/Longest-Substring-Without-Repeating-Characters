/**
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0
**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        char[] chars = s.toCharArray();
        
        /* chars[begin..curr-1] dose not contain repeating characters.
         * if chars[curr] does not exist in chars[begin..curr-1], the non-repeating chars increase, then set next as curr
         * if chars[curr] is same as chars[i] (begin <= i <= curr - 1), then the non-repeating chars becomes chars[i+1..curr], ie. 'begin' becomes i+1
        */
        int begin = 0;
        int curr = 0;
        while (curr < s.length()) {
            for (int i = begin; i < curr; i++) {
                if (chars[i] == chars[curr]) {
                    int currLen = curr - begin;
                    maxLen = maxLen < currLen ? currLen : maxLen;
                    begin = i + 1;
                    break;
                }
            }
            curr ++;
        }
        
        int lastLen = curr - begin;
        maxLen = maxLen < lastLen ? lastLen : maxLen;
        return maxLen;
    }
}