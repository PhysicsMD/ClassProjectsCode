package p6_package;
/**
 * @author Alenn Wright
 * @Date 2/24/21
 * 
 * Description: Class wrapper for a Java array, with management operations
 */
public class BasicArrayClass
{
   /**
    * private static final int DEFAULT_CAPACITY
    * Default constant capacity
    */
   private static final int DEFAULT_CAPACITY = 10;
   /**
    * public static final int FAILED_ACCESS
    * Default failed access constant
    */
   public static final int FAILED_ACCESS = -999999;
   /**
    * public static final int REPLACE
    * Constant used for allowing setAtIndex to replace value at index
    */
   public static final int REPLACE = 1001;
   /**
    * public static final int INSERT_BEFORE
    * Constant used for allowing setAtIndex to insert value at index
    */
   public static final int INSERT_BEFORE = 1002;
   /**
    * public static final int INSERT_AFTER
    * Constant used for allowing setAtIndex to insert value at index
    */
   public static final int INSERT_AFTER = 1003;
   /**
    * public static final int REMOVE
    * Constant used for allowing accessAtIndex to remove an item
    */
   public static final int REMOVE = 1004;
   /**
    * public static final int RETRIEVE
    * Constant used for allowing accessAtIndex to retrieve an item
    */
   public static final int RETRIEVE = 1005;
   /**
    * private int[] localArray
    * Member - integer array
    */
   private int[] localArray;
   /**
    * private int arraySize
    * Member data
    */
   private int arraySize;
   /**
    * private int arrayCapacity
    * Member data
    */
   private int arrayCapacity;

   /**
    * protected BasicArrayClass()
    * Default constructor, initializes array to default capacity
    */
   protected BasicArrayClass() 
   {
      localArray = new int[DEFAULT_CAPACITY];
      arrayCapacity = DEFAULT_CAPACITY;
      arraySize = 0;
   }
   /**
    * protected BasicArrayClass(int capacity)
    * Initializing constructor, initializes array to specified capacity
    * 
    * @Param capacity - integer maximum capacity specification for the array
    */
   protected BasicArrayClass(int capacity)
   {
      localArray = new int[capacity];
      arrayCapacity = capacity;
      arraySize = 0;
   }
   /**
    * protected BasicArrayClass(BasicArrayClass copied)
    * Copy constructor, initializes array to size and capacity of copied array,
    *  then copies only the elements up to the given size
    *  
    *  @Param copied - BasicArrayClass object to be copied
    */
   protected BasicArrayClass(BasicArrayClass copied)
   {
      localArray = copied.localArray;
      arrayCapacity = copied.arrayCapacity;
      arraySize = copied.arraySize;
   }

