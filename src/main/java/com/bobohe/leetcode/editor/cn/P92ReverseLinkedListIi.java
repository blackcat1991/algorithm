//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 示例 1：
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 示例 2：
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 提示：
// 链表中节点数目为 n
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 进阶： 你可以使用一趟扫描完成反转吗？
// Related Topics 链表 
// 👍 791 👎 0

package com.bobohe.leetcode.editor.cn;
//Java：反转链表 II
public class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        ListNode node1 = new P92ReverseLinkedListIi().new ListNode(1);
        ListNode node2 = new P92ReverseLinkedListIi().new ListNode(2);
        ListNode node3 = new P92ReverseLinkedListIi().new ListNode(3);
        ListNode node4 = new P92ReverseLinkedListIi().new ListNode(4);
        ListNode node5 = new P92ReverseLinkedListIi().new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution.reverseBetween(node1,2,4);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/*  Definition for singly-linked list.*/
class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode guard = dummyHead;
        ListNode point = dummyHead.next;
        int step = 0;
        while (step < left-1) {
            guard = guard.next;
            point = point.next;
            step++;
        }
        for (int i = 0; i < right-left; i++) {
            ListNode remove = point.next;
            point.next = point.next.next;
            remove.next = guard.next;
            guard.next = remove;

        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}