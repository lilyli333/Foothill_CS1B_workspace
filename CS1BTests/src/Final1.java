import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Final1 {
   public static void main (String[] args) {
      
      LinkedList ls = new LinkedList();
      ls.addNode(new Node(1));
      ls.addNode(new Node(2));
      ls.addNode(new Node(3));
      ls.showList();
//      System.out.println("sss");
      System.out.println("size " + ls.getSize());
      ls.clear();
      ls.showList();
      System.out.println("size " + ls.getSize());
   }
}
class Node {

   private  Node  next;
   private int data;
   
   public Node (int d) { data = d; }
  

   public  Node  getNext () { return next; }

   public  void   setNext  (Node newNode )  {  next = newNode; }
   public int getData() {return data;}

}

class LinkedList  {

   private  Node  head;
   
   public void showList() {
      Node node = head;
      while(node != null) {
         System.out.println(node.getData());
         node = node.getNext();
      }
   }

   // 1. (5pts)  Add a public method to the class named size that returns the number of nodes in the list.
   public int getSize() {
      Node tempNode = head;
      int count = 0;
      while(tempNode != null) {
         count ++;
         tempNode = tempNode.getNext();
      }
      return count;
   }
   
   //2. (5 pts) Add a public method to the class named add that always inserts 
   //a new Node (method's only parameter) to the end of the Linked List. 
   //Hint: you need to get a reference to the last node of the list before 
   //attempting to insert the new node. Be aware when the list is empty initially. 

   public void addNode(Node newNode) {
      if(head == null) {
         head = newNode;
         return;
      }
      Node node = head;
      while(node.getNext() != null) {
         node = node.getNext();
      }
      node.setNext(newNode);
      newNode.setNext(null);
   }
   
   //3. (5 pts) Add a public method to the class named clear that will:
   //iterate through the entire list to set the next reference in each node to null (disconnecting all nodes).
   //finally set head to null.
   
   public void clear() {
      Node tempNode = head;
      while(head != null) {
         tempNode = head.getNext();
         head.setNext(null);
         head = tempNode;
      }
   }
}