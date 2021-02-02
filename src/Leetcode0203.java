import util.ListNode;

public class Leetcode0203 {

    /*class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode node = new ListNode(0);
            node.next = head;

            ListNode pre = node;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }

            return node.next;
        }
    }*/

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode node = new ListNode(0);
            node.next = head;

            ListNode cur = node;
            while (cur != null && cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return node.next;
        }
    }

}
