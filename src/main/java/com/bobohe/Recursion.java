package com.bobohe;

/**
 * @author blackcat
 * @Description:递归
 * @create 2019-02-18 22:20
 */
public class Recursion {
    public static void main(String[] args) throws Exception {
        System.out.println(new Recursion().recursionOne(10));
    }

    int deep; //递归深度

    /**
     * 递归公式 f(n) = f(n-1) + 1, 终止条件f(1)=1
     * @param n
     * @return
     */
    public int recursionOne(int n) throws Exception {
        deep++;
        if (deep>1000){
            throw new Exception("the recursion is too deep!");
        }
        if (n==1){
            return 1;
        }else {
            return recursionOne(n-1) + 1;
        }
    }

    /**
     * 递归公式 f(n) = f(n-1) + f(n-2);终止条件 f(1)=1 f(2)=2
     * @param n
     * @return
     */
    public int recursionTwo(int n){
        return 0;
    }

}
