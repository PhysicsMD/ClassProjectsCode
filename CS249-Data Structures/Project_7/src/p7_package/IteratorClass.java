package p7_package;
/**
 * 
 * @author Alenn Wright
 *
 *public class IteratorClass extends Object
 *
 *Iterator class uses BasicLLClass, conducts iterator operations
 */
public class IteratorClass extends Object
{
   /*
    * private final char SPACE
    * 
    * Constant character for display
    */
   private final char SPACE = ' ';
   /*
    * private final char LEFT_BRACKET
    * 
    * Constant character for display
    */
   private final char LEFT_BRACKET = '[';
   /*
    * private final char RIGHT_BRACKET
    * 
    * Constant character for display
    */
   private final char RIGHT_BRACKET = ']';
   /*
    * private int currentIndex
    * 
    * Current index of iterator
    */
   private int currentIndex;
   /*
    * BasicLLClass llData
    * 
    * Basic Linked list engine
    */
   BasicLLClass llData;
   /*
    * public IteratorClass()
    * 
    * Default constructor for IteratorClass
    */
   public IteratorClass() 
   {
      llData = new BasicLLClass();
      currentIndex = 0;
   }
   /*
    * public IteratorClass(IteratorClass copied)
    * 
    * Copy constructor for IteratorClass
    * 
    * @Param copied - IteratorClass object to be copied
    */
   public IteratorClass(IteratorClass copied) 
   {
      currentIndex = copied.currentIndex;
      llData = new BasicLLClass(copied.llData);
   }
   /*
    * public void clear()
    * 
    * Clears data
    */
   public void clear() 
   {
      currentIndex = 0;
      llData.clear();
   }
   /*
    * public int getAtCurrent()
    * 
    * Gets value at iterator cursor location
    * 
    * @Return integer value returned; FAILED_ACCESS if not found
    */
   public int getAtCurrent() 
   {
      return llData.getAtIndex(currentIndex);
   }
   /*
    * public boolean isAtFirstElement()
    * 
    * Reports if iterator cursor is at first element
    * 
    * Must consider whether list is empty
    * 
    * Return Boolean result of action; true if at beginning, false otherwise
    */
   public boolean isAtFirstElement() 
   {
      return currentIndex == 0;
   }
   /*
    * public boolean isAtLastElement()
    * 
    * Reports if iterator cursor is at last element
    * 
    * Must consider whether list is empty
    * 
    * @Return Boolean result of action; true if at end, false otherwise
    */
   public boolean isAtLastElement() 
   {
      return llData.getCurrentSize()-1 == currentIndex; 
   }
   /*
    * public boolean isEmpty()
    * 
    * Reports if list is empty
    * 
    * @Return Boolean result of action; true if empty, false otherwise
    */
   public boolean isEmpty() 
   {
      return llData.isEmpty();
   }
   /*
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
      if(isEmpty() || isAtLastElement()) 
      {
         return false;
      }
      else 
      {
         currentIndex += 1;
         return true;
      }
   }
   /*
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
      if(isAtFirstElement()||isEmpty()) 
      {
         return false;
      }
      currentIndex -= 1;
      return true;
   }
   /*
    * public int removeAtCurrent()
    * 
    * Removes and returns a data value from the iterator cursor position
    * 
    * Note: cursor must be located at succeeding element unless last 
    * item removed
    * 
    * @Return integer value removed from list, or FAILED_ACCESS if not found
    */
   public int removeAtCurrent() 
   {
      currentIndex -=1;
      return llData.removeAtIndex(currentIndex+1);
   }
   /*
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
      return llData.setAtIndex(currentIndex,newValue, BasicLLClass.REPLACE);
   }
   /*
    * public void runDiagnosticDisplay()
    * 
    * Shows space-delimited list with cursor location indicated
    */
   public void runDiagnosticDisplay() 
   {
      int arrayprintcounter = 0;
      while(arrayprintcounter<llData.getCurrentSize()) 
      {
         if(arrayprintcounter == currentIndex) 
         {
               System.out.print(LEFT_BRACKET);
               System.out.print(llData.getAtIndex(arrayprintcounter));
               System.out.print(RIGHT_BRACKET);
               System.out.print(SPACE);
         }
         else 
         {
            System.out.print(llData.getAtIndex(arrayprintcounter));
            System.out.print(SPACE);
         }
         arrayprintcounter+=1;
      }
      System.out.println();
   }
   /*
    * public boolean setAfterCurrent(int newValue)
    * 
    * Inserts new value after value at iterator cursor
    * 
    * Note: Current value must remain the same after data set
    * 
    * @Param newValue - integer value to be inserted in list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean setAfterCurrent(int newValue) 
   {
      if(currentIndex<0) 
      {
         currentIndex+=1;
         llData.setAtIndex(currentIndex,newValue, 
               BasicLLClass.INSERT_AFTER);
         return true;
      }
      else if(llData.setAtIndex(currentIndex,newValue, 
            BasicLLClass.INSERT_AFTER)) 
      {
         return movePrev();
      }
      else
      {
         return false;
      }
   }
   /*
    * public boolean setBeforeCurrent(int newValue)
    * 
    * Inserts new before value at iterator cursor
    * 
    * Note: Current value must remain at the same index after data set
    * 
    * @Param newValue - integer value to be inserted in list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean setBeforeCurrent(int newValue) 
   {
      if(llData.setAtIndex(currentIndex,newValue, 
            BasicLLClass.INSERT_BEFORE)) 
      {
         return moveNext();
      }
      else 
      {
         return false;
      }
   }
   /*
    * public boolean setToFirstElement()
    * 
    * Sets iterator cursor to beginning of list
    * 
    * @Return Boolean result of action; true if successful, false otherwise
    */
   public boolean setToFirstElement() 
   {
      currentIndex = 0;
      return !isEmpty();
   }
   /*
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
         currentIndex = 0;
         return false;
      }
      else 
      {
         currentIndex = llData.getCurrentSize()-1;
         return true;
      }
   }
}
