"""
https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 
Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 
"""

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # initalize 2 dict and add corresponding items to it
        s_dict = {}
        t_dict = {}

        for i in s:
            s_dict[i]  = s_dict.get(i,0) + 1
        for j in t:
            t_dict[j] = t_dict.get(j,0) + 1

        # compare if contents of the dictionary are same
        return s_dict == t_dict
        
