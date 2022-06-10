package p5_package;
/**
 * @author Alenn Wright
 */
public class SimpleQueueClass
{
   /**
    * DEFAULT_CAPACITY
    * Provides constant for default capacity
    */
   private final int DEFAULT_CAPACITY = 10;
   /**
    * FAILED_ACCESS
    * Provides constant -999999 for access failure messaging
    */
   public static final int FAILED_ACCESS = -999999;
   /**
    * capacity
    * Stores current capacity of stack class
    */
   private int capacity;
   /**
    * size
    * Stores current size of stack class
    */
   private int size;
   /**
    * headIndex
    * Stores queue head index
    */
   private int headIndex;
   /**
    * tailIndex
    * Stores queue tail index
    */
   private int tailIndex;
   /**
    * queueData
    * Integer array stores queue data
    */
   private int[] queueData;
   /**
    * SimpleQueueClass()
    * Default constructor
    */
   public SimpleQueueClass() 
   {
      capacity = DEFAULT_CAPACITY;
      size = 0;
      
   }
   /**
    * SimpleQueueClass(int capacitySetting)
    * Initialization constructor
    * 
    * @Param capacitySetting - initial capacity of queueData class
    */
   public SimpleQueueClass(int capacitySetting) 
   {
      capacity = capacitySetting;
      size = 0;
   }
   /**
    * SimpleQueueClass(SimpleQueueClass copied)
    * Copy constructor
    * Note: queue is copied so that head index is at zero and tail index 
    * is at size - 1; i.e., this resets the array to start at zero
    * 
    * @Param copied - SimpleQueueClass object to be copied
    */
   public SimpleQueueClass(SimpleQueueClass copied) 
   {
      capacity = copied.capacity;
      size = copied.size;
   }
   /**
    * enqueue(int newValue)
    * Checks for resize, then enqueues value
    * Note: Updates tail index, then appends value to array at tail index
    * 
    * @Param newValue - Value to be enqueued
    */
   public void enqueue(int newValue) 
   {
      checkForReSize();
      size++;
      tailIndex = size-1;
      queueData[tailIndex] = newValue;
      
   }
   /**
    * dequeue()
    * Removes and returns value from front of queue
    * Note: Acquires data from head of queue, then updates head index
    * 
    * @Return Value if successful, FAILED_ACCESS if not
    */
   public int dequeue() 
   {
      int removedvalue = FAILED_ACCESS;
      removedvalue = queueData[headIndex];
      updateHeadIndex();
      return removedvalue;
   }
   /**
    * peekFront()
    * Provides peek at front of queue
    * 
    * @Return Value if successful, FAILED_ACCESS if not
    */
   public int peekFront() 
   {
      int peekdatacontainer = FAILED_ACCESS;
      if(size > 0) 
      {
         peekdatacontainer = queueData[headIndex];
      }
      return peekdatacontainer;
   }
   /**
    * isEmpty()
    * Reports queue empty state
    * Note: Does not use if/else
    * 
    * @Return Boolean evidence of empty list
    */
   public boolean isEmpty() 
   {
      return size == 0;
   }
   /**
    * checkForReSize()
    * Checks for resize and resizes to twice the current capacity if needed
    * Note: Returns true if resize is necessary and is conducted; returns false
    *  if no action is taken
    *  
    *  Update: This method must transfer the data into the array such that 
    *  the resized array starts with a head index of zero and a tail index
    *   of size - 1
    *   
    *   @Return success of operation
    */
   private boolean checkForReSize() 
   {
      boolean resizeflag = false;
      int counter;
      int[] newArray;
      if(size == capacity)
      {
         capacity = capacity*2;
         newArray = new int[capacity];
         for(counter = 0; counter < size; counter++) 
         {
            newArray[counter] = queueData[counter];
         }
         queueData = newArray;
         resizeflag = true;
      }
      return resizeflag;
   }
   /**
    * clear()
    * Clears the queue by setting the size to zero, the tail index to -1 and 
    * the head index to zero
    */
   public void clear() 
   {
      size = 0;
      tailIndex = -1;
      headIndex = 0;
   }
   /**
    * updateHeadIndex()
    * Updates queue head index to wrap around array as needed
    * Note: Does not use if/else
    */
   private void updateHeadIndex() 
   {
      
      updateTailIndex();
      headIndex = 0;
   }
   /**
    * updateTailIndex()
    * Updates queue tail index to wrap around array as needed
    * Note: Does not use if/else
    */
   private void updateTailIndex() 
   {
      int counter;
      int[] newArray;
      newArray = new int[capacity];
      for(counter = 0; counter < tailIndex; counter++) 
      {
         newArray[counter] = queueData[counter];
      }
      queueData = newArray;
      tailIndex -= 1;
   }
}
