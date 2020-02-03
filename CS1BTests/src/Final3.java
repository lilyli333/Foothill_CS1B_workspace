import java.util.ArrayList;
class SmartStack<E>{
   ArrayList<E> list;
   
   public SmartStack(){
      list = new ArrayList<E>();
   }
   public E pop() {
      if(list.isEmpty())
         return null;
      E firstIndex = list.get(0);
      list.remove(0);
      return firstIndex;
   }
   public void push(E pushItem) {
      list.add(0, pushItem);
   }
}

class  StackUtility  {
   public static Vehicle immobilizeFirstVehicle(SmartStack<? extends Vehicle> stack) {
      Vehicle poppedItem = stack.pop();
      if(poppedItem instanceof Car) {
         poppedItem.parking();
         return poppedItem;
      }
      else if(poppedItem instanceof Boat) {
         poppedItem.docking();
         return poppedItem;
      }
      return null;
   }
}
