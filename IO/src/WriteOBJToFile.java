import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;


public class WriteOBJToFile { 

    // modify here for the output filelocations on your computer. Use notepad or wordpad

    // to view the file after the program was executed.

     private  static final String  OUTPUT_FILE_LOCATION = "C:\\Eclipse_java\\workspace\\FileIOApp\\product.txt" ;

      private static final int  productSize = 3;

       public static void main (String [] args) {

             Product  [] productList = new Product [productSize] ;

             initProduct (productList);  // we could have a ProductFactory class to encapsulate this array

                                                        // instantiation but the main focus is Text File I/O so we will skip it

             writeProduct2File  ( productList, OUTPUT_FILE_LOCATION);

     }

     public static void  initProduct (Product [ ]  productList ) {

             // manually instantiate Product objects  assumming we know them ahead of time

             productList  [0] = new Product  ("123", 1, 59.99) ;    // serial, version, price

             productList  [1] = new Product  ("456", 2, 278.95) ;

             productList  [2] = new Product  ("789", 3, 1299.83) ;

     }

     public static void  writeProduct2File (Product [ ]  productList, String outputFileLocation) {

             Path outputFilePath = Paths.get(outputFileLocation);           

             BufferedWriter    writer = null;

             String line = null;

             try {

                         writer =  Files.newBufferedWriter(outputFilePath, StandardCharsets.US_ASCII);

                        for (Product product :  productList ) {

                               line = product.toString ( ) ;

                               writer.write (line, 0, line.length () );

                               writer.newLine ( );

                         }

                       // close the files - must do it as O/S has limited file resources                   

                       writer.close ();

            } catch (IOException e )  {   

                      e.printStackTrace ();
              
                      // may need to close files but will skip it for now

            }

      } // end of writeProduct2File

} // class WriteOBJToFile        
