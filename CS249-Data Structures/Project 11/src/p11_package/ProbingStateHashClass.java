package p11_package;

public class ProbingStateHashClass extends Object
{
   /**
    * private final int DEFAULT_TABLE_SIZE
    * Table size default
    * 
    */
   private final int DEFAULT_TABLE_SIZE = 11;
    /** 
    * public final int ITEM_NOT_FOUND
    * Constant for returning item not found with search
    */ 
   public final int ITEM_NOT_FOUND = -1;
    /** 
    * public static final int LINEAR_PROBING
    * Constant for setting linear probing
    */ 
   public static final int LINEAR_PROBING = 101;
    /** 
    * public static final int QUADRATIC_PROBING
    * Constant for setting quadratic probing
    */ 
   public static final int QUADRATIC_PROBING = 102;
    /** 
    * private int tableSize
    * Size of the array table
    */ 
   private int tableSize;
    /** 
    * private int probeFlag
    * Flag for setting linear or quadratic probing
    */
   private int probeFlag;
    /** 
    * private StateDataClass[] tableArray
    * Array for hash table
    */ 
   private StateDataClass[] tableArray;
    /** 
    * public ProbingStateHashClass()
    * Default constructor
    * Initializes to default table size with probe flag set to linear probing
    */ 
   public ProbingStateHashClass() 
   {
      probeFlag = LINEAR_PROBING;
      tableSize = DEFAULT_TABLE_SIZE;
      tableArray = new StateDataClass[tableSize];
      clearHashTable();
      
   }
    /** 
    * public ProbingStateHashClass(int inProbeFlag)
    * Initialization constructor
    * Initializes to default table size with probe flag set to probe flag parameter
    * @Param inProbeFlag - sets linear or quadratic probing
    */
   public ProbingStateHashClass(int inProbeFlag) 
   {
      probeFlag = inProbeFlag;
      tableSize = DEFAULT_TABLE_SIZE;
      tableArray = new StateDataClass[tableSize];
      clearHashTable();
   }
    /** 
    * public ProbingStateHashClass(int inTableSize,int inProbeFlag) 
    * Initialization constructor
    * 
    * @Param inTableSize - sets table size (capacity) but does not allow table size to be less than default capacity
    * inProbeFlag - sets linear or quadratic probing
    */
   public ProbingStateHashClass(int inTableSize,int inProbeFlag) 
   {
      probeFlag = inProbeFlag;
      tableSize = inTableSize;
      tableArray = new StateDataClass[tableSize];
      clearHashTable();
   }
    /** 
     * public ProbingStateHashClass(ProbingStateHashClass copied)
     * Copy constructor
     * 
     * @Param copied - ProbingHashClass object to be copied
     */
   public ProbingStateHashClass(ProbingStateHashClass copied) 
   {
      probeFlag = copied.probeFlag;
      tableSize = copied.tableSize;
      tableArray = new StateDataClass[tableSize];
      clearHashTable();
      int copycounter;
      for(copycounter = 0; copycounter<tableSize; copycounter++) 
      {
         tableArray[copycounter] = new 
               StateDataClass(copied.tableArray[copycounter]);
      }
   }
     /** 
     * public boolean addItem(StateDataClass newItem)
     * Adds StateDataClass data item to hash table
     * Note: Uses hash index value from generateHash
     * Note: Shows probed index with data at the point of insertion
     * Note: Probe attempts are limited to the current size (capacity) of the table
     * @Param newItem - StateDataClass object
     * @Return Boolean success of operation
     */ 
   public boolean addItem(StateDataClass newItem) 
   {
      int address = generateHash(newItem);
      System.out.print("Indicies probed: ");
      while(tableArray[address] != null) 
      {
         System.out.print(address+",");
         if(probeFlag == LINEAR_PROBING) 
         {
            address+=1; 
         }
         else if(probeFlag == QUADRATIC_PROBING) 
         {
            address+=toPower(1,2);
         }
         else 
         {
            return false;
         }
         address %= tableSize;
      }
      System.out.print(address);
      tableArray[address] = newItem;
      return true;
      
   }
     /** 
     * public void clearHashTable()
     * Clears hash table by setting all bins to null
     */
   public void clearHashTable() 
   {
      int copycounter;
      for(copycounter = 0; copycounter<tableSize; copycounter++) 
      {
         tableArray[copycounter] = null;
      }
   }
     /**
     *  public StateDataClass findItem(StateDataClass searchItem)
     * Returns item found
     * 
     * @Param searchItem - StateDataClass value to be found; uses findItemIndex
     * @Return StateDataClass item found, or null if not found
     */
   public StateDataClass findItem(StateDataClass searchItem) 
   {
      if(findItemIndex(searchItem) == ITEM_NOT_FOUND) 
      {
         return null;
      }
      else 
      {
         return tableArray[findItemIndex(searchItem)];
      }
   }
     /** 
     * private int findItemIndex(StateDataClass searchItem)
     * Searches for item index in hash table
     * Note: Uses linear or quadratic probing as configured
     * Note: probing attempts limited to table size (capacity)
     * Note: Probed indices are reported to screen
     * 
     * @Param searchItem - StateDataClass object to be found
     * @Return integer index location of search item
     */ 
   private int findItemIndex(StateDataClass searchItem) 
   {
      int address = generateHash(searchItem);
      while(tableArray[address] != searchItem) {
         if(probeFlag == LINEAR_PROBING) 
         {
            address+=1;
         }
         else if(probeFlag == QUADRATIC_PROBING) 
         {
            address+=toPower(1,2);
         }
         else 
         {
            return -11;
         }
         address %= tableSize;
      }
      return address;
   }
     /**
     *  public int generateHash(StateDataClass item)
     * Method converts StateDataClass hash value to index for use in hash table
     * Sums the Unicode/ASCII values of all letters in the state name; then finds index
     * Dependencies: .charAt, .length
     * 
     * @Param item - StateDataClass object to be converted to hash value
     * @Return integer hash value
     */ 
   public int generateHash(StateDataClass item) 
   {
      int nameiterator;
      int asciitot = 0;
      for(nameiterator = 0; nameiterator<item.state.length();nameiterator++) 
      {
         asciitot = (int) item.state.charAt(nameiterator);
      }
      return (int)asciitot/tableSize;
   }
     /**
     *  public StateDataClass removeItem(StateDataClass toBeRemoved)
     * Removes item from hash table
     * 
     * @Param toBeRemoved - StateDataClass object used for requesting data uses findItemIndex
     * @Return StateDataClass object removed, or null if not found
     */ 
   public StateDataClass removeItem(StateDataClass toBeRemoved) 
   {
      StateDataClass holder = tableArray[findItemIndex(toBeRemoved)];
      tableArray[findItemIndex(toBeRemoved)] = null;
      return holder;
   }
     /**
     *  public String showHashTableStatus()
     * traverses through all array bins, finds min and max number of contiguous elements, and number of empty nodes; also shows table loading
     * NOTE: Generates string of used and unused bins in addition to displaying results on screen
     * 
     * @Return String result of hash table analysis
     */ 
   public String showHashTableStatus() 
   {
      System.out.print("Hash Table Status: ");
      int hashiterator;
      String resultout = "";
      for(hashiterator = 0; hashiterator < tableSize; hashiterator++) 
      {
         if(tableArray[hashiterator] == null) 
         {
            resultout += "N";
            System.out.print("N");
         }
         else 
         {
            resultout += "D";
            System.out.print("D");
         }
      }
      System.out.println("");
      System.out.println("Array Dump:");
      for(hashiterator = 0; hashiterator < tableSize; hashiterator++) 
      {
         if(tableArray[hashiterator] == null) 
         {
            System.out.println("null");
         }
         else 
         {
            System.out.println(tableArray[hashiterator].toString());
         }
      }
      return resultout;
   }
     /**
     *  private int toPower(int base, int exponent)
     * Local recursive method to calculate exponentiation with positive integers
     * 
     * @Param base - base of exponentiation
     * exponent - exponent of exponentiation
     * 
     * @Return result of exponentiation calculation
    */
   private int toPower(int base, int exponent) 
   {
      int currentValue = 1;
      if(exponent != 0) 
      {
         currentValue *= base;
         toPower(base, exponent-1);
      }
      return currentValue;
   }
}
