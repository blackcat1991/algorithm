//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
// 整数除法仅保留整数部分。
// 示例 1：
//输入：s = "3+2*2"
//输出：7
// 示例 2：
//输入：s = " 3/2 "
//输出：1
// 示例 3：
//输入：s = " 3+5 / 2 "
//输出：5
// 提示：
// 1 <= s.length <= 3 * 105
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// Related Topics 栈 字符串
// 👍 323 👎 0


package com.bobohe.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//Java：基本计算器 II
public class P227BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        solution.calculate("3+2*2");
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        int result = 0;
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (Character.isDigit(cur)) {
                num = num*10 + (chars[i] - '0');
            }

            if ((!Character.isDigit(cur) && cur != ' ') || i == chars.length-1){
                if (preSign=='+') {
                    stack.push(num);
                }
                if (preSign=='-') {
                    stack.push(-num);
                }
                if (preSign=='*') {
                    stack.push(stack.pop()*num);
                }
                if (preSign=='/') {
                    stack.push(stack.pop()/num);
                }
                preSign = cur;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}