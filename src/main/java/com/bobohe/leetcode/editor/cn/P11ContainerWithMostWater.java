package com.bobohe.leetcode.editor.cn;
//Java：盛最多水的容器
public class P11ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        solution.maxArea(height);
        // TO TEST
    }
    //给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例: 
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49 
// Related Topics 数组 双指针
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i=0; i<height.length; i++){
            int maxValue = 0;
            int minHeight = 0;
            for (int j=height.length-1; j>i; j--){
                minHeight = Math.min(height[j],height[i]);
                maxArea = (j - i)*minHeight>maxArea?(j -i)*minHeight:maxArea;
            }
        }
        return  maxArea;
    }


    /*int maxArea = 0;
        for (int i = 0; i < height.length-1; i++) {
        int maxHeight = 0;
        for (int j = height.length-1; j >= i+1; j--){
            if (height[j] > maxHeight) {
                maxArea = Math.max(maxArea,(j-i)*Math.min(height[i],height[j]));
                maxHeight = height[j];
                if (maxHeight >= height[i]){
                    break;
                }
            }

        }
    }
    return maxArea;*/

}
//leetcode submit region end(Prohibit modification and deletion)

}