
import java.text.*;
import java.util.*;

//------------------------------------------------------
public class Main
{ 
   // -------  main --------------
   public static void main(String[] args) throws Exception
   {
      Tree<String> sceneTree = new Tree<String>();
      TreeNode<String> tn;

      // create a scene in a room
      tn = sceneTree.addChild(null, "room");

      // add three objects to the scene tree
      sceneTree.addChild(tn, "Lily the canine");
      sceneTree.addChild(tn, "Miguel the human");
      sceneTree.addChild(tn, "table");
      // add some parts to Miguel
      tn = sceneTree.find("Miguel the human");

      // Miguel's left arm
      tn = sceneTree.addChild(tn, "torso");
      tn = sceneTree.addChild(tn, "left arm");
      tn =  sceneTree.addChild(tn, "left hand");
      sceneTree.addChild(tn, "thumb");
      sceneTree.addChild(tn, "index finger");
      sceneTree.addChild(tn, "middle finger");
      sceneTree.addChild(tn, "ring finger");
      sceneTree.addChild(tn, "pinky");
      //
      sceneTree.display();

      //      // Miguel's right arm
      //      tn = sceneTree.find("Miguel the human");
      //      tn = sceneTree.find(tn, "torso", 0);
      //      tn = sceneTree.addChild(tn, "right arm");
      //      tn =  sceneTree.addChild(tn, "right hand");
      //      sceneTree.addChild(tn, "thumb");
      //      sceneTree.addChild(tn, "index finger");
      //      sceneTree.addChild(tn, "middle finger");
      //      sceneTree.addChild(tn, "ring finger");
      //      sceneTree.addChild(tn, "pinky");
      //
      //      // add some parts to Lily
      //      tn = sceneTree.find("Lily the canine");
      //      tn = sceneTree.addChild(tn, "torso");
      //      sceneTree.addChild(tn, "right front paw");
      //      sceneTree.addChild(tn, "left front paw");
      //      sceneTree.addChild(tn, "right rear paw");
      //      sceneTree.addChild(tn, "left rear paw");
      //      sceneTree.addChild(tn, "spare mutant paw");
      //      sceneTree.addChild(tn, "wagging tail");
      //
      //      // add some parts to table
      //      tn = sceneTree.find("table");
      //      sceneTree.addChild(tn, "north east leg");
      //      sceneTree.addChild(tn, "north west leg");
      //      sceneTree.addChild(tn, "south east leg");
      //      sceneTree.addChild(tn, "south west leg");
      //
      //      sceneTree.display();

      //      sceneTree.removeNode("spare mutant paw");
      //      sceneTree.removeNode("Miguel the human");
      //      sceneTree.removeNode("an imagined higgs boson");
      //      
      //      sceneTree.display();
   }
}
//public class Main {
//   public static void main(String[] args) throws Exception
//   {
//      Tree<String> tree = new Tree<String>();
//      TreeNode<String> tn = tree.addChild(null, "0");
//
//      TreeNode<String> tn1 = tree.addChild(tn, "1");
//      tree.addChild(tn1, "2");
//      tree.addChild(tn1, "3"); 
//
//      tn1 = tree.addChild(tn, "a");
//      tree.addChild(tn1, "b");
//      tree.addChild(tn1, "c"); 
//
//      tree.display();
//
//   }
//
//}
