//Midterm 2

public class PetApp {

   public static void main (String [] args)  {
      //3. (2 pts) Declare and instantiate an array of 2 Pet references.
      Pet[] pets = new Pet[2];
      //4. (2 pts) Instantiate a Dog object and a Fish object then assign them to the array above.
      pets[0] = new Dog();
      pets[1] = new Fish();
      //5. (3 pts) Use the newly enhanced for loop syntax  to generically "feed" the pets.
      for(Pet pet : pets) {
         pet.feed();
      }
      //6. (3 pts) Use another newly enhanced for loop syntax to specifically make the Dog bark and the Fish swim.
      for(Pet pet: pets) {
         if(pet instanceof Dog) {
            ((Dog) pet).bark();  
         }
         else if(pet instanceof Fish) {
            ((Fish) pet).swim();
         }
      }

   }

}

//7. (4 pts) The problem with question 5 above is that we can't feed dog and fish the same way (or generically). 
//Modify class Pet, Dog and Fish to allow feed to be an abstract method in Pet and will be re-defined in both Dog and Fish. 
//The implementation of the feed method in the sub classes is just a single output statement.

abstract class Pet {

   private int age;

   public Pet ( int age )   {  this.age = age;}

   abstract public  void  feed  ( );
}

class  Dog  extends   Pet  {

   public Dog ( )  {
      super(0);

   }

   public void  bark ()  {

      // .......

   }

   @Override
   public void feed() {
      System.out.println("feeding dog");
   }

}

class  Fish  extends   Pet  {

   public Fish ( )  {
      super(0);

   }

   public void  swim ()  {

      // .......

   }

   @Override
   public void feed() {
      System.out.println("feeding fish");
   }

}