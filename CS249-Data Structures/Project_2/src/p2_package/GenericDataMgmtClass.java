package p2_package;

public class GenericDataMgmtClass<GenericData extends Comparable<GenericData>>
{
   /**
    * The class is GenericDataMgmtClass and it allows us to manipulate a
    * one dimensional array with sorting algoriths and basic list operations
    * @author Alenn Wright
    * @since 1/27/2021
    * @variable DEFAULT_CAPACITY This constant holds a default value of 10 and 
    * is a private and static
    * @variable arrayCapacity This is a private integer that holds the max size
    *  of the array
    * @variable arraySize This private integer holds the size of the data we 
    * care about in the list
    * @variable localArray This GenericData list is the main array for this data 
    * structure and holds our data
    * */
   private static final int DEFAULT_CAPACITY = 10;
   private Object[] localArray;
   private int arraySize;
   private int arrayCapacity;

   /**
    * GenericDataMgmtClass() Takes no parameters and sets an array size and 
    * capacity to the default of 10
    * It returns nothing
    * */
   public GenericDataMgmtClass()
   {
      arraySize = 0;
      arrayCapacity = DEFAULT_CAPACITY;
      localArray = new Object[arrayCapacity];
   }

   /**
    * GenericDataMgmtClass(int capacity) takes in capacity and sets it as the 
    * size of the local array and sets it as the array capacity
    * @param capacity This is a users desired size of the arrays capacity
    * */
   public GenericDataMgmtClass(int capacity)
   {
      arraySize = 0;
      arrayCapacity = capacity;
      localArray = new Object[arrayCapacity];
   }

   /**
    * accessItemAt(int accessIndex) is a method that returns the item at an 
    * index
    * @param accessIndex is an integer that is an index of the list the user 
    * wishes for data from
    * @return localArray[accessIndex] if accessIndex is between 0 - arraysize
    * @return null
    * */
   @SuppressWarnings("unchecked")
   public GenericData accessItemAt(int accessIndex)
   {
      if (accessIndex < arraySize)
      {
         return (GenericData) localArray[accessIndex];
      } else
      {
         return null;
      }
   }

   /**
    * appendItem(int newValue) adds in an new object at the end of the array
    * @param newValue is a object we want to add in the list
    * @return true if it works
    * @return false if it fails
    * */
   public boolean appendItem(GenericData newValue)
   {
      if (isFull())
      {
         return false;
      } else
      {
         localArray[arraySize] = (GenericData) newValue;
         arraySize += 1;
         return true;
      }
   }

   /**
    * clear() sets size to 0 disreguarding the rest of the array with no input 
    * or output
    * */
   public void clear()
   {
      arraySize = 0;
   }

   /**
    * getCurrentCapacity() returns the array capacity
    * @return arrayCapacuty give the user the capacity of the array
    * */
   public int getCurrentCapacity()
   {
      return arrayCapacity;
   }

   /**
    * getCurrentSize() gives the user the size of the array
    * @return arraysize the size of the array
    * */
   public int getCurrentSize()
   {
      return arraySize;
   }

   /**
    * insertData(int insertIndex, GenericData newValue) inputs a value at an 
    * index and shifts all the information down increasing the size if in 
    * capacity
    * @param insertIndex is an integer that addresses an index of the array
    * @param newValue is the object put in the index specified
    * @return true if it worked
    * @return false if input invalid
    * */
   @SuppressWarnings("unchecked")
   public boolean insertData(int insertIndex, GenericData newValue)
   {
      GenericData holder;
      if ((insertIndex >= arraySize) || isFull())
      {
         return false;
      } else if (insertIndex == arraySize)
      {
         localArray[insertIndex] = newValue;
         arraySize++;
         return true;
      } else
      {
         holder = (GenericData) localArray[insertIndex];
         localArray[insertIndex] = newValue;
         return insertData(insertIndex + 1, holder);
      }
   }

   /**
    * isEmpty() tells if the array is empty
    * @return true if empty
    * @return false if not
    * */
   public boolean isEmpty()
   {
      return arraySize == 0;
   }

   /**
    * isFull() tells if the array is full
    * @return true if full
    * @return false if not
    * */
   public boolean isFull()
   {
      return arraySize == arrayCapacity;
   }

   /**
    * removeData(int removeIndex) removes a object at an index and decrements 
    * the size
    * @param removeIndex is an integer that defines a valid index
    * @return removedData the value of the removed value
    * @return null if not a valid Index
    * */
   @SuppressWarnings("unchecked")
   public GenericData removeData(int removeIndex)
   {
      int index;
      GenericData removedData = null;
      if (removeIndex < getCurrentSize())
      {
         removedData = (GenericData) localArray[removeIndex];
         for (index = removeIndex; index < this.arraySize; index++)
         {
            localArray[index] = localArray[index + 1];
         }
         this.arraySize -= 1;
      }
      return removedData;
   }

