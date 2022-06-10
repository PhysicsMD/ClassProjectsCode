package p8_package;
/**
 * 
 * @author Alenn Wright
 *
 */
public class StateData_BST_Class extends Object
{
   /**
    * public static final int PRE_TRAVERSE
    * 
    * Traverse code - preorder
    */
   public static final int PRE_TRAVERSE = 101;
   /**
    * public static final int IN_TRAVERSE
    * 
    * Traverse code - inorder
    */
   public static final int IN_TRAVERSE = 102;
   /**
    * public static final int POST_TRAVERSE
    * 
    * Traverse code - postorder
    */
   public static final int POST_TRAVERSE = 103;
   /**
    * private StateDataClass rootNode
    * 
    * Root of tree
    */
   private StateDataClass rootNode;
   /**
    * private int displayCounter
    * 
    * Display counter
    */
   private int displayCounter;

   /**
    * public StateData_BST_Class()
    * 
    * Default class constructor, initializes BST
    */
   public StateData_BST_Class() 
   {
      rootNode = null;
      displayCounter = 0;
   }

   /**
    * public StateData_BST_Class(StateData_BST_Class copied)
    * 
    * Copy constructor
    * 
    * @Param copied - StateData_BST_Class reference to copied object
    */
   public StateData_BST_Class(StateData_BST_Class copied) 
   {
      rootNode = copyConstructorHelper(copied.rootNode);
   }

   /**
    * public void clearTree()
    * 
    * Clears tree
    */
   public void clearTree() 
   {
      rootNode = null;
   }

   /**
    * public int compareStrings(String one, String other)
    * 
    * Compares strings
    * 
    * If first string parameter is greater than the second, method 
    * returns positive value; if first string parameter is less than 
    * second, return negative value; if first string parameter and second 
    * string parameter are equal, returns zero
    * 
    * @Param one - first of two strings to compare
    * other - second of two string to compare
    * 
    * @Return integer value as specified
    */
   public static int compareStrings( String oneString, String otherString )
   {
   int difference, index = 0;

   while( index < oneString.length() && index < otherString.length() )
     {
      difference = oneString.charAt( index ) - otherString.charAt( index );

      if( difference != 0 )
         {
          return difference;
         }

      index++;
     }

    return oneString.length() - otherString.length();
   } 

   /**
    * private StateDataClass copyConstructorHelper(StateDataClass wkgRef)
    * 
    * Copy constructor helper
    * 
    * Recursively copies nodes using pre order traversal
    * 
    * @Param wkgRef - current working StudentDataClass reference in recursion
    * 
    * @Return StateDataClass reference to link to StateDataClass node above
    */
   private StateDataClass copyConstructorHelper(StateDataClass wkgRef) 
   {
      if(wkgRef != null) 
      {
         StateDataClass newRef = new StateDataClass(wkgRef);
         newRef.leftChildRef = copyConstructorHelper(wkgRef.leftChildRef);
         newRef.rightChildRef = copyConstructorHelper(wkgRef.rightChildRef);
         return newRef;
      }
      else 
      {
         return null;
      }
   }

   /**
    * private void displayInOrder(StateDataClass wkgRef)
    * 
    * Provides inOrder traversal action using recursion
    * 
    * @Param wkgRef - StateDataClass tree root reference at the current 
    * recursion level
    */
   private void displayInOrder(StateDataClass wkgRef) 
   {
      if(wkgRef != null) 
      {
         displayCounter += 1;
         System.out.print(displayCounter);
         System.out.print(": ");
         System.out.println(wkgRef.toString());
         if(wkgRef.leftChildRef!=null)
         {
             displayInOrder( wkgRef.leftChildRef );
         }
         if(wkgRef.rightChildRef!=null)
         {
             displayInOrder( wkgRef.rightChildRef );
         }
      }
   }

   /**
    * private void displayPostOrder(StateDataClass wkgRef)
    * 
    * Provides postOrder traversal action using recursion
    * 
    * @Param wkgRef - StateDataClass tree root reference at the current 
    * recursion level
    */
   private void displayPostOrder(StateDataClass wkgRef) 
   {
      if(wkgRef != null) 
      {
         displayCounter += 1;
         System.out.print(displayCounter);
         System.out.print(": ");
         System.out.println(wkgRef.toString());
      }
      if(wkgRef.rightChildRef!=null)
      {
          displayInOrder( wkgRef.rightChildRef );
      }
      if(wkgRef.leftChildRef!=null)
      {
          displayInOrder( wkgRef.leftChildRef );
      }
   }

