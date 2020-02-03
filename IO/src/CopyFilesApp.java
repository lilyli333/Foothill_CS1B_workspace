import java.io.*;                    //  for BufferedReader

import java.nio.charset.*;  // for StandardCharsets.US_ASCII
import java.nio.file.*;          // for Files.newBufferedReader, Files.newBufferedWriter, Paths



public class CopyFilesApp  { 

    // modify here for the I/O files locations on your computer. Use notepad or wordpad

    // to create the input text file and compare it with the output text file afterwards.

     private  static final String  INPUT_FILE_LOCATION = "C:\\Eclipse_java\\workspace\\FileIOApp\\in_file.txt" ;

     private  static final String  OUTPUT_FILE_LOCATION = "C:\\Eclipse_java\\workspace\\FileIOApp\\out_file.txt" ;

     public static void main (String [] args) {

               copyFiles ( INPUT_FILE_LOCATION, OUTPUT_FILE_LOCATION);

     }

     public static void  copyFiles (String inputFileLocation, String outputFileLocation) {

             Path inputFilePath = Paths.get(inputFileLocation);

             Path outputFilePath = Paths.get(outputFileLocation);

             BufferedReader   reader = null;

             BufferedWriter    writer = null;

             String line = null;

             try {

                      reader = Files.newBufferedReader(inputFilePath, StandardCharsets.US_ASCII);   

                      writer =  Files.newBufferedWriter(outputFilePath, StandardCharsets.US_ASCII);

                      while ( (line = reader.readLine ()) != null) {

                                writer.write (line, 0, line.length () );

                                writer.newLine ( );

                       }

                       // close the files - must do it as O/S has limited file resources

                       reader.close ();

                       writer.close ();

            } catch (IOException e )  {   // throw java.nio.file.NoSuchFileException if input file does not exist

                      e.printStackTrace ();

                      // may need to close files but will skip it for now

            }

      } // end of copyFiles

}