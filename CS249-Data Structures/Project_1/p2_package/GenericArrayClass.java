package p2_package;

public class GenericArrayClass<GenericData extends Comparable<GenericData>>
{
   /**
    * The class is GenericArrayClass and it allows us to manipulate a
    * one dimensional array with secured bounds of GenericData
    * @author Alenn Wright
    * @since 2/5/20
    * @variable DEFAULT_CAPACITY This constant holds a default value of 10 and 
    * is a private and static
    * @variable arrayCapacity This is a private integer that holds the max size
    *  of the array
    * @variable arraySize This private integer holds the size of the data we 
    * care about in the list
    * @variable localArray This GenericData list is the main array for this data 
    * structure and holds our data
    * @variable iterator This is a static variable to reduce the space used by 
    * declaring it
    * */
   private int arrayCapacity;
   private int arraySize;
   private final static int DEFAULT_CAPACITY = 10;
   private Object[] localArray;
   public int iterator;
   
   /**
    * GenericArrayClass() Takes no parameters and sets an array size and 
    * capacity to the default of 10
    * It returns nothing
    * */
   
   public GenericArrayClass()
   {
      localArray = new Object[DEFAULT_CAPACITY];
      arrayCapacity = DEFAULT_CAPACITY;
      arraySize = 0;
   }
   
   /**
    * GenericArrayClass(int capacity) takes in capacity and sets it as the 
    * size of the local array and sets it as the array capacity
    * @param capacity This is a users desired size of the arrays capacity
    * */
   
   public GenericArrayClass(int capacity)
   {
      localArray = new Object[capacity];
      arrayCapacity = capacity;
      arraySize = 0;
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
      if ((0 < accessIndex)||(accessIndex < this.arraySize)) 
      {
         return (GenericData)localArray[accessIndex];
      } 
      else 
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
      if (this.arraySize == this.arrayCapacity) 
      {
         return false;
      } 
      else 
      {
         this.localArray[this.arraySize] = newValue;
         this.arraySize += 1;
         return true;
      }
   }
   
   /**
    * clear() sets size to 0 disreguarding the rest of the array with no input 
    * or output
    * */
   
   public void clear()
   {
      this.arraySize = 0;
   }
   
   /**
    * getCurrentCapacity() returns the array capacity
    * @return arrayCapacuty give the user the capacity of the array
    * */
   
   public int getCurrentCapacity()
   {
      return this.arrayCapacity;
   }
   
   /**
    * getCurrentSize() gives the user the size of the array
    * @return arraysize the size of the array
    * */
   
   public int getCurrentSize()
   {
      return this.arraySize;
   }
   
   /**
    * insertItemAt(int insertIndex, int newValue) inputs a value at an index 
    * and shifts all the information down increasing the size if in capacity
    * @param insertIndex is an integer that addresses an index of the array
    * @param newValue is the object put in the index specified
    * @return true if it worked
    * @return false if input invalid
    * */
   
   public boolean insertItemAt(int insertIndex, GenericData newValue)
   {
      if ((insertIndex > this.arraySize)||(insertIndex < 0)) 
      {
         return false;
      } 
      else 
      {
         for (iterator = insertIndex; iterator <= this.arraySize; iterator++) 
         {
            this.localArray[iterator] = this.localArray[iterator + 1];
         }
         this.localArray[insertIndex] = newValue;
         this.arraySize += 1;
         return true;
      }
   }
   
   /**
    * isEmpty() tells if the array is empty
    * @return true if empty
    * @return false if not
    * */
   
   public boolean isEmpty()
   {
      if (this.arraySize == 0) 
      {
         return true;
      } 
      else 
      {
         return false;
      }
   }
   
   /**
    * isFull() tells if the array is full
    * @return true if full
    * @return false if not
    * */
   
   public boolean isFull()
   {
      if (this.arraySize == this.arrayCapacity) 
      {
         return true;
      } 
      else 
      {
         return false;
      }
   }
   
   /**
    * removeItemAt(int removeIndex) removes a object at an index and decrements 
    * the size
    * @param removeIndex is an integer that defines a valid index
    * @return removed the value of the removed value
    * @return null if not a valid Index
    * */
   @SuppressWarnings("unchecked")
   public GenericData removeItemAt(int removeIndex)
   {
      GenericData removed;
      if ((removeIndex > this.arraySize)||(removeIndex < 0)) 
      {
         return null;
      } 
      else 
      {
         removed = (GenericData)this.localArray[removeIndex];
         for (iterator = removeIndex; iterator <= this.arraySize; iterator++) 
         {
            this.localArray[iterator] = this.localArray[iterator + 1];
         }
         this.arraySize -= 1;
         return removed;
      }
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
      if ((this.arrayCapacity >= newCapacity)||(newCapacity < 0)) 
      {
         return false;
      } 
      else 
      {
         this.arrayCapacity = newCapacity;
         java.lang.Object[] newArray = new java.lang.Object[this.arrayCapacity];
         for (iterator = 0; iterator <= this.arraySize; iterator++) 
         {
            newArray[iterator] = this.localArray[iterator];
         }
         this.localArray = newArray;
         return true;

      }
   }
   
