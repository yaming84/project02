import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author bluesnow
 * 
 */
public class CSVReader
{
   private int startingYear = 0;
   private int nameSize = 0;
   private int yearSize = 0;
   private String[] countryNames;
   private int[] yearLabel;
   private double[][] parsedTable;

   /**
    * class constructor which takes the fileName as
    * 
    * @param fileName
    */
   public CSVReader(String fileName)
   {
      File myFile = new File(fileName);
      try
      {
         Scanner inFile = new Scanner(myFile);
         String data = inFile.nextLine();

         // 1.split the second line of data by ",";
         // 2.get size of the country name;
         data = inFile.nextLine();
         String[] dataLine = data.split(",");
         nameSize = Integer.parseInt(dataLine[1]);

         // 3.split the third line of data by ",";
         // 4.get size of the year;
         // 5.get the starting year.
         data = inFile.nextLine();
         dataLine = data.split(",");         
         yearSize = dataLine.length - 1;
         yearLabel = new int[yearSize];
         startingYear = Integer.parseInt(dataLine[1]);
         for (int i = 0; i < yearSize; i++)
         {
            yearLabel[i] = startingYear + i;
         }

         // 5.read the rest of file line by line using for loop.
         countryNames = new String[nameSize];
         parsedTable = new double[nameSize][yearSize];
         for (int i = 0; i < nameSize; i++)
         {
            data = inFile.nextLine();
            dataLine = data.split(",");            
            countryNames[i] = dataLine[0];
          
//            // create an array country
//            // stores one country's data;
//            double[] country = new double[yearSize];
//            for (int n = 0; n < yearSize; n++)
//            {
//               country[n] = Double.parseDouble(dataLine[n + 1]);
//            }
//            parsedTable [i] = country;
            
            for(int j = 0; j < yearSize; j++)
            {
               parsedTable[i][j] = Double.parseDouble(dataLine[j+1]);
            }
         }
      } catch (FileNotFoundException e)
      {
         System.out.println("File " + fileName + " not found!");
      }
   }

   /**
    * 
    * @return a array contains the country names.
    */
   public String[] getCountryNames()
   {
      return countryNames;
   }

   /**
    * 
    * @return an array contains label of years.
    */
   public int[] getYearLabels()
   {
      return yearLabel;
   }

   public double[][] getParsedTable()
   {
      return parsedTable;
   }
   
   //////test
   public String toString()
   {
      String test = parsedTable[0][52] + "";
      return test;
   }
   //////end of test
  
}
