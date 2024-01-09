/*
11. Flipping an Image

Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
 
Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // Get the number of rows and columns in the image
        int rows = image.length;
        int cols = image[0].length;

        // Iterate through each row in the image
        for(int i = 0; i < rows; i++){
            // Iterate through the first half of each row
            for(int j = 0; j < (cols + 1) / 2; j++){
                // Swap and invert elements at the beginning and end of the row simultaneously
                int beg = image[i][j] ^ 1;
                image[i][j] = image[i][cols - 1 - j] ^ 1;
                image[i][cols - 1 - j] = beg;
            }
        }
        
        return image;
    }
}

/*
12. Cells with Odd Values in a Matrix
There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.

For each location indices[i], do both of the following:

Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

Example 1:
Input is a 3*2 array of 0s
Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
*/

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // Initialize a matrix with dimensions m x n
        int[][] matrix = new int[m][n];
        
        // Initialize a counter to keep track of odd values in the matrix
        int count = 0;

        // Iterate through each set of indices
        for (int a = 0; a < indices.length; a++) {
            // Get the current set of indices
            int[] index = indices[a];

            // Increment the values in the entire row specified by the second index
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]] += 1;
            }

            // Increment the values in the entire column specified by the first index
            for (int j = 0; j < n; j++) {
                matrix[index[0]][j] += 1;
            }
        }

        // Iterate through each element in the matrix & if the value is odd to incrment
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix[i][j]) % 2 == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }
}

/*
13. Matrix Diagonal Sum
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
*/



/*
14.Find Numbers with Even Number of Digits

Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
Example 2:
*/

class Solution {
    public int findNumbers(int[] nums) {

        int even_count=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];

            int digit_count=0;
            for(int j=num;j>0;j/=10){
                digit_count+=1;
            }

            if(digit_count%2==0){
                even_count+=1;
            }
        }
        return even_count;
    }
}


/*15. Transpose Matrix
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
*/

class Solution {
    public int[][] transpose(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length
        int [][] new_matrix = new int[cols] [rows];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                new_matrix[j][i] = matrix[i][j];
            }
        }
        
        return new_matrix;
    }
}