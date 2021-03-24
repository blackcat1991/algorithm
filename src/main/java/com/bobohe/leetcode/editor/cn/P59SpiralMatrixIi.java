//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
// 示例 1：
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 示例 2：
//输入：n = 1
//输出：[[1]]
// 提示：
// 1 <= n <= 20
// Related Topics 数组
// 👍 362 👎 0

package com.bobohe.leetcode.editor.cn;
//Java：螺旋矩阵 II
public class P59SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
        solution.generateMatrix(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] reslult = new int[n][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int row = 0;
        int column = 0;
        int dirctionIndex = 0;
        for (int i = 0; i < n*n; i++) {
            reslult[row][column] = i+1;
            int nextRow = row + directions[dirctionIndex][0];
            int nextColumn = column + directions[dirctionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >=n || reslult[nextRow][nextColumn]!=0){
                dirctionIndex = (dirctionIndex+1)%4;
            }
            row = row + directions[dirctionIndex][0];
            column = column + directions[dirctionIndex][1];
        }
        return reslult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}