/* Minimum Number Game
https://leetcode.com/problems/minimum-number-game/description/
You are given a 0-indexed integer array nums of even length and there is also an empty array arr. Alice and Bob decided to play a game where in every round Alice and Bob will do one move. The rules of the game are as follows:

Every round, first Alice will remove the minimum element from nums, and then Bob does the same.
Now, first Bob will append the removed element in the array arr, and then Alice does the same.
The game continues until nums becomes empty.
Return the resulting array arr.

Example 1:

Input: nums = [5,4,2,3]
Output: [3,2,5,4]
Explanation: In round one, first Alice removes 2 and then Bob removes 3. Then in arr firstly Bob appends 3 and then Alice appends 2. So arr = [3,2].
At the begining of round two, nums = [5,4]. Now, first Alice removes 4 and then Bob removes 5. Then both append in arr which becomes [3,2,5,4].
Example 2:

Input: nums = [2,5]
Output: [5,2]
Explanation: In round one, first Alice removes 2 and then Bob removes 5. Then in arr firstly Bob appends and then Alice appends. So arr = [5,2].

*/

import java.util.Arrays;
class Solution {
    public int[] numberGame(int[] nums) {
        
        int[] arr = new int[nums.length];

        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=2){
            if(i%2==1){
                arr[i-1]= nums[i];
            }
            arr[i] = nums[i-1];

        }

        return arr;
        
    }
}

/*
2. Count Elements with Maximum Frequency
https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.

Example 1:

Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.
Example 2:

Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.

*/

import java.util.HashMap;
class Solution {
    public int maxFrequencyElements(int[] nums) {

        HashMap<Integer,Integer> hm = new HashMap<>(); 

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        //Get max freq 
        int maxFreq = 0;
        for (int freq : hm.values()) {
            if(freq>maxFreq){
                maxFreq =freq;
            }
        }

        //count max freq occur
        int count=0;
        for(int freq: hm.values()){
            if(freq == maxFreq){
                count+=maxFreq;
            }
        }

    return count;
        
    }
}



/*
Search Insert Position
https://leetcode.com/problems/search-insert-position/description/

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return start;
        }
}