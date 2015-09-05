
package hr;



import org.junit.Assert;
import org.junit.Test;


public class NodeTest
{

  @Test
  public void testInsertNth ()
  {
    Node head = null;
    Node node = new Node();
    head = node.InsertNth (head, 3, 0);
    head = node.InsertNth (head, 5, 1);   
    head = node.InsertNth (head, 4, 2);
    head = node.InsertNth (head, 2, 4);
    head = node.InsertNth (head, 10, 1);
    
    String actual = head.printNode (head);
    Assert.assertEquals ("310542", actual);
    
    head=head.Reverse (head);
    actual =head.printNode(head);
    Assert.assertEquals ("245103", actual);
  }
  
  
  
  @Test
  public void testCopmare ()
  {
    Node headA = null;
    Node node = new Node();
    headA = node.InsertNth (headA, 3, 0);
    headA = node.InsertNth (headA, 5, 1);   
    headA = node.InsertNth (headA, 4, 2);
    headA = node.InsertNth (headA, 2, 4);
    headA = node.InsertNth (headA, 10, 1);
    
    int actual = node.CompareLists (headA, null);
    Assert.assertEquals (0, actual);
    
    Node headB = null;
    headB = node.InsertNth (headB, 3, 0);
    headB = node.InsertNth (headB, 5, 1);   
    headB = node.InsertNth (headB, 4, 2);
    headB = node.InsertNth (headB, 2, 4);
    headB = node.InsertNth (headB, 10, 1);
    actual = node.CompareLists (headA, headB);
    Assert.assertEquals (1, actual);
    
    
    headB = null;
    headB = node.InsertNth (headB, 3, 0);
    headB = node.InsertNth (headB, 5, 1);   
    headB = node.InsertNth (headB, 4, 2);
    headB = node.InsertNth (headB, 2, 4);
    actual = node.CompareLists (headA, headB);
    Assert.assertEquals (0, actual);
    
    
  }
  
  
  @Test
  public void testMerge ()
  {
    Node headA = null;
    Node node = new Node();
    headA = node.InsertNth (headA, 12, 0);
 
    Node headB = null;
    headB = node.InsertNth (headB, 15, 0);

    Node merged = node.MergeLists (headA, headB);
  
    String actual = node.printNode (merged);
    System.out.println (actual);
    
    headA = null;
    headA = node.InsertNth (headA, 1, 0);
    headA = node.InsertNth (headA, 3, 1);   
    headA = node.InsertNth (headA, 5, 2);
    headA = node.InsertNth (headA, 6, 3);
    
    headB = null;
    headB = node.InsertNth (headB, 2, 0);
    headB = node.InsertNth (headB, 4, 1);   
    headB = node.InsertNth (headB, 7, 2);
    
    merged = node.MergeLists (headA, headB);
    actual = node.printNode (merged);
    System.out.println (actual);
    
    
  }
  //--------------------------------------------------------------------------
  // Static members
  //--------------------------------------------------------------------------



  //-------------------------------------------------------------------------
  // Members
  //-------------------------------------------------------------------------



  //-------------------------------------------------------------------------
  // Constructor
  //-------------------------------------------------------------------------



  //-------------------------------------------------------------------------
  // Implements interface <IMyInterface>
  //-------------------------------------------------------------------------



  //--------------------------------------------------------------------------
  // Methods
  //--------------------------------------------------------------------------



  //--------------------------------------------------------------------------
  // Any other separator such as "Utility methods", etc.
  //--------------------------------------------------------------------------
}