   /**
    * runBubbleSort() sorts the Generic Data utilizing the object Compare to 
    * function. Bubble sorts my swapping 2 elements based on greater or less 
    * value and iterates through the method untill its sorted
    */
   @SuppressWarnings( "unchecked" )
   public void runBubbleSort()
   {
      GenericData holder = null;
      GenericData holder2;
      int loopsCompleted = 0;
      iterator = 0;
      while(loopsCompleted < this.arraySize) 
      {
         while(iterator < (this.arraySize-loopsCompleted)) 
         {
            holder = (GenericData)localArray[iterator];
            holder2 = (GenericData)localArray[iterator+1];
            if((holder.compareTo(holder2))>= 0) 
            {
               swapElements( iterator, iterator + 1);
            }
            iterator += 1;
         }
         loopsCompleted += 1;
      }
   }
   
   /**
    * runInsertionSort() finds the biggest value then puts the smaller value
    * at the beggining of the list
    */
   @SuppressWarnings( "unchecked" )
   public void runInsertionSort()
   {
      int loopsCompleted = 0;
      iterator = 0;
      GenericData holder = null;
      GenericData holder2;
      boolean swap = false;
      while(loopsCompleted < this.arraySize) 
      {
         while(iterator < this.arraySize) 
         {
            holder2 = (GenericData)localArray[iterator];
            if((holder2.compareTo(holder))>= 0) 
            {
               holder = (GenericData)localArray[iterator];
               swap = true;
            }
            iterator += 1;
         }
         if(swap) 
         {
            insertItemAt(0, holder);
         }
         swap = false;
         loopsCompleted += 1;
         iterator = loopsCompleted;
      }
   }
   
   /**
    * runSelectionSort() finds the smaller value and then swaps its position 
    * with the next index in the array
    */
   @SuppressWarnings( "unchecked" )
   public void runSelectionSort()
   {
      int loopsCompleted = 0;
      iterator = 0;
      GenericData holder = null;
      GenericData holder2;
      while(loopsCompleted < this.arraySize) 
      {
         while(iterator < this.arraySize) 
         {
            if(loopsCompleted == 0) 
            {
               holder = (GenericData)localArray[iterator];
            }
            holder2=(GenericData)localArray[iterator];
            if((holder2.compareTo(holder))>= 0) 
            {
               holder = (GenericData)localArray[iterator];
            }
            swapElements(loopsCompleted, iterator);
            iterator+=1;
         }
         loopsCompleted+=1;
         iterator = loopsCompleted;
      }
   }
   
   /** 
    * Swaps one element in the local array at a given index 
    * with another element in the array at the other given element
    * 
    * @param oneIndex index of one of two elements to be swapped
    * 
    * @param otherIndex index of second of two elements to be swapped
    */
   
   private void swapElements( int oneIndex, int otherIndex )
      {
       Object temp = localArray[oneIndex];
       
       localArray[oneIndex] = localArray[otherIndex];
       
       localArray[otherIndex] = temp;
      }
   
   /**
    * Uses Shell's sorting algorithm to sort an array of integers
    * <p>
    * Shell's sorting algorithm is an optimized insertion algorithm
    * 
    * <p>
    * Note: Creates new StudentClass array, sorts contents of array, 
    * and returns the sorted result; 
    * does not modify (this) object student array
    * 
    * @return new StudentClass array with sorted items
    */
   @SuppressWarnings( "unchecked" )
   public void runShellSort()
      {
       int gap, gapPassIndex, insertionIndex;
       GenericData tempItem, testItem;
       boolean continueSearch;
    
       for( gap = arraySize / 2; gap > 0; gap /= 2 )
          {
           for( gapPassIndex = gap; 
                                  gapPassIndex < arraySize; gapPassIndex++ )
              {
               tempItem = (GenericData)localArray[ gapPassIndex ];

               insertionIndex = gapPassIndex;

               continueSearch = true;
               
               while( continueSearch && insertionIndex >= gap )
                  {
                   testItem 
                          = (GenericData)localArray[ insertionIndex - gap ];
                   
                   if( testItem.compareTo( tempItem ) >  0 )
                      {
                       localArray[ insertionIndex ] 
                                       = localArray[ insertionIndex - gap ];  
                    
                       insertionIndex -= gap;
                      }
                  
                   else
                      {
                       continueSearch = false;
                      }
                   
                  }  // end search loop

               localArray[ insertionIndex ] = tempItem;
              }  // end list loop
       
          }  // end gap size setting loop   
   
      }
   
}
