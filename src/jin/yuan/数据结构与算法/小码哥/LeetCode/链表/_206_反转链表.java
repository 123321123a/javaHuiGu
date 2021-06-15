package jin.yuan.数据结构与算法.小码哥.LeetCode.链表;


//https://leetcode-cn.com/problems/reverse-linked-list/
public class _206_反转链表 {
   public static void main(String[] args) {
   }

   // 返回的是新的头结点（递归实现）
   //这个递归的作用就是传给我什么，返回的就是反转之后的结果
   public ListNode reverseList(ListNode head) {
      // 如果头节点为空 或者 只有一个节点
      if (head == null) return null;
      if (head.next == null) return head;

      ListNode newHead = reverseList(head.next);
      head.next.next = head;
      head.next = newHead;
      return newHead;
   }

   //非递归（迭代）
   public ListNode reverseList2(ListNode head) {
      if (head == null) return null;
      if (head.next == null) return head;
      ListNode newHead = null;
      while (head != null){
         ListNode tmp = head.next;
         head.next = newHead;
         newHead = head;
         head = tmp;
      }
      return newHead;
   }


   private class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
