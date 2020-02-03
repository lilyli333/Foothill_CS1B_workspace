import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;


public class ParseTextFile { 

     // modify here for the input file locations on your computer as needed.

      private  static final String  INPUT_FILE_LOCATION = "C:\\Eclipse_java\\workspace\\FileIOApp\\product.txt" ;

      private static final int  productSize = 3;

       public static void main (String [] args) {

             Product  [] productList = new Product [productSize] ;

             buildProductList  ( productList,  INPUT_FILE_LOCATION);

             showProduct (productList);

     }

     public static void  buildProductList  (Product [ ]  productList,  String  inputFileLocation) {

             Path inputFilePath = Paths.get(inputFileLocation);           

             BufferedReader    reader = null;

             String line = null;

             int index = 0;   // to keep track of the next array element location available for adding new Product

             try {

                         reader =  Files.newBufferedReader(inputFilePath, StandardCharsets.US_ASCII);

                        while ( (line = reader.readLine ()) != null ) {

                                 addProduct (line, productList, index++);

                         }

                       // close the files - must do it as O/S has limited file resources                   

                       reader.close ();

            } catch (IOException e )  {   

                      e.printStackTrace ();

                      // may need to close files but will skip it for now

            }

      } // end of buildProductList

    

       public static void addProduct ( String line, Product [ ]  productList, int index) {

                  String serial;

                   int version = 0;

                   double price = 0.0;

                  // first splitting the line containing serial~version~price into 3 separate data

                  String [ ]  data = line.split ("~"); 

                  // file is perfectly formatted = no error checking is needed here for simplicity

                  serial = data [0];

                  version = Integer.parseInt (data[1]);

                  price = Double.parseDouble ( data [2]) ;  

                  productList [index] = new Product (serial, version, price) ;

       }

       public static void showProduct (Product [ ] productList) {  // modify this method to show better output if needed

                   for (Product product : productList ) {

                               System.out.println ( product ) ;  //toString will take over here to show the data

                   }

        }

 

} // classParseTextFile       

class Product  {

         private  String   serial;

         private  int         version;

         private  double  price;

     

         public   Product ( )  {}

         public   Product  (String serial, int version, double  price) {

                     this.serial = serial;

                     this.version = version ;

                     this.price = price;

          }

 

          // skip accessor/mutator and behavioral methods

         public String  toString ( ) {

                return  serial + "~" + version + "~" + price;

         }

         public boolean equals (Object  object ) {

                   if ( this == object)

                        return true;

                    if ( ! (object instanceof Product))

                         return false;

                    Product product = (Product)  object;

                    return serial == product.serial;

          }

  } // class Product