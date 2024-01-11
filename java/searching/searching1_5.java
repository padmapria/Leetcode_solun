/*
1. Running Sum of 1d Array
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 
*/

class Solution {
    public int arrangeCoins(int n) {

        int rows =0;
        while(n>0){
            
            if(n<=rows){
                return rows;
            }
               
            rows+=1;
            n= n-rows;
        }

        return rows;
        
    }
}



/*
3. Check If N and Its Double Exist
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 
Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.

*/
class Solution {
    public boolean checkIfExist(int[] arr) {
        
        for(int i=0;i<arr.length;i++){
            int times_2 = arr[i]*2;
            for(int j=0;j<arr.length;j++){
                if( i!=j && times_2 ==arr[j]){
                    return true;
                }
            }
        }
        return false;
        
    }
}

