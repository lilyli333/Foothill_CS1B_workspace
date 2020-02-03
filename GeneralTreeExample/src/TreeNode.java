
public class TreeNode<E> {
   protected TreeNode<E> firstChild, sib, prev;
   protected E data;

   protected TreeNode<E> root;  // needed to test for certain error
   
   public TreeNode(E data, TreeNode<E> sib, TreeNode<E> firstChild, TreeNode<E> prev) {
      this.firstChild = firstChild;
      this.sib = sib;
      this.prev = prev;
      this.data = data;
      this.root = null;
   }

   public TreeNode() {
      this(null, null, null, null);
   }

   public E getData() { return data; }

   // for use only by Tree (default access)
   protected TreeNode(E data, TreeNode<E> sib, TreeNode<E> child, TreeNode<E> prev, TreeNode<E> root) {
      this(data, sib, child, prev);
      this.root = root;
   }
}
