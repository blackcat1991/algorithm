package com.bobohe.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Java：两数之和
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
    }
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int[] res = null;
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++){
            Integer other = maps.get(new Integer(target-nums[j]));
            if (other!=null && other!=j){
                res = new int[2];
                res[0]=j;
                res[1]=maps.get(new Integer(target-nums[j]));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}