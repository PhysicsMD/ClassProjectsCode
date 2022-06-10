package p10_package;

public class StudentHeapClass
{
   /**
    * public final int DEFAULT_ARRAY_CAPACITY
    * 
    * Initial array capacity
    */
   public final int DEFAULT_ARRAY_CAPACITY = 10;
   /**
    * public final int PARENT
    * 
    * Enumerated parent flag
    */
   public final int PARENT = 1001;
   /**
    * public final int LEFT
    * 
    * Enumerated left child flag
    */
   public final int LEFT = 2002;
   /**
    * public final int RIGHT
    * 
    * Enumerated right child flag
    */
   public final int RIGHT = 3003;
   /**
    * private StudentClass[] heapArray
    * 
    * Array for heap
    */
   private StudentClass[] heapArray;
   /**
    * private int arraySize
    * 
    * Management data for array
    */
   private int arraySize;
   /**
    * private int arrayCapacity
    * 
    * Management data for array
    */
   private int arrayCapacity;
   /**
    * private boolean displayFlag
    * 
    * Display flag can be set to observe bubble up and trickle down operations
    */
   private boolean displayFlag;
   /**
    * public StudentHeapClass()
    * 
    * Default constructor sets up array management conditions and default 
    * display flag setting
    */
   public StudentHeapClass() 
   {
      displayFlag = false;
      arrayCapacity = DEFAULT_ARRAY_CAPACITY;
      heapArray = new StudentClass[arrayCapacity];
      arraySize = 0;
   }
   /**
    * public StudentHeapClass(StudentHeapClass copied)
    * 
    * Copy constructor copies array and array management conditions and default 
    * display flag setting
    * 
    * @Param copied - StudentHeapClass object to be copied
    */
   public StudentHeapClass(StudentHeapClass copied) 
   {
      displayFlag = copied.displayFlag;
      arrayCapacity = copied.arrayCapacity;
      heapArray = new StudentClass[arrayCapacity+1];
      arraySize = copied.arraySize;
      int iterationcounter;
      for(iterationcounter = 1; iterationcounter <= arraySize;
            iterationcounter++) 
      {
         heapArray[iterationcounter] = new StudentClass(copied.heapArray[iterationcounter]);
      }
   }
   /**
    * public void addItem(StudentClass newItem)
    * 
    * Accepts StudentData item and adds it to heap
    * 
    * Note: uses bubbleUpArrayHeap to resolve unbalanced heap after data 
    * addition
    * 
    * Note: must check for resize before attempting to add an item
    * 
    * @Param newItem - StudentClass data item to be added
    */
   public void addItem(StudentClass newItem) 
   {
      checkForResize();
      arraySize+=1;
      heapArray[arraySize] = newItem;
      if(displayFlag) 
      {
         System.out.println("");
         System.out.print("Adding new process:");
         System.out.println(newItem.toString());
      }
      bubbleUpArrayHeap(arraySize);
   }
   /**
    * private void bubbleUpArrayHeap(int currentIndex)
    * 
    * Recursive operation to reset data in the correct order for the max heap 
    * after new data addition
    * 
    * @Param currentIndex - index of current item being assessed, and moved up 
    * as needed
    */ 
   private void bubbleUpArrayHeap(int currentIndex) 
   {
      int parent_index = (currentIndex-(currentIndex%2))/2;
      if (currentIndex > 1) 
      {
         if(heapArray[parent_index].compareTo(heapArray[currentIndex])<0)
         {
            if(displayFlag) 
            {
               System.out.println("   - Bubble up:");
               System.out.print("    - Swapping parent:");
               System.out.print(heapArray[parent_index].toString());
               System.out.print(" with child: ");
               System.out.println(heapArray[currentIndex].toString());
            }
            StudentClass holder = heapArray[parent_index];
            heapArray[parent_index] = heapArray[currentIndex];
            heapArray[currentIndex] = holder;
         }
         if(parent_index != 1) 
         {
            bubbleUpArrayHeap(parent_index);
         }
      }
   }
   /**
    * private void checkForResize()
    * 
    * Automatic resize operation used prior to any new data addition in the heap
    * 
    * Tests for full heap array, and resizes to twice the current capacity as 
    * required
    */
   private void checkForResize() 
   {
      int iterationcounter;
      StudentClass[] newArray;
      if(arraySize == arrayCapacity)
      {
         arrayCapacity = arrayCapacity*2;
         newArray = new StudentClass[arrayCapacity];
         for(iterationcounter = 0; iterationcounter < arraySize;
               iterationcounter++) 
         {
            newArray[iterationcounter] = heapArray[iterationcounter];
         }
         heapArray = newArray;
      }
   }
   /**
    * public boolean isEmpty()
    * 
    * Tests for empty heap
    * 
    * @Return boolean result of test
    */
   public boolean isEmpty() 
   {
      return arraySize == 0;
   }
   /**
    * public StudentClass removeItem()
    * 
    * Removes StudentClass data item from top of max heap, thus being the 
    * student with the highest GPA
    * 
    * Note: Uses trickleDownArrayHeap to resolve unbalanced heap after data 
    * removal
    * 
    * @Return StudentClass item removed
    */
   public StudentClass removeItem() 
   {
      StudentClass holder = heapArray[1];
      if(displayFlag) 
      {
         System.out.println("");
         System.out.print("Removing process:");
         System.out.println(holder.toString());
      }
      heapArray[1] = heapArray[arraySize];
      arraySize -= 1;
      if(arraySize != 0) 
      {
         trickleDownArrayHeap(1);
      }
      return holder;
   }
   /**
    * public void setDisplayFlag(boolean setState)
    * 
    * Utility method to set the display flag for displaying internal operations 
    * of the heap bubble and trickle operations
    * 
    * @Param setState - flag used to set the state to display, or not
    */
   public void setDisplayFlag(boolean setState) 
   {
      displayFlag = setState;
   }
   /**
    * public void showArray()
    * 
    * Dumps array to screen as is, no filtering or management
    */
   public void showArray() 
   {
      int iterationcounter;
      for(iterationcounter = 0; iterationcounter < arraySize;
            iterationcounter++) 
      {
         System.out.println(heapArray[iterationcounter]);
      }
   }
   /**
    * private void trickleDownArrayHeap(int currentIndex)
    * 
    * Recursive operation to reset data in the correct order for the max heap 
    * after data removal
    * 
    * @Param currentIndex - index of current item being assessed, and moved 
    * down as required
    */
   private void trickleDownArrayHeap(int currentIndex) 
   {
      
//      if(displayFlag) 
//      {
//         System.out.println("   - Trickle down:");
//      }
//      if(arraySize<3 || !(currentIndex*2 <= arraySize)) 
//      {
//         if(heapArray[currentIndex].compareTo(heapArray[currentIndex*2])<0) 
//         {
//            if(displayFlag) 
//            {
//               System.out.print("    - Swapping parent:");
//               System.out.print(heapArray[currentIndex].toString());
//               System.out.print(" with left child: ");
//               System.out.println(heapArray[currentIndex*2].toString());
//            }
//            StudentClass holder = heapArray[currentIndex];
//            heapArray[currentIndex] = heapArray[currentIndex*2];
//            heapArray[currentIndex*2] = holder;
//         }
//         else if(heapArray[currentIndex].compareTo(heapArray[(currentIndex+1)*2])<0) 
//         {
//            if(displayFlag) 
//            {
//               System.out.print("    - Swapping parent:");
//               System.out.print(heapArray[currentIndex].toString());
//               System.out.print(" with right child: ");
//               System.out.println(heapArray[(currentIndex+1)*2].toString());
//            }
//            StudentClass holder = heapArray[currentIndex];
//            heapArray[currentIndex] = heapArray[(currentIndex+1)*2];
//            heapArray[(currentIndex+1)*2] = holder;
//         }
//      }
//      else if(heapArray[currentIndex*2].compareTo(heapArray[currentIndex*2+1])>0) 
//      {
//         if(heapArray[currentIndex].compareTo(heapArray[currentIndex*2])<0) 
//         {
//            if(displayFlag) 
//            {
//               System.out.print("    - Swapping parent:");
//               System.out.print(heapArray[currentIndex].toString());
//               System.out.print(" with left child: ");
//               System.out.println(heapArray[currentIndex*2].toString());
//            }
//            StudentClass holder = heapArray[currentIndex];
//            heapArray[currentIndex] = heapArray[currentIndex*2];
//            heapArray[currentIndex*2] = holder;
//            if(currentIndex*2 <= arraySize) 
//            {
//               trickleDownArrayHeap(currentIndex*2);
//            }
//         }
//      }
//      else if(heapArray[currentIndex].compareTo(heapArray[currentIndex*2+1])<0) 
//      {
//         if(displayFlag) 
//         {
//            System.out.print("    - Swapping parent:");
//            System.out.print(heapArray[currentIndex].toString());
//            System.out.print(" with right child: ");
//            System.out.println(heapArray[currentIndex*2+1].toString());
//         }
//         StudentClass holder = heapArray[currentIndex];
//         heapArray[currentIndex] = heapArray[currentIndex*2+1];
//         heapArray[currentIndex*2+1] = holder;
//         if((currentIndex+1)*2 <= arraySize) 
//         {
//            trickleDownArrayHeap((currentIndex+1)*2);
//         }
//      }
   }
}
