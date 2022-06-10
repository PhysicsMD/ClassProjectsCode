package p7_package;
/**
 * 
 * @author Alenn Wright
 *
 *public class BasicLLClass extends Object
 *
 *Description: Class wrapper for a Java linked list, with management 
 *operations that make it appear to be an array
 */
public class BasicLLClass extends Object
{
   /*
    * public static final int FAILED_ACCESS
    * 
    * Default failed access constant
    */
   public static final int FAILED_ACCESS = -999999;
   /*
    * public static final int REPLACE
    * 
    * Constant used for allowing setAtIndex to replace value at index
    */
   public static final int REPLACE = 1001;
   /*
    * public static final int INSERT_BEFORE
    * 
    * Constant used for allowing setAtIndex to insert value at index
    */
   public static final int INSERT_BEFORE = 1002;
   /*
    * public static final int INSERT_AFTER
    * 
    * Constant used for allowing setAtIndex to insert value at index
    */
   public static final int INSERT_AFTER = 1003;
   /*
    * public static final int REMOVE
    * 
    * Constant used for allowing accessAtIndex to remove an item
    */
   public static final int REMOVE = 1004;
   /*
    * public static final int RETRIEVE
    * 
    * Constant used for allowing accessAtIndex to retrieve an item
    */
   public static final int RETRIEVE = 1005;
   /*
    * BasicNode headRef
    * 
    * Member - head reference
    */
   private BasicNode headRef;
   /*
    * private class BasicNode extends Object
    */
   private class BasicNode
   {
      /*
       * BasicNode nextRef
       */
      public BasicNode nextRef;
      /*
       * int value
       */
      public int value;
      /*
       * public BasicNode(int newVal)
       */
      public BasicNode(int newVal) 
      {
         nextRef = null;
         value = newVal;
      }
      /*
       * public BasicNode(BasicNode copied)
       */
      public BasicNode(BasicNode copied) 
      {
         nextRef = null;
         value = copied.value;
      }
   }
   /*
    * public BasicLLClass()
    * 
    * Default constructor, initializes linked list
    */
   public BasicLLClass()
   {
      headRef = null;
   }
   /*
    * public BasicLLClass(BasicLLClass copied)
    * 
    * Copy constructor, copies all the nodes to newly created nodes
    * 
    * @Param copied - BasicLLClass object to be copied
    */
   public BasicLLClass(BasicLLClass copied)
   {
      if (copied.headRef == null)
      {
         headRef = null;
      }
      else 
      {
         headRef = new BasicNode(copied.headRef);
         BasicNode tempcheckingRef = headRef;
         BasicNode copnextRef = copied.headRef.nextRef;
         while (tempcheckingRef != null)
         {
            tempcheckingRef.nextRef = new BasicNode(copnextRef);
            tempcheckingRef = tempcheckingRef.nextRef;
            copnextRef = copnextRef.nextRef;
         }
      }
   }
   /*
    * private int accessAtIndex(int controlCode, int index)
    * 
    * Utility method used by getAtIndex and removeAtIndex to access and 
    * possibly remove element depending on control code
    * 
    * Note: Uses only one loop
    * 
    * @Param controlCode - integer value with either RETRIEVE or 
    * REMOVE to control operations
    * index - integer index of element to be retrieved or removed
    * 
    * @Return integer value at element or FAILED_ACCESS if attempt to 
    * access data out of bounds
    */
   private int accessAtIndex(int controlCode, int index)
   {
      if(index >= getCurrentSize() || index < 0 || isEmpty()) 
      {
       //index check
         return FAILED_ACCESS;
      }
      if(controlCode == RETRIEVE) 
      {
         return getRefAtIndex(headRef, index).value;
      }
      else if(controlCode == REMOVE) 
      {
         int temp;
         temp = getRefAtIndex(headRef, index).value;
         if(index == 0) 
         {
            headRef = headRef.nextRef;
         }
         else 
         {
            getRefAtIndex(headRef, index-1).nextRef = 
                  getRefAtIndex(headRef, index).nextRef;;
         }
         return temp;
      }
      else 
      {
         //something happened that I didnt see?
         return FAILED_ACCESS;
      }
   }
   /*
    * public void clear()
    * 
    * Clears linked list
    */
   public void clear()
   {
      headRef = null;
   }
   /*
    * public int getAtIndex(int accessIndex)
    * 
    * Accesses item in linked list at specified pseudo index if pseudo index 
    * within linked list
    * 
    * Note: Calls accessAtIndex with RETRIEVE to conduct action
    * 
    * @Param accessIndex - integer index of requested element value
    * 
    * @Return integer accessed value if successful, FAILED_ACCESS if not
    */
   public int getAtIndex(int accessIndex)
   {
         return accessAtIndex(RETRIEVE,accessIndex);
   }
   /*
    * public int getCurrentSize()
    * 
    * Description: Gets current size of linked list
    * 
    * @Return integer size of linked list
    */
   public int getCurrentSize()
   {
      return getCurrentSizeHelper(headRef);
   }
   /*
    * private int getCurrentSizeHelper(BasicNode wkgRef)
    * 
    * Description: Gets current size linked list
    * 
    * @Param wkgRef - BasicNode reference starts with head reference and is 
    * used for recursion
    * 
    * @Return integer size of linked list
    */
   private int getCurrentSizeHelper(BasicNode wkgRef)
   {
      if(wkgRef == null) 
      {
         return 0;
      }
      return getCurrentSizeHelper(wkgRef.nextRef)+1;
   }
   /*
    * private BasicNode getRefAtIndex(BasicNode wkgRef, int index)
    * 
    * Gets reference for pseudo index using recursive process
    * 
    * @Param wkgRef - BasicNode reference 
    * index - integer index for pseudo element requested
    * 
    * @Return BasicNode reference to element at pseudo index
    */
   private BasicNode getRefAtIndex(BasicNode wkgRef, int index)
   {
      if(index == 0) 
      {
         return wkgRef;
      }
      else if(wkgRef.nextRef == null) 
      {
         return null;
      }
      else 
      {
         return getRefAtIndex(wkgRef.nextRef, index-1);
      }
   }
   /*
    * public boolean isEmpty()
    * 
    * Tests for head reference equals null,
    * 
    * @Return Boolean result of test for empty
    */
   public boolean isEmpty()
   {
      return headRef == null;
   }
   /*
    * public int removeAtIndex(int removeIndex)
    * 
    * Description: Removes item from linked list at specified pseudo index if 
    * pseudo index within linked list
    * 
    * Note: Must call accessAtIndex with REMOVE to conduct action
    * 
    * @Param removeIndex - integer index of element value to be removed
    * 
    * @Return removed integer value if successful, FAILED_ACCESS if not
    */
   public int removeAtIndex(int removeIndex)
   {
         return accessAtIndex(REMOVE,removeIndex);
   }
   /*
    * public boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
    * 
    * Description: sets item in linked list at specified pseudo index
    * 
    * Note: If constant REPLACE is used, new value overwrites value at 
    * given index
    * 
    * Note: If constant INSERT_BEFORE is used, new value is inserted prior to 
    * the value at the given index moving all other elements up by one
    * 
    * Note: If constant INSERT_AFTER is used, new value is inserted after the 
    * value at the given index moving all other elements up by one
    * 
    * Note: If either constant INSERT_BEFORE or INSERT_AFTER is used with index
    *  zero and an empty list, new value is inserted at head reference
    *  
    *  Note: Method must also check for correct linked list boundaries 
    *  depending upon INSERT/REPLACE state; this is actually conducted by 
    *  using getRefAtINdex
    *  
    *  @Param setIndex - integer index of element at which value is to 
    *  be inserted
    *  newValue - integer value to be placed in list
    *  replaceFlag - integer flag to indicate insertion or replacement in the 
    *  linked list
    *  
    *  @Return Boolean success if inserted, or failure if incorrect 
    *  index was used
    */
   public boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
   {
      if(setIndex > getCurrentSize() || setIndex < 0) 
      {
         //index check
         return false;
      }
      else if(isEmpty() && setIndex==0) 
      {
         //special case for nothing in list and cursor 0
         headRef = new BasicNode(newValue);
         return true;
      }
      else if(isEmpty()) 
      {
         //special case for nothing in list and cursor not 0
         return false;
      }
      if(replaceFlag == REPLACE) 
      {
         if(isEmpty()) 
         {
            headRef = null;
            
         }
         getRefAtIndex(headRef, setIndex).value = newValue;
         return true;
      }
      else if(replaceFlag == INSERT_BEFORE) 
      {
         if(setIndex==0) 
         {
            //special case for something in list and cursor 0 to not go index -1
            BasicNode newNode = new BasicNode(newValue);
            newNode.nextRef = headRef;
            headRef = newNode;
            return true;
         }
         else 
         {
            BasicNode newNode = new BasicNode(newValue);
            newNode.nextRef = getRefAtIndex(headRef, setIndex);
            getRefAtIndex(headRef, setIndex-1).nextRef = newNode;
            return true;
         }
      }
      else if(replaceFlag == INSERT_AFTER) 
      {
            BasicNode newNode = new BasicNode(newValue);
            BasicNode tempNode = getRefAtIndex(headRef, setIndex);
            newNode.nextRef = tempNode.nextRef;
            tempNode.nextRef = newNode;
            return true;
      }
      else 
      {
       //something happened that I didnt see?
         return false;
      }
   }
}
