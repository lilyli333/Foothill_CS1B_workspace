// ---------------------------------------------------------------------------------------------------------------------------------

// @version1.0 04-09-2018

// @author  FH Computer Science Department

//  File name:  RegistrationApp.java

//  Program purpose: This program is to process Bank accounts

//  Disclaimer: If this program is working it's written by the author below. If it is not I don't know who wrote it.

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   04/09/18            John Doe                     1273            Initial implementation

// --------------------------------------------------------------------------------------------------------------------------------

 

import  java.io.*;

 

//  --------------------------------------------------------------------------------------------------------------------

class BankingApp {

        public static void main (String [] args ) {
        	

                   BankAccount  bankAccount = new BankAccount ("Jane", 12345, 100.00);

                   bankAcount.processTransactions ( );

        }

}

//  --------------------------------------------------------------------------------------------------------------------

class   BankAccount  {

                 // static fields (should be made private) and are initialized here

                 private  static  int  routingNumber = 220873691;

                

                 // instance fields (should be made private) - do not initialize here

                 private String   customerName;

                 private int         accountNumber;

                 private double  balance;

 

                 // constructors  -- it's desirable to provide both default constructor

                // and non-default constructor. They should be made public

                 public BankAccount ( ) { }

                 public BankAccount (String customerName, int accountNumber, double  balance) {  }

                

                // accessors/mutators (should be public)

                 public double getBalance ( )  {   return balance; }

                 public void     setBalance ( double balance)   {  this.balance = balance; }

                 

               // behavioral instance methods (mostly public - some private for internal usage)

                 public  void  deposit  (double amount)  {  balance += amount; }

                 public  void  processTransactions {  }  // just for illustrations - more logic to be added

 

                // static method (public)

                 public  static   int  getRoutingNumber (  )  { return  routingNumber; }

                      

                // overriding super class methods (methods defined in the Object class - will learn about this later)    

                 public  String   toString ( ) {

                        return  new String (customerName+";"+accountNumber+”;”+balance);

                 }

                 public  boolean equals (Object obj )  {  // to compare objects 

                          // if the object compare with itself like account.equals (anotherAccount) where both account and anotherAccount points to the same BankAccount object

                          if (obj == this)

                                return true;

                           // if obj is not an instance of BankAccount then they're not equals

                            if  ( !  (obj  instanceof   BankAccount) )

                                    return false;

                             // obj is not pointing to the same object but point to a different BankAccount object - let's compare them

                            return  accountNumber == obj.accountNumber &&

                                        customerName  == obj.customerName ; 

           }     

}

//  --------------------------------------------------------------------------------------------------------------------

class   Customer {  // to be defined

 

}

//  --------------------------------------------------------------------------------------------------------------------