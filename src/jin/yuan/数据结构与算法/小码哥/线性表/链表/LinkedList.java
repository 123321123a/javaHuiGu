package jin.yuan.数据结构与算法.小码哥.线性表.链表;

public class LinkedList<E> {
   private int size;
   private Node<E> firstNode;

   private static final int ELEMENT_NOT_FOUND = -1; //如果查询不到元素就返回-1

   private static class Node<E> {
      E elementE;
      Node<E> next;

      public Node(E elementE, Node<E> next) {
         this.elementE = elementE;
         this.next = next;
      }
   }

   //元素的数量
   public int size(){
      return size;
   }

   //是否为空
   public boolean isEmpty(){
      return size == 0;
   }

   //是否包含某个元素
   public boolean contains(E element){
      return indexOf(element) != ELEMENT_NOT_FOUND;
   }

   //末尾添加元素
   public void add(E element){
      add(size,element);
   }

   //指定位置添加元素
   public void add(int index,E element){
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException("Index:" + index + " ,Size" + size);
      }

      if (index == 0){
         firstNode = new Node<E>(element,firstNode);
      }else {
         //先要获取 index 前面的那个节点
         Node<E> prev = node(index - 1);
         Node<E> newNode = new Node<>(element, prev.next);
         prev.next = newNode;
      }
      size++;
   }

   //返回指定位置的元素
   public E get(int index){
      return node(index).elementE;
   }

   //设置index位置的元素
   public E set(int index, E element){
      //取出原来的 node
      Node<E> node = node(index);
      E old = node.elementE;
      node.elementE = element;
      return old;
   }

   //删除index位置对应的元素
   public E remove(int index){

      Node<E> node = firstNode;
      if (index  == 0){
         firstNode = firstNode.next;
      }else{
         //获取要删除索引的前面的元素
         Node<E> prev = node(index - 1);
         node = prev.next;
         prev.next = prev.next.next;
      }
      size--;
      return node.elementE;
   }

   //查看元素的位置
   public int indexOf(E element){
      if (element == null){
         Node<E> node = firstNode;
         for (int i = 0; i < size; i++) {
            if (node.elementE == null) return i;
            node = node.next;
         }
      }else {
         Node<E> node = firstNode;
         for (int i = 0; i < size; i++) {
            if (element.equals(node.elementE)) {
               return i;
            }
            node = node.next;
         }
      }
      return ELEMENT_NOT_FOUND;
   }

   //清空所有元素
   public void clear(){
      size = 0;
      firstNode = null;
   }

   //遍历打印链表
   public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("size=").append(size).append(", [");
      Node<E> node = firstNode;
      for (int i = 0; i < size; i++) {
         stringBuilder.append(node.elementE);
         if (i != size-1){
            stringBuilder.append(", ");
         }
         node = node.next;
      }
      stringBuilder.append("]");
      return String.valueOf(stringBuilder);
   }

   //返回索引对应的节点对象
   private Node<E> node(int index){
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException("Index:" + index + " ,Size" + size);
      }
      Node<E> node = firstNode;
      for (int i = 0; i < index; i++) {
         node = node.next;
      }
      return node;
   }
}
























