/*
21. Lucky number

Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
*/

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
    
    List<Integer> luckyNumbers = new ArrayList<>();

    int[] m = new int[matrix.length];
    int[] n = new int[matrix[0].length];
       
    int i = 0;
    while(i<matrix.length){
        int min = matrix[i][0];
        for(int j=1;j<matrix[0].length;j++){
            if(min>matrix[i][j]){
                min = matrix[i][j];
            }
        }
        m[i]= min;
        i+=1;
    }
    
    int j=0;
    while(j<matrix[0].length){
        int max = matrix[0][j];
        for(int k=0;k<matrix.length;k++){
            if(max<matrix[k][j]){
                max = matrix[k][j];
            }
        }
        n[j]= max;
        j+=1;
    }

    for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < n.length; y++) {
                if (m[x] == n[y]) {
                    luckyNumbers.add(m[x]);
                }
            }
        }

    return luckyNumbers;
}

}



/*
25. Remove duplicates from sorted array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }

        int uniqueCount = 1; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }

        return uniqueCount;
        
    }
}


/*
Remove Element
https://leetcode.com/problems/remove-element/description/

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}