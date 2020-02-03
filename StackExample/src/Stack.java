public class Stack<E> {
   private Node<E> head;

   public Stack() {
      this.head = null;
   }

   public Stack(Node<E> head) {
      this.head = head;
   }

   //insert in front
   public void insertHead(E data) {
      Node<E> newNode = new Node<E>(data);
      newNode.setNext(head);
      head = newNode;
   }

   //insert in end
   public void insertEnd(E data) {
      if(head == null) {
         head = new Node<E>(data);
         return;
      }

      Node<E> node = head;
      Node<E> newNode = new Node<E>(data);
      while(node.getNext() != null) {
         node = node.getNext();
      }
      node.setNext(newNode);
      newNode.setNext(null);
   }

   //remove head
   public void removeHead() {
      if(head == null)
         return;
      head = head.getNext();
   }

   //count node
   public int countNodes() {
      int count = 0;
      Node<E> node = head;
      while(node != null) {
         count++;
         node = node.getNext();
      }
      return count;
   }

   public void showList() {
      Node<E> node = head;
      while(node != null) {
         System.out.println(node.toString());
         node = node.getNext();
      }
   }

   public Node<E> search(String str) {
      Node<E> node = head;
      while(node != null) {
         if(node.toString().compareTo(str) == 0)
            return node;
         node = node.getNext();
      }
      return null;
   }
  
   public void printHead() {
      System.out.println(head.toString());
   }


}
