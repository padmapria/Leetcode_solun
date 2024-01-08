/*
6. How Many Numbers Are Smaller Than the Current Number
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] arr = new int[nums.length]; 
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    count+=1;
                }
                
            }
            arr[i]= count;
        }
     return arr;   
    }

}

/*
7. Create Target Array in the Given Order
Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

Example 1:

Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
*/

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int index_to_insert = index[i];
      int value = nums[i];
      
      if (i > index_to_insert) {
        for (int j = i; j>index_to_insert; j -= 1) {
          
          result[j] = result[j - 1];
        }
      }

      result[index_to_insert] = value;

    }   
    return result;
       
    }
}


/*
8. Check if the Sentence Is Pangram
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

*/
import java.util.Set;
import java.util.HashSet;
class Solution {
    public boolean checkIfPangram(String sentence) {
        
        boolean retVal = false;
        Set<Character> set = new HashSet();
        for(char c: sentence.toCharArray()){
            set.add(c);
        }

        if(set.size()==26){
            retVal = true;
        }

        return retVal;

    }
}


/*
9. Count Items Matching a Rule
You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.

Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
*/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count=0;
        
        for(int row=0; row<items.size(); row++){
            if( 
            (ruleKey.equals("type") && items.get(row).get(0).equals(ruleValue)) ||
            (ruleKey.equals("color") && items.get(row).get(1).equals(ruleValue)) ||
            (ruleKey.equals("name") && items.get(row).get(2).equals(ruleValue))
            ){
                count+=1;
            }

            }
            return count;
        }
}


/*10. Find the Highest Altitude
There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
*/

class Solution {
    public int largestAltitude(int[] gain) {

        int init= 0;
        int [] alt = new int[gain.length+1];
        alt[0] = 0;
        for(int i=0;i<gain.length;i++){
            alt[i+1] = alt[i]+ gain[i];
        }
        
        int max = alt[0];
        for(int i=1;i<alt.length;i++){
            if(alt[i]>max){
                max = alt[i];
            }
        }

        return max;
    }
}