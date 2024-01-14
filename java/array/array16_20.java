/*
16. Add to Array-Form of Integer

The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Example 1:    

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
*/

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
      List<Integer> li = new ArrayList();
        for(int i=num.length-1;i>=0;i--){
            int sum = num[i] + k;
            num[i]= sum%10;
            System.out.println(num[i]);
            k=sum/10;
        }

        while(k>0){
            li.add(0,k%10);
            k= k/10;
        }

        for(int i=0;i<num.length;i++){
            li.add(num[i]);
        }

        return li;
    }
}
/*
17. You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
*/

class Solution {
    public int maximumPopulation(int[][] logs) {
        //1950 to 2050 is 101
        // 1950 to 2050 is 101 years
        int[] population = new int[101];

        for (int i = 0; i < logs.length; i++) {
            int birthYearIndex = logs[i][0] - 1950;
            int deathYearIndex = logs[i][1] - 1950;

            population[birthYearIndex] += 1;
            if (deathYearIndex < 100) {
                // Exclude the year of death
                population[deathYearIndex] -= 1;
            }
        }

        int max = population[0];
        int maxYear = 1950;

        for (int i = 1; i < population.length; i++) {
            population[i] += population[i - 1];
            if (max < population[i]) {
                max = population[i];
                maxYear = i + 1950;
            }
        }

        return maxYear;
        
    }
}

/*
19. Two sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

*/
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] index_arr = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            
            int diff =  target-nums[i];

            if (hm.containsKey(diff)) {
                index_arr[0]=  hm.get(diff);
                index_arr[1]  = i;
            }
            hm.putIfAbsent(nums[i],i);
        }
        return index_arr;
        
    }
}


/*
20. Find N Unique Integers Sum up to Zero
Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:
*/
class Solution {
    public int[] sumZero(int n) {
        int [ ]arr = new int[n];

        if(n==1){
           arr[0] = 0;
        }

          if(n%2!=0){
            arr[n/2]= 0;
        }
        
        for(int i=0;i<(n/2);i++){
            arr[i] = i+1;
            arr[n-i-1]= -(arr[i]);
        }

        return arr;
    }
}