package p1_package;

/**
 * Class for managing sets of integers, has capacity to generate various sets
 * 
 * @author Alenn Wright
 *
 */
public class SetClass
{
   /**
    * constant with default array capacity
    */
   public static final int DEFAULT_ARRAY_CAPACITY = 10;

   /**
    * integer array for data
    */
   int[] setArray;

   /**
    * capacity of array
    */
   int arrayCapacity;

   /**
    * number of values in array
    */
   int arraySize;

   /**
    * constants for specifying set data
    */
   public static final int INCREMENTED = 101;
   public static final int ODD = 102;
   public static final int EVEN = 103;
   public static final int PRIME = 104;

   /**
    * Default constructor
    * <p>
    * Initializes set array but sets power set array to null
    */
   public SetClass()
   {
      arraySize = 0;
      arrayCapacity = DEFAULT_ARRAY_CAPACITY;
      setArray = new int[DEFAULT_ARRAY_CAPACITY];
   }

   /**
    * Initialization constructor
    * <p>
    * Allows specification of set array capacity
    * <p>
    * Initializes set array but sets power set array to null
    * 
    * @param initialCapacity integer that specifies array capacity
    */
   public SetClass(int initialCapacity)
   {
      arraySize = 0;
      arrayCapacity = initialCapacity;
      setArray = new int[initialCapacity];
   }

   /**
    * Copy constructor
    * <p>
    * Duplicates copied set class
    * <p>
    * Also responsible for correct initialization/update of power set array
    * 
    * @param copied SetClass object to be copied
    */
   public SetClass(SetClass copied)
   {
      arraySize = copied.arraySize;
      arrayCapacity = copied.arrayCapacity;
      setArray = new int[arrayCapacity];
      int arraycopycounter;
      for(arraycopycounter=0;arraycopycounter<arraySize;arraycopycounter++) 
      {
         setArray[arraycopycounter] = copied.setArray[arraycopycounter];
      }
   }

   /**
    * Adds integer to set
    * <p>
    * increases capacity using checkForResize if array is full
    * <p>
    * does not allow duplicate values in set
    * 
    * @param item integer value to be added to set
    */
   public void addItem(int item)
   {
      checkForResize();
      if (!hasElement(item))
      {
         setArray[arraySize] = item;
         arraySize += 1;
      }
   }

   /**
    * Local function tests for resize of the set array
    * <p>
    * If array needs to be resized, array capacity is doubled; otherwise, no change
    * 
    * @return boolean report that resize was conducted
    */
   private boolean checkForResize()
   {
      boolean resizeflag = false;
      int counter;
      int[] newArray;
      if(arraySize == arrayCapacity)
      {
         arrayCapacity = arrayCapacity*2;
         newArray = new int[arrayCapacity];
         for(counter = 0; counter < arraySize; counter++) 
         {
            newArray[counter] = setArray[counter];
         }
         setArray = newArray;
         resizeflag = true;
      }
      return resizeflag;
   }

   /**
    * Returns the intersection of THIS set and the given other set
    * 
    * @param other SetClass data with which intersection is found
    * 
    * @return SetClass object with intersection of two sets
    *  #######################################################################unfixed
    */
   public SetClass findIntersection(SetClass other)
   {
      int counter;
      SetClass interSet = new SetClass();
      for(counter = 0; counter<arraySize; counter++) 
      {
         if(other.hasElement(setArray[counter])) 
         {
            interSet.addItem(other.setArray[counter]);
         }
      }
      return interSet;
   }

   /**
    * Returns the union of THIS set and the given other set
    * 
    * @param other SetClass data with which union is found
    * 
    * @return SetClass object with union of two sets
    */
   public SetClass findUnion(SetClass other)
   {
      int counter;
      SetClass unionSet = new SetClass(this);
      for(counter = 0; counter<other.arraySize; counter++) 
      {
         unionSet.addItem(other.setArray[counter]);
      }
      return unionSet;
   }

   /**
    * Finds relative complement of THIS set in given other set
    * <p>
    * Returns other set having removed any items intersecting with THIS set
    * 
    * @param other SetClass object from which THIS SetClass items will be removed
    * 
    * @return SetClass object with data as specified
    */
   public SetClass findRelativeComplementOfThisSetIn(SetClass other)
   {
      int counter = 0;
      while(counter<arraySize) 
      {
         if(other.hasElement(setArray[counter])) 
         {
            other.removeValue(setArray[counter]);
         }
         counter++;
      }
      return other;
   }

   /**
    * Seeks and finds prime starting at given value
    * 
    * @param value integer value to start search for prime
    * 
    * @return next prime number
    */
   private int getNextPrime(int value)
   {
      int testValue;
      testValue = value + 1;
      //to make sure we find it after the parameters value
      while(!isPrime(testValue)) 
      {
         testValue += 1;
      }
      return testValue;
   }

