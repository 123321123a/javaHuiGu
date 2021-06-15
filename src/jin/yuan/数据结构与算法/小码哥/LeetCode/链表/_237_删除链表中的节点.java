package jin.yuan.数据结构与算法.小码哥.LeetCode.链表;
//https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
public class _237_删除链表中的节点 {
   public static void main(String[] args) {

   }

   public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
   }

   private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}




































