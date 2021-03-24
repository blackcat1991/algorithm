//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
// 示例 1：
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 示例 2：
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 提示：
// m == matrix.length
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// Related Topics 数组
// 👍 693 👎 0


package com.bobohe.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int row = 0;
        int column = 0;
        int total = rows * columns;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            result.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCloum = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCloum < 0 || nextCloum >= columns || visited[nextRow][nextCloum]) {
                directionIndex = (directionIndex + 1)%4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}