   /**
    * resize(int newCapacity) resizes the local array and copies the values in 
    * the size of the array while not allowing it to decrease in capacity
    * @param newCapacity is the integer size of new size
    * @return true if resize worked
    * @return false if resize not valid
    * */
   public boolean resize(int newCapacity)
   {
      int counter;
      Object[] newArray = new Object[newCapacity];
      if (arrayCapacity <= newCapacity)
      {
         return false;
      } else
      {
         arrayCapacity = newCapacity;
         newArray = new Object[arrayCapacity];
         for (counter = 0; counter < arraySize; counter++)
         {
            newArray[counter] = localArray[counter];
         }
         localArray = newArray;
         return true;
      }
   }

   /**
    * runBubbleSort() sorts the Generic Data utilizing the object Compare to 
    * function. Bubble sorts my swapping 2 elements based on greater or less 
    * value and iterates through the method untill its sorted
    */
   @SuppressWarnings("unchecked")
   public void runBubbleSort()
   {
      int index, comparedResult, iterationcounter;
      GenericData thisObject, nextObject;
      iterationcounter = 0;
      while (iterationcounter < arraySize - 1)
      {
         for (index = 0; index < arraySize - 1; index++)
         {
            thisObject = (GenericData) localArray[index];
            nextObject = (GenericData) localArray[index + 1];
            comparedResult = thisObject.compareTo(nextObject);

            if (comparedResult > 0)
            {
               swapElements(index + 1, index);
            }

         }
         iterationcounter++;
      }
   }

   /**
    * runInsertionSort() finds the biggest value then puts the smaller value
    * at the beggining of the list
    */
   @SuppressWarnings("unchecked")
   public void runInsertionSort()
   {
      int index, comparedResult, iterationcounter;
      GenericData thisObject, nextObject;
      iterationcounter = 0;
      while (iterationcounter < arraySize)
      {
         thisObject = (GenericData) localArray[iterationcounter];
         for (index = 0; index < iterationcounter-1; index++)
         {
            nextObject = (GenericData) localArray[index];
            comparedResult = thisObject.compareTo(nextObject);

            if (comparedResult < 0)
            {
               swapElements(index, iterationcounter);
            }

         }
         iterationcounter++;
      }
   }

   /**
    * runSelectionSort() finds the smaller value and then swaps its position 
    * with the next index in the array
    */
   @SuppressWarnings("unchecked")
   public void runSelectionSort()
   {
      int outerIndex, innerIndex, lowIndex, comparedResult;
      GenericData nextObject, thisObject;

      for (outerIndex = 0; outerIndex < arraySize - 1; outerIndex++)
      {
         lowIndex = outerIndex;
         for (innerIndex = lowIndex + 1; innerIndex < arraySize; innerIndex++)
         {
            thisObject = (GenericData) localArray[lowIndex];
            nextObject = (GenericData) localArray[innerIndex];
            comparedResult = nextObject.compareTo(thisObject);
            if (comparedResult < 0)
            {
               lowIndex = innerIndex;
            }
         }
         swapElements(outerIndex, lowIndex);
      }
   }

   /**
    * Uses Shell's sorting algorithm to sort Generic Data in an array of Objects
    * <p>
    * Shell's sorting algorithm is an optimized insertion algorithm
    */
   @SuppressWarnings("unchecked")
   public void runShellSort()
   {
      int gap, gapPassIndex, insertionIndex;
      GenericData tempItem, testItem;
      boolean continueSearch;

      for (gap = arraySize / 2; gap > 0; gap /= 2)
      {
         for (gapPassIndex = gap; gapPassIndex < arraySize; gapPassIndex++)
         {
            tempItem = (GenericData) localArray[gapPassIndex];

            insertionIndex = gapPassIndex;

            continueSearch = true;

            while (continueSearch && insertionIndex >= gap)
            {
               testItem = (GenericData) localArray[insertionIndex - gap];

               if (testItem.compareTo(tempItem) > 0)
               {
                  localArray[insertionIndex] = localArray[insertionIndex - gap];

                  insertionIndex -= gap;
               }

               else
               {
                  continueSearch = false;
               }

            } // end search loop

            localArray[insertionIndex] = tempItem;
         } // end list loop

      } // end gap size setting loop

   }

   /** 
    * Swaps one element in the local array at a given index 
    * with another element in the array at the other given element
    * 
    * @param oneIndex index of one of two elements to be swapped
    * 
    * @param otherIndex index of second of two elements to be swapped
    */
   @SuppressWarnings("unchecked")
   private void swapElements(int oneIndex, int otherIndex)
   {
      GenericData holder;
      holder = (GenericData) localArray[oneIndex];
      localArray[oneIndex] = localArray[otherIndex];
      localArray[otherIndex] = holder;
   }
}
