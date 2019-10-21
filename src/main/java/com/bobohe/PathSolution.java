package com.bobohe;

/**
 * @author blackcat
 * @Description:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
   如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如[ab c e s f c s a d e e]是3*4矩阵，
   其包含字符串"bcced"的路径，但是矩阵中不包含“abcb”路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @create 2019-08-27 8:42
 */
public class PathSolution {


    public static void main(String[] args) {
        PathSolution pathSolution = new PathSolution();
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        int rows = 3;
        int cows = 4;
        char[] str = {'b','c','c','e','d'};
        pathSolution.hasPath(matrix,rows,cows,str);
    }



    /**
     * @param matrix  矩阵
     * @param rows  行
     * @param cows  列
     * @param str   包含字符串
     * @return
     */
    public boolean hasPath(char[] matrix,int rows, int cows, char[] str){

        boolean[] visited = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                if (hasPathCore(matrix,rows,cows,i,j,str,visited,0)){
                    for (int k = 0; k < visited.length; k++) {
                        if (visited[k]){
                            System.out.println(k);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix 矩阵
     * @param rows 行数
     * @param cows 列数
     * @param i 行位置
     * @param j 列位置
     * @param str 匹配字符
     * @param visited 已访问过的位置
     * @param idx 字符位置
     * @return
     */
    private boolean hasPathCore(char[] matrix, int rows, int cows, int i, int j, char[] str, boolean[] visited, int idx) {

        System.out.println("i=" + i + " j=" + j + " idx=" + idx);

        //矩阵位置
        int index = cows*i + j;

        if (i>=rows || j>=cows || i<0 || j<0){
            return false;
        }

        if (visited[index] || matrix[index] != str[idx]){
            return false;
        }

        if (idx == str.length-1){
            return true;
        }

        //剪枝 状态位
        visited[index] = true;
        //往下一位去匹配
        idx ++;
        if(hasPathCore(matrix,rows,cows,i+1,j,str,visited,idx)
                ||hasPathCore(matrix,rows,cows,i-1,j,str,visited,idx)
                ||hasPathCore(matrix,rows,cows,i,j+1,str,visited,idx)
                ||hasPathCore(matrix,rows,cows,i,j-1,str,visited,idx)){
            return true;
        }else {
            visited[index] = false;
            idx--;
            return false;
        }

    }



}
