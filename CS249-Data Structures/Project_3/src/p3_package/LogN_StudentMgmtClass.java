package p3_package;

/**
 * @author Alenn Wright
 * @since 2/3/2021
 */

public class LogN_StudentMgmtClass
{
   /**
    * public LogN_StudentMgmtClass():Default constructor, takes no action for 
    * this static tool clas
    * */
   public LogN_StudentMgmtClass()
   {
      //nothing that I know
   }
   
   /**
    * public static int compareStrings(String strOne, String strTwo): Compares 
    * two strings character by character set to lower case to see which is 
    * alphabetically greater than the other; if all tested letters of a 
    * name are equal, then compares string lengths
    * 
    * Results are as follows:
    * 
    * Alphabetically, if strOne is greater than strTwo, returns value greater 
    * than zero (e.g., Susan is greater than Bill);
    * 
    * if strOne is less than strTwo, returns value less than zero (e.g., 
    * Roger is less than Zelda);
    * 
    * if strOne is equal to strTwo alphabetically but is different length, 
    * returns difference in length (e.g., Will is less than William)
    * 
    * if strOne is equal to strTwo both alphabetically and in length, 
    * returns zero (e.g., Susan is equal to Susan)
    * 
    * Note: .length and .charAt utility methods may used in this method
    * 
    * @param strOne - first String value to be compared
    * @param strTwo - second String value to be compared
    * @return integer difference as specified
    * */
   public static int compareStrings(String strOne, String strTwo) 
   {
      int difference, index = 0;       
      char thisStateChar, otherStateChar;
      
      while( index < strOne.length() && index < strTwo.length() )
         {
          thisStateChar = strOne.charAt( index );
          otherStateChar = strTwo.charAt( index );
          difference = toLowerCase( thisStateChar ) 
                                           - toLowerCase( otherStateChar );
          
          if( difference != 0 )
             {
              return difference;
             }
          
          index++;  
         }
            
      return strOne.length() - strTwo.length();
   }
   
   /**
    * private static void runMerge(StudentClass[] localArray, int lowIndex,
    * int middleIndex, int highIndex):Merges StudentClass objects brought in 
    * between a low and high index segment (inclusive) of an array
    * 
    * Note: uses locally sized single array for temporary storage
    * 
    * @Param localArray - StudentClass array holding unsorted values
    * @Param lowIndex - lowest index of array segment to be managed
    * @Param middleIndex - middle index of array segment to be managed
    * @Param highIndex - high index of array segment to be managed
    * */
   private static void runMerge(StudentClass[] localArray, 
         int lowIndex, int middleIndex, int highIndex) 
   {
      StudentClass[] tempArray = new StudentClass[highIndex - lowIndex + 1];
      int tempLowIndexHolder = lowIndex;
      int tempMiddleIndexHolder = middleIndex;
      int temptophalfIndexHolder = middleIndex + 1;
      int index = 0;
      
      while( tempLowIndexHolder <= tempMiddleIndexHolder && 
            temptophalfIndexHolder <= highIndex )
      {
          if ( compareStrings(localArray[tempLowIndexHolder].name, 
                localArray[temptophalfIndexHolder].name) <=0)
          {
              tempArray[index] = localArray[tempLowIndexHolder];
              tempLowIndexHolder++;
          }
          else
          {
              tempArray[index] = localArray[temptophalfIndexHolder];
              temptophalfIndexHolder++;
          }
          index++;
      }
      while( tempLowIndexHolder <= tempMiddleIndexHolder )
      {
          tempArray[index] = localArray[tempLowIndexHolder];
          index++;
          tempLowIndexHolder++;
      }
      
      while( temptophalfIndexHolder <= highIndex )
      {
          tempArray[index] = localArray[temptophalfIndexHolder];
          index++;
          temptophalfIndexHolder++;
      }
      for(index = lowIndex; index <= highIndex; index++)
      {
         localArray[index] = tempArray[index - lowIndex];
      }
   }
   
   /**
    * public static void runMergeSort(StudentClass[] localArray, int size):
    * StudentClass data sorted using merge sort algorithm and the names as 
    * the keys
    * 
    * Note: Calls runMergeSortHelper with lower and upper indices of array to 
    * be sorted
    * 
    * @Param localArray - String array holding unsorted values
    * @Param size - integer value holding number of values in array
    * */
   public static void runMergeSort(StudentClass[] localArray, int size) 
   {
      runMergeSortHelper(localArray, 0, size-1);
   }
   
