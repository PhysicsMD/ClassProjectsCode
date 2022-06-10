package p5_package;
/**
 * @author Alenn Wright
 */
public class SimpleStackClass
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
    * stackTopIndex
    * Stores stack top index
    */
   private int stackTopIndex;
   /**
    * stackData
    * Integer array stores stack data
    */
   private int[] stackData;
   /**
    * SimpleStackClass()
    * Default constructor
    */
   public SimpleStackClass() 
   {
      capacity = DEFAULT_CAPACITY;
      size = 0;
      stackData = new int[capacity];
      stackTopIndex = -1;
   }
   /**
    * SimpleStackClass(int capacitySetting)
    * Initialization constructor
    * 
    * @Param capacitySetting - initial capacity of stackData class
    */
   public SimpleStackClass(int capacitySetting) 
   {
      capacity = capacitySetting;
      size = 0;
      stackData = new int[capacity];
      stackTopIndex = -1;
   }
   /**
    * SimpleStackClass(SimpleStackClass copied)
    * Copy constructor
    * 
    * @Param copied - SimpleStackClass object to be copied
    */
   public SimpleStackClass(SimpleStackClass copied) 
   {
      capacity = copied.capacity;
      size = copied.size;
      stackData = copied.stackData;
      stackTopIndex = copied.stackTopIndex;
   }
   /**
    * isEmpty()
    * Reports stack empty status
    * Note: Does not use if/else
    * 
    * @Returns Boolean evidence of empty list
    */
   public boolean isEmpty() 
   {
      return size == 0;
   }
   /**
    * push(int newValue)
    * Checks for resize, then pushes value onto stack
    * Note: end of array is always the top of the stack; 
    * index is incremented and then value is appended to array
    * 
    * @Param newValue - Value to be pushed onto stack
    */
   public void push(int newValue) 
   {
      checkForReSize();
      stackTopIndex +=1;
      size+=1;
      stackData[stackTopIndex] = newValue;
   }
   /**
    * pop()
    * Removes and returns data from top of stack
    * 
    * @Return value if successful, FAILED_ACCESS if not
    */
   public int pop() 
   {
      int popdatacontainer = FAILED_ACCESS;
      if(stackTopIndex > -1) 
      {
         stackTopIndex -=1;
         size-=1;
         popdatacontainer = stackData[stackTopIndex+1];
      }
      return popdatacontainer;
   }
   /**
    * peekTop()
    * provides peek at top of stack
    * 
    * @Return value if successful, FAILED_ACCESS if not
    */
   public int peekTop() 
   {
      int peekdatacontainer = FAILED_ACCESS;
      if(stackTopIndex > -1) 
      {
         peekdatacontainer = stackData[stackTopIndex];
      }
      return peekdatacontainer;
   }
   /**
    * checkForReSize()
    * Checks for resize and resizes to twice the current capacity if needed
    * Note: Returns true if resize is necessary and is conducted; 
    * returns false if no action is taken
    * 
    * @Returns: success of operation
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
            newArray[counter] = stackData[counter];
         }
         stackData = newArray;
         resizeflag = true;
      }
      return resizeflag;
   }
   /**
    * clear() 
    * Clears stack by setting size to zero and top index to negative one
    */
   public void clear() 
   {
      size = 0;
      stackTopIndex = -1;
   }
}
