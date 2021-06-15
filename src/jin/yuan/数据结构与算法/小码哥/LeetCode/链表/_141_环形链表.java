package jin.yuan.数据结构与算法.小码哥.LeetCode.链表;
 // https://leetcode-cn.com/problems/linked-list-cycle/
public class _141_环形链表 {
   public static void main(String[] args) {

   }

   //快慢指针
   public boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) return false;
      ListNode slow = head;
      ListNode fast = head.next;
      while (fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast) return true;
      }
      return false;
   }


   private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
   }
}