   /**
    * private void displayPreOrder(StateDataClass wkgRef)
    * 
    * Provides preOrder traversal action using recursion
    * 
    * @Param wkgRef - StateDataClass tree root reference at the current 
    * recursion level
    */
   private void displayPreOrder(StateDataClass wkgRef) 
   {
      if(wkgRef.leftChildRef!=null)
      {
          displayInOrder( wkgRef.leftChildRef );
      }
      if(wkgRef.rightChildRef!=null)
      {
          displayInOrder( wkgRef.rightChildRef );
      }
      if(wkgRef != null) 
      {
         displayCounter += 1;
         System.out.print(displayCounter);
         System.out.print(": ");
         System.out.println(wkgRef.toString());
      }
   }

   /**
    * public void displayTree(int traverseCode)
    * 
    * Provides user with three ways to display BST data
    * 
    * @Param traverseCode - integer code for selecting BST traversal method, 
    * accepts PRE_TRAVERSE, IN_TRAVERSE, POST_TRAVERSE
    */
   public void displayTree(int traverseCode) 
   {
      displayCounter = 0;
      if(traverseCode == PRE_TRAVERSE) 
      {
         //System.out.println("PreOrder Display: ");
         displayPreOrder(rootNode);
      }
      if(traverseCode == IN_TRAVERSE) 
      {
         //System.out.println("InOrder Display: ");
         displayInOrder(rootNode);
      }
      if(traverseCode == POST_TRAVERSE) 
      {
         //System.out.println("PostOrder Display: ");
         displayPostOrder(rootNode);
      }
      displayCounter = 0;
   }

   /**
    * public void insert(StateDataClass inData)
    * 
    * Insert method for BST
    * 
    * Note: calls the insert helper to implement all the data insertions
    * 
    * @Param inData - StateDataClas data to be added to BST
    */
   public void insert(StateDataClass inData) 
   {
      insertHelper(rootNode,inData);
      
   }

   /**
    * private StateDataClass insertHelper(StateDataClass wkgRef, 
    * StateDataClass inData)
    * 
    * Recursive insert helper method for BST insert action
    * 
    * Adds new StateDataClass node to left or right of the current tree; if 
    * node is already in tree, node is updated with the incoming data
    * 
    * @Param wkgRef - current working reference at the current recursion level
    * inData - StateDataClass item to be added to BST
    * 
    * @Return StateDataClass reference to current node insertion operation
    */
   private StateDataClass insertHelper(StateDataClass wkgRef, 
         StateDataClass inData) 
   {
      if(isEmpty()) 
      {
         rootNode = inData;
      }
      else 
      {
         int comparisonResults = compareStrings(inData.state, wkgRef.state);
         if((wkgRef != null) && comparisonResults == 0) 
         {
            wkgRef.setData(inData);
         }
         else if((wkgRef != null) && comparisonResults > 0) 
         {
            if(wkgRef.rightChildRef != null) 
            {
               return insertHelper(wkgRef.rightChildRef, inData);
            }
            else 
            {
               wkgRef.rightChildRef = inData;
               return wkgRef.rightChildRef;
            }
         }
         else if((wkgRef != null) && comparisonResults < 0) 
         {
            if(wkgRef.leftChildRef != null) 
            {
               return insertHelper(wkgRef.leftChildRef, inData);
            }
            else 
            {
               wkgRef.leftChildRef = inData;
               return wkgRef.leftChildRef;
            }
         }
      }
      return rootNode;
   }

   /**
    * public boolean isEmpty()
    * 
    * Test for empty tree 
    * 
    * @Return Boolean result of test
    */
   public boolean isEmpty() 
   {
      return rootNode == null;
   }

