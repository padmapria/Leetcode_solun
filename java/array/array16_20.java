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
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

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

