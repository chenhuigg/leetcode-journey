import util.ListNode;

import java.util.Stack;

public class Leetcode0445 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

            Stack<Integer> stack1 = new Stack();
            Stack<Integer> stack2 = new Stack();


            while (l1 != null) { // 将l1放入栈中
                stack1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) { // 将l2放入栈中
                stack2.push(l2.val);
                l2 = l2.next;
            }

            ListNode head = new ListNode(0); // 创建头节点
            int carry = 0; // 存储进位
            while (!stack1.empty() || !stack2.empty() || carry > 0) { // 从两个栈中各取一位
                int sum = carry;
                sum += stack1.isEmpty() ? 0 : stack1.pop();
                sum += stack2.isEmpty() ? 0 : stack2.pop();
                carry = sum / 10;

                // 构建 ListNode
                ListNode tmp = new ListNode(sum % 10);
                tmp.next = head.next;
                head.next = tmp;
            }

            return head.next;
        }
    }
}
