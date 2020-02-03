
public class Main {

   public static void main(String[] args) {
      
      Stack<String> stack = new Stack<String>();
      stack.insertEnd(new String("end"));
      stack.insertEnd(new String("end1"));
      stack.insertEnd(new String("end2"));
      System.out.println(stack.countNodes());
      stack.removeHead();
      stack.removeHead();
      System.out.println(stack.countNodes());
//      stack.insertHead(new StackNode("head"));
//      stack.insertHead(new StackNode("head1"));
      stack.showList();
//      System.out.println(stack.search("head"));
   }

}