   /**
    * private static void runMergeSortHelper(StudentClass[] localArray, 
    * int lowIndex, int highIndex)
    * 
    * Merge sort helper, recursively breaks given array segment down to 
    * smaller segments between lowIndex and highIndex (inclusive), then sorts 
    * data using merge sort method
    * 
    * @Param localArray - StudentClass array holding unsorted values
    * @Param lowIndex - lowest index of array segment to be managed; this 
    * varies as the segments are broken down recursively
    * @Param highIndex - highest index of array segment to be managed; this 
    * varies as the segments are broken down recursively
    * */
   private static void runMergeSortHelper(StudentClass[] localArray,
         int lowIndex, int highIndex) 
   {
      int middleIndex = (highIndex+lowIndex)/2;
      if ( lowIndex < highIndex)
      {
          runMergeSortHelper(localArray, lowIndex, middleIndex);
          runMergeSortHelper(localArray, middleIndex + 1, highIndex);
          runMerge(localArray, lowIndex, middleIndex, highIndex);
      }
   }
   
   /**
    * private static int runPartition(StudentClass[] localArray, int lowIndex,
    * int highIndex)
    * 
    * Partitions array using the first value as the partition; when this method
    *  is complete the partition value is in the correct location in the array
    * 
    * @Param localArray - StudentClass array holding unsorted values
    * @Param lowIndex - low index of array segment to be partitioned
    * @Param highIndex - high index of array segment to be partitioned
    * 
    * @Return integer index of partition pivot
    * */
   private static int runPartition(StudentClass[] localArray,
         int lowIndex, int highIndex) 
   {
      StudentClass pivot = localArray[highIndex];  
      int iterator = (lowIndex-1);
      int iterator2;
      for ( iterator2=lowIndex; iterator2<highIndex;  iterator2++) 
      { 
          if (compareStrings(localArray[iterator2].name,pivot.name)<0) 
          { 
              iterator++;
              swapValues(localArray, iterator, iterator2);
          } 
      } 
      swapValues(localArray, iterator+1, highIndex);
      int pivotindex = iterator+1;
      return pivotindex;
   }
   
   /**
    * public static void runQuickSort(StudentClass[] localArray, int size) 
    * Data sorted using quick sort algorithm and the names as the keys
    * Note: Call runQuickSortHelper with lower and upper indices of array to 
    * be sorted
    * 
    * @Param localArray - StudentClass array holding unsorted values
    * @Param size - integer value holding the number of values in the array
    * */
   public static void runQuickSort(StudentClass[] localArray,
         int size) 
   {
      runQuickSortHelper(localArray, 0, size-1);
   }
   
   /**
    * private static void runQuickSortHelper(StudentClass[] localArray, 
    * int lowIndex, int highIndex)
    * 
    * Helper method run with parameters that support recursive access
    * 
    * @Param localArray - StudentClass array holding unsorted values
    * @Param lowIndex - low index of the segment of the array to be processed
    * @Param highIndex - high index of the segment of the array to be processed
    * */
   private static void runQuickSortHelper(StudentClass[] localArray,
         int lowIndex, int highIndex) 
   {
      if (lowIndex < highIndex) 
      { 
          int pivot = runPartition(localArray, lowIndex, highIndex); 
          runQuickSortHelper(localArray, lowIndex, pivot-1); 
          runQuickSortHelper(localArray, pivot+1, highIndex); 
      } 
   }
   
   /**
    * private static void swapValues(StudentClass[] localArray,
    * int indexOne,int indexOther)
    * 
    * Swaps values within given array
    * 
    * @Param localArray - array of Strings used for swapping
    * @Param indexOne - integer index for one of the two items to be swapped
    * @Param indexOther - integer index for the other of the two items to be 
    * swapped
    * */
   private static void swapValues(StudentClass[] localArray,
         int indexOne, int indexOther) 
   {
      StudentClass holder;
      holder = localArray[indexOther];
      localArray[indexOther] =  localArray[indexOne];
      localArray[indexOne] = holder;
   }
   
   /** Changes character to lower case only if character was originally 
    * an upper case letter
    * 
    * @param testChar Character to be tested, if it is upper case it will 
    * be converted to lower case;
    * otherwise the testChar will be returned unchanged
    * 
    * @return returns the lower case version of a letter 
    * if it was an upper case letter;
    * otherwise, the character is returned unchanged
    */
   private static char toLowerCase(char testChar) 
   {
      if( testChar >= 'A' && testChar <= 'Z' )
      {
       testChar = (char)( testChar - 'A' + 'a' );
      }
   
   return testChar;
   }
}
