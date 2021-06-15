package jin.yuan.数据结构与算法.小码哥.线性表.动态数组;

@SuppressWarnings({"all"})
public class ArrayList<E> {

   private int size;//元素的数量
   private E[] elements;//所有的元素

   private static final int DEFAULT_CAPACITY = 2; //系统默认初始化数组的大小
   private static final int ELEMENT_NOT_FOUND = -1; //如果查询不到元素就返回-1

   public ArrayList(int capacity){
      //如果传入的参数小于 10，capacity 就设置为10
      capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
      elements = (E[]) new Object[capacity];
   }
   public ArrayList(){
      this(DEFAULT_CAPACITY); //构造函数之间的调用是 this
   }

   //返回元素的数量
   public int size(){
      return size;
   }

   //判断是否为空
   public boolean isEmpty(){
      return size == 0;
   }

   //获取索引位置的元素
   public E get(int index){
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index:" + index + " ,Size" + size);
      }
      return elements[index];
   }

   //设置index位置的元素
   public E set(int index, E element){
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index:" + index + " ,Size" + size);
      }
      E old = elements[index];
      elements[index] = element;
      return old;
   }

   //查看元素的索引位置
   public int indexOf(E element){
      if (element == null){
         for (int i = 0; i < size; i++) {
            if (elements[i] == null) return i;
         }
      }else {
         for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return i;
         }
      }
      return ELEMENT_NOT_FOUND;
   }

   //是否包含某个元素
   public boolean contains(E element){
      return indexOf(element) != ELEMENT_NOT_FOUND;
   }

   //清除所有元素
   public  void clear(){
      for (int i = 0; i < elements.length; i++) {
         elements[i] = null;
      }
      size = 0;
   }

   //末尾添加元素
   public void add(E element){
      add(size,element);
   }

   //往index位置添加元素
   public void add(int index,E element){
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException("Index:" + index + " ,Size" + size);
      }

      //保证有多少的容量
      ensureCapacity(size + 1);

      for (int i = size-1; i >= index; i--) {
         elements[i+1] = elements[i];
      }
      elements[index] = element;
      size++;
   }

   //打印数组
   @Override
   public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("size=").append(size).append(", [");
      for (int i = 0; i < size; i++) {
         stringBuilder.append(elements[i]);
         if (i != size-1){
            stringBuilder.append(", ");
         }
      }
      stringBuilder.append("]");
      return String.valueOf(stringBuilder);
   }
   
   //删除元素
   public E remove(int index){
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index:" + index + " ,Size" + size);
      }

      E old = elements[index];
      //元素迁移
      for (int i = index + 1; i <= size-1 ; i++) {
         elements[i-1] = elements[i];
      }
      size--;
      elements[size] = null;
      return old;
   }

   //保证要有 capacity 的容量
   private void ensureCapacity(int capacity) {
      int oldCapacity = elements.length;
      if (oldCapacity >= capacity) return;

      //新容量为旧容量的 1.5 倍
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      E[] newElements = (E[]) new Object[newCapacity];
      System.out.println("开始扩容了哦");
      for (int i = 0; i < size; i++) {
         newElements[i] = elements[i];
      }
      elements = newElements;
   }
}
