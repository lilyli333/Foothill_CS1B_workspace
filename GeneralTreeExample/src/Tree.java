public class Tree<E> implements Cloneable{

   protected int size;
   TreeNode<E> root;

   final static String blankString = "                                    ";

   public Tree() { clear(); }
   public boolean empty() { return (size == 0); }
   public int size() { return size; }
   public void clear() { size = 0; root = null; }

   /**
    * 
    * @param treeNode
    * @param x
    * @return reference to newly created TreeNode
    */
   public TreeNode<E> addChild(TreeNode<E> treeNode, E x){
      //empty tree --> create root node if user pass in null for treeNode
      if(size == 0) {
         if(treeNode != null)
            return null; //silent error
         TreeNode<E> newNode = new TreeNode<E>(x, null, null, null);
         root = newNode;
         newNode.root = root;
         size = 1;
         //         System.out.println("tree root: " + root.data);
         return root;
      }
      if(treeNode == null) 
         return null; //error inserting into non_null tree with null parents


      if(treeNode.root != root) {
         //         System.out.println("data " + treeNode.data + " root: " + treeNode.root + " is not " + root.data + "-->not in this tree");
         return null; //silent error, node does not belong to this tree
      }

      //push this node into the head of the sibling list; adjust prev pointer
      //E data, TreeNode<E> sib, TreeNode<E> child, TreeNode<E> prev, TreeNode<E> myRoot
      //      System.out.println("\n tree root" + root.data);
      TreeNode<E> newNode = new TreeNode<E>(x, treeNode.firstChild, null, treeNode, root);
      treeNode.firstChild = newNode;
      //
      //      if(newNode.sib != null)
      //         newNode.sib.prev = newNode;
      //      System.out.println("added: " + newNode.data + " prev: " + newNode.prev.data);
      ++size;
      return newNode;
   }

   /**
    * subtree that's being search through is the whole tree; starting method call
    * @param x what to find
    * @return
    */
   public TreeNode<E> find(E x){ return find(root, x, 0); }
   /**
    * @param root root of the subtree in which we are looking
    * @param x what to find
    * @param level
    * @return
    */
   public TreeNode<E> find(TreeNode<E> root, E x, int level){
      TreeNode<E> retval;

      //terminal cases
      //if main tree is empty or if a leaf is reached
      if(size == 0 || root == null)
         return null;
      //"found case"
      if(root.data.equals(x)) {
         //         System.out.println("successfully found: " + root.data);
         return root;
      }
      //recursive case
      //recurse to sibling on the right
      if(level > 0 && (retval = find(root.sib, x, level)) != null)
         return retval;
      //recurse to child
      return find(root.firstChild, x, ++level);
   }

   public void removeNode(TreeNode<E> nodeToDelete) {
      if(nodeToDelete == null || root == null)
         return;
      if(nodeToDelete.root != root)
         return; //silent error; node does not belong to tree

      //remove all children of node
      while(nodeToDelete.firstChild != null)
         removeNode(nodeToDelete.firstChild);

      if(nodeToDelete.prev == null)
         root = null; //last node in tree
      else if(nodeToDelete.prev.sib == nodeToDelete)
         nodeToDelete.prev.sib = nodeToDelete.sib; //adjust left sib
      else
         nodeToDelete.prev.firstChild = nodeToDelete.sib; //adjust parent

      //adjust successor sib's prev pointer
      if(nodeToDelete.sib != null)
         nodeToDelete.sib.prev = nodeToDelete.prev;
      --size;
   }

   public void display() { display(root, 0); }

   public void  display(TreeNode<E> treeNode, int level) 
   {
      String indent;

      // stop runaway indentation/recursion
      if  (level > (int)blankString.length() - 1)
      {
         System.out.println( blankString + " ... " );
         return;
      }

      if (treeNode == null)
         return;

      indent = blankString.substring(0, level);

      // pre-order processing done here ("visit")
      System.out.println( indent + treeNode.data ) ;

      // recursive step done here
      display( treeNode.firstChild, level + 1 );
      if (level > 0 )
         display( treeNode.sib, level );
   }

   public < F extends Traverser< ? super E >> void traverse(F func) { 
      traverse(func, root, 0); 
   }

   // often helper of typical public version, but also callable by on subtree
   public <F extends Traverser<? super E>> 
   void traverse(F func, TreeNode<E> treeNode, int level)
   {
      if (treeNode == null)
         return;

      func.visit(treeNode.data);

      // recursive step done here
      traverse( func, treeNode.firstChild, level + 1);
      if (level > 0 )
         traverse(func,  treeNode.sib, level);
   }
   
   private TreeNode<E> cloneSubtree(TreeNode<E>root)
   {
      TreeNode<E> newNode;
      if (root == null)
         return null;

      // does not set myRoot which must be done by caller
      newNode = new TreeNode(root.data, cloneSubtree(root.sib), cloneSubtree(root.firstChild),null);
      
      // the prev pointer is set by parent recursive call ... this is the code:
      if (newNode.sib != null)
         newNode.sib.prev = newNode;
      if (newNode.firstChild != null)
         newNode.firstChild.prev = newNode;
      return newNode;
   }
   
   public Object clone() throws CloneNotSupportedException
   {
      Tree<E> newObject = (Tree)super.clone();
      newObject.clear();  // can't point to other's data

      newObject.root = cloneSubtree(root);
      newObject.size = size;
//      newObject.setRoots(newObject.root);
      
      return newObject;
   }
}
