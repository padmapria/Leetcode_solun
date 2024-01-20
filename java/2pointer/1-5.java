/*
Missing number
https://leetcode.com/problems/missing-number/description/
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
*/


import java.util.Arrays;
class Solution {
    public int missingNumber(int[] nums) {
        int ret =nums.length;

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return ret;
    }
}

/*
2. Index of the first occurrence in a string
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

*/

class Solution {
    public int strStr(String haystack, String needle) {

        int ret_val = -1;
        int len = needle.length();
        char[] arr = haystack.toCharArray();

        for (int i = 0; i <= arr.length - len; i++) {
            if (ret_val == -1) {
                if (arr[i] == needle.charAt(0)) {
                    if (haystack.substring(i, i + len).equals(needle)) {
                        ret_val = i;
                        break; 
                    }
                }
            }
        }
        return ret_val;

    }
}