   /**
    * private StateDataClass removeFromMin(StateDataClass parentRef,
    *  StateDataClass childRef)
    *  
    *  Searches tree from given working reference to minimum value found below 
    *  it in farthest left node, stores data value found, unlinks the found 
    *  node, links the parent node's left node to the child's right node, and 
    *  returns the child/found node to the calling method
    *  
    *  @Param parentRef - reference to current StateDataClass node
    *  childRef - reference to child StateDataClass node to be tested and/or 
    *  removed
    *  
    *  @Return StateDataClass reference containing removed StateDataClass node
    */
   private StateDataClass removeFromMin(StateDataClass parentRef,
         StateDataClass childRef) 
   {
      if(childRef.leftChildRef != null) 
      {
         return removeFromMin(parentRef.leftChildRef,
               childRef.leftChildRef);
      }
      parentRef.leftChildRef = childRef.rightChildRef;
      return childRef;
   }

   /**
    * public StateDataClass removeItem(StateDataClass outData)
    * 
    * Removes data StateDataClass node from tree using given key
    * 
    * Note: uses remove helper method
    * 
    * Note: uses search initially to get value, if it is in tree; if value 
    * found, remove helper method is called, otherwise returns null
    * 
    * @Param outData - StateDataClass node that includes the necessary key
    * 
    * @Return StateDataClass result of remove action
    */
   public StateDataClass removeItem(StateDataClass outData) 
   {
      StateDataClass tempNode  = search(outData);
      if(tempNode != null) 
      {
         tempNode = new StateDataClass(tempNode);
         rootNode = removeItemHelper(rootNode, outData);
      }
      return tempNode;
   }

   /**
    * private StateDataClass removeItemHelper(StateDataClass wkgRef,
    * StateDataClass outData)
    * 
    * Remove helper for BST remove action
    * 
    * Note: Recursive method returns updated local root to maintain tree linkage
    * 
    * Note: uses removeFromMin method
    * 
    * @Param wkgRef - StateDataClass node reference at the current recursion 
    * level
    * outData - StateDataClass item that includes the necessary key
    * 
    * @Return StateDataClass reference result of remove helper action
    */
   private StateDataClass removeItemHelper(StateDataClass wkgRef,
         StateDataClass outData) 
   {
      
      if(compareStrings(outData.state, wkgRef.state) == 0) 
      {
         StateDataClass workingNode = 
               removeFromMin( wkgRef,wkgRef.leftChildRef );
         StateDataClass returnNode = wkgRef;

         wkgRef=workingNode;

         return returnNode;
      }
      if(compareStrings(outData.state, wkgRef.state) > 0 && 
            wkgRef.rightChildRef != null) 
      {
         return removeItemHelper(wkgRef.rightChildRef, outData);
      }
      if(compareStrings(outData.state, wkgRef.state) < 0 && 
            wkgRef.leftChildRef != null) 
      {
         return removeItemHelper(wkgRef.leftChildRef, outData);
      }
      else 
      {
         return null;
      }
   }

   /**
    * public StateDataClass search(StateDataClass searchData)
    * 
    * Searches for data in BST given StateDataClass referencewith necessary key
    * 
    * @Param searchData - StateDataClass reference containing key
    * 
    * @Return StateDataClass reference to found data, or null if not found
    */
   public StateDataClass search(StateDataClass searchData) 
   {
      return searchHelper(rootNode, searchData);
   }

   /**
    * private StateDataClass searchHelper(StateDataClass wkgRef,
    *  StateDataClass searchData)
    *  
    *  Helper method for recursive BST search action
    *  
    * @Param wkgRef - StateDataClass tree node reference at the current 
    * recursion level
    * searchData - StateDataClass reference containing key
    * 
    * @Return StateDataClass item found, or null if not found
    */
   private StateDataClass searchHelper(StateDataClass wkgRef,
         StateDataClass searchData) 
   {
      if(isEmpty()) 
      {
         return null;
      }
      else 
      {
         if(compareStrings(searchData.state, wkgRef.state) == 0) 
         {
            return wkgRef;
         }
         else if((wkgRef.rightChildRef != null) && 
               (compareStrings(searchData.state, wkgRef.state) > 0)) 
         {
            return searchHelper(wkgRef.rightChildRef, searchData);
         }
         else if((wkgRef.leftChildRef != null) && 
               (compareStrings(searchData.state, wkgRef.state) < 0)) 
         {
            return searchHelper(wkgRef.leftChildRef, searchData);
         }
         else 
         {
            return null;
         }
      }
   }
}


