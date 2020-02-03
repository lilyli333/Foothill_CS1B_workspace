import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JOptionPane;

// -----------------------------------------------------------------------------

// @version1.1 08-07-2019

// @author  Jiayu Li

// File name:  SmartCarrier.java

// Program purpose: this file provides functionality to the entire program,
// including the start menu 

// Revision history:
//  Date              Programmer        Change ID     Description
//  08/01/19          Jiayu Li          1111          initial implementation
//  08/07/19          Jiayu Li          2222          debug and comment 

// -----------------------------------------------------------------------------

public class SmartCarrier {

   private TreeMap<String, ArrayList<Item>> data;
   private String location;
   private static String filePath = "/Users/lily/Desktop/Workspace/" + 
         "Programming Assignment #4/Input.txt";

   public SmartCarrier() {
      this.location = "space";
      this.data = new TreeMap<String, ArrayList<Item>>();
   }

   public SmartCarrier(String location) {
      this();
      this.location = location;
   }

   public void init() {
      BufferedReader reader = null;
      String line = null;

      try {
         Path inputFilePath = Paths.get(filePath);
         reader =  Files.newBufferedReader(inputFilePath, StandardCharsets.US_ASCII);

         while ( (line = reader.readLine ()) != null ) {
            String[] parsedLine = line.split(",");
            String messageType = parsedLine[0];
            int time = Integer.parseInt(parsedLine[1]);
            String from = parsedLine[2];
            String to = parsedLine[3];
            double charge = Double.parseDouble(parsedLine[parsedLine.length - 1]);
            Message newMessage;

            switch(messageType) {
            case "T":
               newMessage = new Message<Text>(new Text(parsedLine[4]), time, from, to, charge);
               break;
            case"V":
               newMessage = new Message<Voice>(new Voice(Double.parseDouble(parsedLine[4]), parsedLine[5]), time, from, to, charge);
               break;
            case"M":
               newMessage = new Message<Media>(new Media(Double.parseDouble(parsedLine[4]), parsedLine[5]), time, from, to, charge);
               break;
            default:
               newMessage = null;
               throw new IOException();
            }

            ArrayList<Item> items = data.get(from);
            if(items == null) {
               items = new ArrayList<Item>();
               data.put(from, items);
            }
            items.add(newMessage);

         }
         reader.close ();
      } 
      catch(NoSuchFileException e) {
         JOptionPane.showMessageDialog(null, "File Not Found");
      }catch (IOException e )  {   
         JOptionPane.showMessageDialog(null, "Unable to parse");
      }
   }

   public void run() {
      String userInput = "4";
      do {
         Scanner scanner = new Scanner(System.in);
         System.out.println("\n\n\n                     FOOTHILL WIRELESS  at " + location + "                     " +
               "\n\n" + 
               "                MESSAGE UTILIZATION AND ACCOUNT ADMIN                \n" + 
               "\n" + 
               "1. List all accounts\n" + 
               "2. Erase the first media message \n" + 
               "3. Disconnect an account \n" + 
               "4. Quit\n"
               + "\nEnter a choice (1-4):\n" + 
               "\n");
         userInput = scanner.nextLine();

         switch(userInput) {
         case "1":
            listAccounts();
            break;
         case "2":
            eraseMediaMessage();
            break;
         case "3":
            System.out.println("Phone number of account to disconnect: ");
            String disconnectAccountNumber = scanner.nextLine();
            deleteAccount(disconnectAccountNumber);
            break;
         case "4":
            break;
         default:
            System.out.println("**Please input a valid number**");
            userInput = "1";
         }
      }while(!userInput.equals("4"));
   }

   /*
    * private helper method written to avoid code redundancy 
    */
   private double getTotalCharge(ArrayList<Item> items) {
      double totalCharge = 0;
      ListIterator itemsList = items.listIterator();
      while (itemsList.hasNext())   {
         Item item = (Item) itemsList.next();
         totalCharge += item.getCharge();
      }
      return totalCharge;
   }

   private void listAccounts() {
      ArrayList<Item> items;
      String fromNumber;
      System.out.println("                        LIST OF ALL ACCOUNTS                        ");
      for (Map.Entry<String,ArrayList<Item>> account : data.entrySet()) {
         items = account.getValue();
         fromNumber = account.getKey();

         System.out.println("Account: "  + fromNumber);
         ListIterator itemsList = items.listIterator();

         while (itemsList.hasNext()) {
            Item item = (Item) itemsList.next();
            System.out.println(item.toString());
         }

         System.out.println("Total charges: " + getTotalCharge(items));
         System.out.println("-------------------------------------------------------\n");

      }

   }

   private void eraseMediaMessage() {
      ArrayList<Item> items;
      String fromNumber;
      for (Map.Entry<String,ArrayList<Item>> account : data.entrySet()) {
         eraseHelper(account.getValue());
      }

   }

   private void eraseHelper(List<? extends Item> items) {
      for(Item item : items) {
         if(item instanceof Message<?>) {
            if(((Message<?>)item).getMessage() instanceof Media) {
               items.remove(item);
               break;
            }
         }
      }
   }

   private void deleteAccount(String phoneNumber) {
      try {
         if(data.containsKey(phoneNumber)) {
            System.out.println("Total charge for " + phoneNumber + ": " + getTotalCharge(data.get(phoneNumber)));
            data.remove(phoneNumber);
            return;
         }
         throw new NullPointerException();
      } catch(NullPointerException e) {
         System.out.println("Account " + phoneNumber + " does not exist!");
      }
   }

}
