package p6_package;
/**
 * @author Alenn Wright
 * @Date 2/24/21
 * 
 * public class IteratorClass
 * extends BasicArrayClass
 * 
 * Iterator class inherited from BasicArrayClass; conducts iterator operations
 */
public class IteratorClass extends BasicArrayClass
{
   /**
    * private final char SPACE
    * 
    * Constant character for display
    */
   private final char SPACE = 32;
   /**
    * private final char LEFT_BRACKET
    * 
    * Constant character for display
    */
   private final char LEFT_BRACKET = 91;
   /**
    * private final char RIGHT_BRACKET
    * 
    * Constant character for display
    */
   private final char RIGHT_BRACKET = 93;
   /**
    * private int currentIndex
    * 
    * Current index of iterator
    */
   private int currentIndex;

   /**
    * public IteratorClass()
    * 
    * Default constructor for IteratorClass
    */
   public IteratorClass() 
   {
      super();
      currentIndex = 0;
   }
   /**
    * public IteratorClass(int initCapacity)
    * 
    * Initialization constructor for IteratorClass
    * 
    * @Param initCapacity - integer value at which to set initial 
    * array capacity
    */
   public IteratorClass(int initCapacity)
   {
      super(initCapacity);
      currentIndex = 0;
   }
   /**
    * public IteratorClass(IteratorClass copied)
    * 
    * Copy constructor for IteratorClass
    * 
    * @Param copied - IteratorClass object to be copied
    */
   public IteratorClass(IteratorClass copied)
   {
      super(copied);
      currentIndex = copied.currentIndex;
   }

   /**
    * public void clear()
    * 
    * Clears array
    */
   public void clear()
   {
      super.clear();
   }
   /**
    * public int getAtCurrent()
    * 
    * Gets value at iterator cursor location
    * 
    * @Return integer value returned; FAILED_ACCESS if not found
    */
   public int getAtCurrent()
   {
      return super.getAtIndex(currentIndex);
   }
   /**
    * public boolean isAtFirstElement()
    * 
    * Reports if iterator cursor is at first element
    * Must consider whether list is empty
    * 
    * @Return Boolean result of action; true if at beginning, false otherwise
    */
   public boolean isAtFirstElement()
   {
      if(isEmpty()) 
      {
         return false;
      }
      else if(currentIndex == 0) 
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
   /**
    * public boolean isAtLastElement()
    * 
    * Reports if iterator cursor is at last element
    * Must consider whether list is empty
    * 
    * @Return Boolean result of action; true if at end, false otherwise
    */
   public boolean isAtLastElement()
   {
      if(isEmpty()) 
      {
         return false;
      }
      else if(currentIndex == super.getCurrentSize()-1) 
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
   /**
    * public boolean isEmpty()
    * 
    * Reports if list is empty
    * 
    * Overrides:
    * isEmpty in class BasicArrayClass
    * 
    * @Return Boolean result of action; true if empty, false otherwise
    */
   public boolean isEmpty()
   {
      return super.isEmpty();
   }
   /**
    * public boolean moveNext()
    * 
    * If possible, moves iterator cursor one position to the right, or next
    * 
    * Must consider whether list is empty
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean moveNext()
   {
      if(isEmpty()) 
      {
         return false;
      }
      else if(currentIndex < super.getCurrentSize()-1) 
      {
         currentIndex+=1;
         return true;
      }
      else 
      {
         return false;
      }
   }
   /**
    * public boolean movePrev()
    * 
    * If possible, moves iterator cursor one position to the left, or previous
    * 
    * Must consider whether list is empty
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean movePrev()
   {
      if(isEmpty()) 
      {
         return false;
      }
      else if(currentIndex > 0) 
      {
         currentIndex-=1;
         return true;
      }
      else 
      {
         return false;
      }
   }
   /**
    * public int removeAtCurrent()
    * 
    * Removes and returns a data value from the iterator cursor position
    * Note: cursor must be located at succeeding element unless last item removed
    * 
    * @Return integer value removed from list, or FAILED_ACCESS if not found
    */
   public int removeAtCurrent()
   {
      return super.removeAtIndex(currentIndex);
   }
   /**
    * public boolean replaceAtCurrent(int newValue)
    * 
    * Replaces value at iterator cursor with new value
    * 
    * @Param newValue - integer value to be inserted in list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean replaceAtCurrent(int newValue)
   {
      return super.setAtIndex(currentIndex, newValue, REPLACE);
   }
   /**
    * public void runDiagnosticDisplay()
    * Shows space-delimited list with cursor location indicated
    */
   public void runDiagnosticDisplay()
   {
      int arrayprintcounter = 0;
      while(arrayprintcounter<super.getCurrentSize()) 
      {
         if(arrayprintcounter == currentIndex) 
         {
            if(super.getCurrentSize() == 1 || 
                  currentIndex== super.getCurrentSize()-1) 
            {
               System.out.print(LEFT_BRACKET);
               System.out.print(super.getAtIndex(arrayprintcounter));
               System.out.println(RIGHT_BRACKET);
            }
            else 
            {
               System.out.print(LEFT_BRACKET);
               System.out.print(super.getAtIndex(arrayprintcounter));
               System.out.print(RIGHT_BRACKET);
               System.out.print(",");
               System.out.print(SPACE);
            }
         }
         else if(arrayprintcounter == super.getCurrentSize()-1)
         {
            System.out.println(super.getAtIndex(arrayprintcounter));
         }
         else 
         {
            System.out.print(super.getAtIndex(arrayprintcounter));
            System.out.print(",");
            System.out.print(SPACE);
         }
         arrayprintcounter+=1;
      }
   }
   /**
    * public boolean setAfterCurrent(int newValue)
    * 
    * Inserts new value after value at iterator cursor
    * Note: Current value must remain the same after data set
    * 
    * @Param newValue - integer value to be inserted in list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean setAfterCurrent(int newValue)
   {
      return super.setAtIndex(currentIndex, newValue, INSERT_AFTER);
   }
   /**
    * public boolean setBeforeCurrent(int newValue)
    * 
    * Inserts new before value at iterator cursor
    * Note: Current value must remain at the same index after data set
    * 
    * @Param newValue - integer value to be inserted in list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean setBeforeCurrent(int newValue)
   {
      currentIndex +=1;
      return super.setAtIndex(currentIndex-1, newValue, INSERT_BEFORE);
   }
   /**
    * public boolean setToFirstElement()
    * Sets iterator cursor to beginning of list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean setToFirstElement()
   {
      if(isEmpty()) 
      {
         return false;
      }
      else 
      {
         currentIndex = 0;
         return true;
      }
   }
   /**
    * public boolean setToLastElement()
    * 
    * Sets iterator cursor to the end of the list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean setToLastElement()
   {
      if(isEmpty()) 
      {
         return false;
      }
      else 
      {
         currentIndex = super.getCurrentSize()-1;
         return true;
      }
   }
}