   /**
    * private int accessAtIndex(int controlCode, int index)
    * Utility method used by getAtIndex and removeAtIndex to access and 
    * possibly remove element depending on control code
    * 
    * Note: Uses only one loop
    * 
    * @Param controlCode - integer value with either RETRIEVE or REMOVE 
    * to control operations
    * index - integer index of element to be retrieved or removed
    * 
    * @Return integer value at element or FAILED_ACCESS if attempt to access 
    * data out of bounds
    */
   private int accessAtIndex(int controlCode, int index)
   {
      if(controlCode == REMOVE) 
      {
         int removedvalueholder = localArray[index];
         int datashiftcounter = index;
         while(datashiftcounter < arraySize) 
         {
            localArray[index]=localArray[index+1];
            datashiftcounter+=1;
         }
         arraySize-=1;
         return removedvalueholder;
      }
      if(controlCode == RETRIEVE) 
      {
         return localArray[index];
      }
      else 
      {
         return FAILED_ACCESS;
      }
   }
   /**
    * protected void checkForResize()
    * 
    * Description: Checks for need to resize; if this is necessary, creates 
    * new array with double the original capacity, loads data from original 
    * array to new one, then sets localArray to new array
    */
   protected void checkForResize()
   {
      int iterationcounter;
      int[] newArray;
      if(arraySize == arrayCapacity)
      {
         arrayCapacity = arrayCapacity*2;
         newArray = new int[arrayCapacity];
         for(iterationcounter = 0; iterationcounter < arraySize;
               iterationcounter++) 
         {
            newArray[iterationcounter] = localArray[iterationcounter];
         }
         localArray = newArray;
      }
   }
   /**
    * protected void clear()
    * Clears array of all valid values by setting array size to zero, values 
    * remain in array but are not accessible
    */
   protected void clear()
   {
      arraySize = 0;
   }
   /**
    * protected int getAtIndex(int accessIndex)
    * Accesses item in array at specified index if index within array size 
    * bounds
    * 
    * Note: Calls accessAtIndex with RETRIEVE to conduct action
    * 
    * @Param accessIndex - integer index of requested element value
    * 
    * @Return integer accessed value if successful, FAILED_ACCESS if not
    */
   protected int getAtIndex(int accessIndex)
   {
      if(accessIndex<arraySize) 
      {
         return accessAtIndex(RETRIEVE, accessIndex);
      }
      else
      {
         return FAILED_ACCESS;
      }
   }
   /**
    * protected int getCurrentCapacity()
    * Description: Gets current capacity of array
    * 
    * Note: capacity of array indicates number of values the array can hold
    * 
    * @Return integer capacity of array
    */
   protected int getCurrentCapacity()
   {
      return arrayCapacity;
   }
   /**
    * protected int getCurrentSize()
    * Description: Gets current size of array
    * Note: size of array indicates number of valid or viable values in 
    * the array
    * 
    * @Return integer size of array
    */
   protected int getCurrentSize()
   {
      return arraySize;
   }
   /**
    * protected boolean isEmpty()
    * Tests for size of array equal to zero, no valid values stored in array
    * 
    * @Return Boolean result of test for empty
    */
   protected boolean isEmpty()
   {
      return arraySize == 0;
   }
   /**
    * protected int removeAtIndex(int removeIndex)
    * Description: Removes item from array at specified index if index within 
    * array size bounds
    * 
    * Note: Each data item from the element immediately above the remove index 
    * to the end of the array is moved down by one element
    * 
    * Note: Must call accessAtIndex with REMOVE to conduct action
    * 
    * @Param removeIndex - integer index of element value to be removed
    * 
    * @Return removed integer value if successful, FAILED_ACCESS if not
    */
   protected int removeAtIndex(int removeIndex)
   {
      if(removeIndex>=arraySize) 
      {
         return FAILED_ACCESS;
      }
      else 
      {
         return accessAtIndex(REMOVE, removeIndex);
      }
   }
   /**
    * protected boolean setAtIndex(int setIndex, int newValue,int replaceFlag)
    * Description: sets item in array at specified index
    * 
    * Note: If constant REPLACE is used, new value overwrites value at given 
    * index
    * 
    * Note: If constant INSERT_BEFORE is used, new value is inserted prior to 
    * the value at the given index moving all other elements up by one
    * 
    * Note: If constant INSERT_AFTER is used, new value is inserted after the 
    * value at the given index moving all other elements up by one
    * 
    * Note: If either constant INSERT_BEFORE or INSERT_AFTER is used with 
    * index zero and an empty array, new value is inserted at index zero
    * 
    * Note: Method checks for available array capacity and adjusts it as 
    * needed prior to inserting new item
    * 
    * Note: Method must also check for correct array boundaries depending 
    * upon INSERT/REPLACE state
    * 
    * @Param setIndex - integer index of element at which value is to 
    * be inserted
    * newValue - integer value to be placed in array
    * replaceFlag - integer flag to indicate insertion or replacement in 
    * the array
    * 
    * @Return Boolean success if inserted, or failure if incorrect index 
    * was used
    */
   protected boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
   {
      checkForResize();
      if(replaceFlag==REPLACE) 
      {
         localArray[setIndex] = newValue;
         return true;
      }
      else if((replaceFlag==INSERT_BEFORE || replaceFlag==INSERT_AFTER) && 
            arraySize == 0) 
      {
         arraySize+=1;
         localArray[0] = newValue;
         return true;
      }
      else if(replaceFlag==INSERT_BEFORE) 
      {
         arraySize+=1;
         int datashiftingcounter = setIndex;
         while(datashiftingcounter<arraySize-1) 
         {
            localArray[datashiftingcounter+1]=localArray[datashiftingcounter];
            datashiftingcounter+=1;
         }
         localArray[setIndex] = newValue;
         return true;
      }
      else if(replaceFlag==INSERT_AFTER) 
      {
         arraySize+=1;
         int datashiftingcounter = setIndex+1;
         while(datashiftingcounter<arraySize) 
         {
            localArray[datashiftingcounter+1]=localArray[datashiftingcounter];
            datashiftingcounter+=1;
         }
         localArray[setIndex+1] = newValue;
         return true;
      }
      else 
      {
         return false;
      }
      
   }
}
