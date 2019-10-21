package com.bobohe;

/**
 * @author blackcat
 * @Description:  回溯算法？
  地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
  但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
  因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @create 2019-08-29 20:11
 */
public class RobotSolution {

    public int moveCount(int rows,int cows,int k){
        if (rows<=0 || cows<=0 || k <0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cows];
        return moveCountCore(rows,cows,0,0,visited,k);
    }

    private int moveCountCore(int rows, int cows, int i, int j, boolean[][] visited, int k) {

        if(i<0 || j<0 || i>rows || j>cows || visited[i][j] || compareSum(k,i,j)){
            return 0;
        }

        visited[i][j] = true;

        //递归这个位置的上、下、左、右，返回递归的上、下、左、右再加1（加上自己）的和
        return moveCountCore(rows,cows,i-1,j,visited,k)
                + moveCountCore(rows,cows,i+1,j,visited,k)
                + moveCountCore(rows,cows,i,j+1,visited,k)
                + moveCountCore(rows,cows,i,j-1,visited,k) +1;
    }

    //不能进入行坐标和列坐标的数位之和大于k的格子
    private boolean compareSum(int k, int i, int j){
        int sum = 0;
        while(i != 0){
            sum += i%10;
            i = i/10;
        }
        while(j != 0){
            sum += j%10;
            j = j/10;
        }
        return sum > k;
    }

}
