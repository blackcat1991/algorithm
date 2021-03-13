//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
//
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
//
// 示例 1:
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true
//
// 示例 2:
//
// 输入: "1,#"
//输出: false
//
//
// 示例 3:
//
// 输入: "9,#,#,1"
//输出: false
// Related Topics 栈
// 👍 238 👎 0


package com.bobohe.leetcode.editor.cn;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

//Java：验证二叉树的前序序列化
public class P331VerifyPreorderSerializationOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new P331VerifyPreorderSerializationOfABinaryTree().new Solution();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public boolean isValidSerialization(String preorder) {
            if (preorder == null || "".equals(preorder)) {
                return false;
            }
            Deque<String> stack = new LinkedList<>();
            String[] preorderArr = preorder.split(",");
            for (int i = 0; i < preorderArr.length; i++) {
                stack.push(preorderArr[i]);
                while (stack.size()>=3) {
                    String popOne = stack.pop();
                    String popTwo = stack.pop();
                    if ("#".equals(popOne) && "#".equals(popTwo)) {
                        if ("#".equals(stack.peek())) {
                            return false;
                        }
                        stack.pop();
                        stack.push("#");
                    } else {
                        stack.push(popTwo);
                        stack.push(popOne);
                        break;
                    }
                }
            }
            return stack.size()==1 && "#".equals(stack.pop());
        }
    }*/
    class Solution {
        private static final String NULL = "#";

        public boolean isValidSerialization(String preorder) {
            //槽位
            int slot = 1;
            String[] preorderArr = preorder.split(",");
            for (int i = 0; i < preorderArr.length; i++) {
                if (slot==0) {
                    return false;
                }
                if (preorderArr[i].equals(NULL)) {
                    slot--;
                } else {
                    slot ++;
                }
            }
            return slot == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}