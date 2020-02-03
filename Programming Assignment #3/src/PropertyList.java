// -----------------------------------------------------------------------------

// @version1.1 07-25-2019

// @author  Jiayu Li

//  File name:  PropertyList.java

//  Program purpose: this file constitutes a list of properties

//  Disclaimer: this class denotes a linked list

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/20/19          Jiayu Li          1111          initial implementation
//     06/25/19          Jiayu Li          2222          debug & documentation

// -----------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class PropertyList {

   private Property head;
   private static String filePath = "/Users/lily/Desktop/Workspace/" + 
         "Programming Assignment #3/Input.txt";

   public PropertyList() {
      this.head = null;
   }

   /*
    * add Property object to the front of the linked list
    */
   public void insert(Property property) {
      property.setNext(head);
      this.head = property;
   }

   public String getAllProperties() {
      Property property = head;
      String output = "";
      while(property != null) {
         output += property.toString() + "\n";
         property = property.getNext();
      }
      return output;
   }

   public String getSingleFamilyHouse() {
      Property property = head;
      String output = "";
      while(property != null) {
         if(property instanceof SingleFamilyHouse) {
            output += property.toString() + "\n";
         }
         property = property.getNext();
      }
      return output;
   }

   public String getCondo(){
      Property property = head;
      String output = "";
      while(property != null) {
         if(property instanceof Condo) {
            output += property.toString() + "\n";
         }
         property = property.getNext();
      }
      return output;   
   }

   /*
    * search includes min value, excludes max value --> [min, max)
    */
   public String searchByPriceRange(double min, double max) {
      Property property = head;
      String output = "";
      while(property != null) {
         if(property.getOfferedPrice() >= min && property.getOfferedPrice() < max) {
            output += property.toString() + "\n";
         }
         property = property.getNext();
      }
      return output;   
   }

   /*
    * throws and catches IOException (for parsing) 
    * and NoSuchFileException(when file path is incorrect)
    */
   public void initialize() {

      BufferedReader reader = null;

      String line = null;

      try {
         Path inputFilePath = Paths.get(filePath);
         reader =  Files.newBufferedReader(inputFilePath, StandardCharsets.US_ASCII);

         while ( (line = reader.readLine ()) != null ) {
            String[] parsedLine = line.split(";");
            String propertyType = parsedLine[0];
            Property property;
            if(propertyType.equalsIgnoreCase("SFH")) {
               property = new SingleFamilyHouse(parsedLine[1], 
                     Double.parseDouble(parsedLine[2]), Integer.parseInt(parsedLine[3]),
                     Integer.parseInt(parsedLine[4]));
            }
            else if(propertyType.equalsIgnoreCase("condo")) {
               property = new Condo(parsedLine[1], 
                     Double.parseDouble(parsedLine[2]), Integer.parseInt(parsedLine[3]),
                     Double.parseDouble(parsedLine[4]));
            }
            else {
               throw new IOException();
            }
            insert(property);
         }
         reader.close ();
      } 
      catch(NoSuchFileException e) {
         JOptionPane.showMessageDialog(null, "File Not Found");
      }catch (IOException e )  {   
         JOptionPane.showMessageDialog(null, "Unable to parse property");
      }
   }
}
