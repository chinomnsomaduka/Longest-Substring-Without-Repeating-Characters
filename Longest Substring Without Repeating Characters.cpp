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
public:
    int lengthOfLongestSubstring(string s)
    {
        ios::sync_with_stdio(false);
        cin.tie(nullptr);

        vector<bool> data(256, false);
        int start = 0;
        int ans = 0;
        int len = s.length();
        for(int i = 0; i<len; ++i)
        {
            if(data[s[i]])
            {
                ans = max(ans, i - start);
                while(s[start] != s[i])
                {
                    data[s[start]] = false;
                    ++start;
                }
                ++start;
            }
            else
                data[s[i]] = true;
        }

        return max(ans, len - start);
    }
};

/* 
Time: O(n)
Space: O(1)
*/

