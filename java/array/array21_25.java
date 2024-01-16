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