   /**
    * Tests to indicate if integer value is one of the set elements
    * 
    * @param testElement integer element to be found in set
    * 
    * @return boolean result of test
    */
   public boolean hasElement(int testElement)
   {
      int counter;
      boolean hasFlag = false;
      for(counter = 0; counter < arraySize; counter++)
      {
         if(setArray[counter] == testElement) 
         {
            hasFlag = true;
         }
      }
      return hasFlag;
   }

   /**
    * Tests for even, reports
    * 
    * @param value integer value to be tested
    * 
    * @return boolean result as specified
    */
   private boolean isEven(int value)
   {
      return (value%2)==0;
   }

   /**
    * Tests to indicate if set is subclass of another given set
    * 
    * @param other SetClass object to be tested if THIS set is a subset of it
    * 
    * @return boolean result of test
    * #######################################################################unfixed
    */
   public boolean isSubsetOf(SetClass other)
   {
      boolean returnflag = false;
      int thissetiterator = 0;
      int othersetiterator = 0;
      while(thissetiterator < arraySize && arraySize<other.arraySize && 
            othersetiterator < other.arraySize) 
      {
         if(other.setArray[othersetiterator]==setArray[thissetiterator]) 
         {
            thissetiterator += 1;
            othersetiterator += 1;
            returnflag = true;
         }
         else if(returnflag == false) 
         {
            othersetiterator += 1;
         }
         else if(!(thissetiterator == arraySize-1) && 
               othersetiterator == other.arraySize-1) 
         {
            returnflag = false;
            thissetiterator +=1;//quick exit
         }
         else if(returnflag == true) 
         {
            returnflag = false;
            thissetiterator = arraySize;//quick exit of loop
         }
      }
      return returnflag;
   }

   /**
    * Removes value at given index; moves all succeeding data down in array
    * 
    * @param indexToRemove integer index of element value to remove
    */
   private void removeAtIndex(int indexToRemove)
   {
      removeValue(setArray[indexToRemove]);
   }

   /**
    * Removes value if it is found in set
    * 
    * @param valToRemove integer value to be removed
    * 
    * @return boolean result of operation success
    */
   public boolean removeValue(int valToRemove)
   {
      int counter;
      boolean removalflag = false;
      if(hasElement(valToRemove)) 
      {
         counter = 0;
         while(!(setArray[counter] == valToRemove)) 
         {
            counter += 1;
         }
         removeAtIndex(counter);
         removalflag = true;
      }

      return removalflag;
   }

////////////////////////////////////////////////////////////////////////////////
// DO NOT MODIFY CODE BELOW THIS LINE (but you may use the methods)
////////////////////////////////////////////////////////////////////////////////
   /**
    * Tests to indicate if given integer value is prime
    * 
    * @param testVal integer value given
    * 
    * @return boolean result of test
    */
   private boolean isPrime(int testVal)
   {
      int modVal = 2;
      int testDivide = (int) (Math.ceil(Math.sqrt((double) testVal)));

      while (modVal <= testDivide)
      {
         if (testVal % modVal == 0)
         {
            return false;
         }

         modVal++;
      }

      return true;
   }

   /**
    * Loads a number of specified integers to set
    * <p>
    * Characteristics may be odd, even, incremented, or prime
    * <p>
    * Parameter four is only used with INCREMENTED
    * 
    * @param startValue          integer value indicates starting value
    * 
    * @param numItems            integer number of items to load
    * 
    * @param valueCharacteristic integer characteristic code (ODD, EVEN,
    *                            INCREMENTED, PRIME )
    * 
    * @param incrementBy         integer value used to specify increment if
    *                            INCREMENTED characteristic is set
    */
   public void loadItems(int startValue, int numItems, int valueCharacteristic, int incrementBy)
   {
      int index, runningValue = startValue;

      if (valueCharacteristic == ODD || valueCharacteristic == EVEN)
      {
         if (valueCharacteristic == ODD && isEven(runningValue) || valueCharacteristic == EVEN && !isEven(runningValue))
         {
            runningValue++;
         }

         for (index = 0; index < numItems; index++)
         {
            addItem(runningValue);

            runningValue += 2;
         }
      }

      else if (valueCharacteristic == PRIME)
      {
         // decrement by one for the first iteration
         runningValue--;

         for (index = 0; index < numItems; index++)
         {
            runningValue = getNextPrime(runningValue + 1);

            addItem(runningValue);
         }
      }

      else // assume incremented
      {
         for (index = 0; index < numItems; index++)
         {
            addItem(runningValue);

            runningValue += incrementBy;
         }
      }
   }

   /**
    * Provides list of set array elements as comma-delimited string
    */
   @Override
   public String toString()
   {
      int index;
      String outString = "";

      for (index = 0; index < arraySize; index++)
      {
         if (index > 0)
         {
            outString += ", ";
         }

         outString += setArray[index];
      }

      return outString;
   }

}