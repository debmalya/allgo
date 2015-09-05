package hr;



public class Node
{

  // --------------------------------------------------------------------------
  // Static members
  // --------------------------------------------------------------------------



  // -------------------------------------------------------------------------
  // Members
  // -------------------------------------------------------------------------
  int data;

  Node next;



  // -------------------------------------------------------------------------
  // Constructor
  // -------------------------------------------------------------------------



  // -------------------------------------------------------------------------
  // Implements interface <IMyInterface>
  // -------------------------------------------------------------------------



  // --------------------------------------------------------------------------
  // Methods
  // --------------------------------------------------------------------------
  Node InsertNth (Node head, int data, int position)
  {
    int pos = 0;
    Node next = head;
    if (position == 0)
    {
      Node newHead = new Node ();
      newHead.data = data;
      newHead.next = head;
      head = newHead;
    }
    else
    {
      Node prev = null;
      boolean inserted = false;
      while (pos < position)
      {
        pos++;
        if (next == null)
        {
          next = new Node ();
          if (prev != null)
          {
            prev.next = next;
          }
          next.data = data;
          inserted = true;
          break;
        }
        // System.out.println(pos+". " + next.data);
        prev = next;
        next = next.next;
      }
      if (!inserted)
      {
        if (next == null)
        {
          next = new Node ();
          prev.next = next;
          next.data = data;
          next.next = null;
        }
        else
        {

          Node nextNode = new Node ();
          prev.next = nextNode;
          nextNode.data = data;
          nextNode.next = next;
        }

      }

    }
    return head;
  }



  Node Delete (Node head, int position)
  {
    // Complete this method
    Node next = head;
    Node prev = null;
    int pos = 0;
    if (position == 0)
    {
      return head.next;
    }
    while (pos < position)
    {

      if (next == null)
      {
        return head;
      }
      prev = next;
      next = next.next;
      pos++;
    }
    prev.next = next.next;
    return head;
  }



  public String printNode (Node head)
  {
    Node next = head;
    StringBuilder me = new StringBuilder ();
    while (next != null)
    {
      me.append (next.data);
      next = next.next;
    }
    return me.toString ();
  }



  /**
   * You are given the pointer to the head node of a linked list and you need to
   * print all its elements in reverse order from tail to head, one element per
   * line. The head pointer may be null meaning that the list is empty - in that
   * case, do not print anything!
   * 
   * 
   * @param head
   */
  void ReversePrint (Node head)
  {
    // This is a "method-only" submission.
    // You only need to complete this method.
    Node next = head;
    StringBuilder me = new StringBuilder ();
    while (next != null)
    {
      me.append (next.data);
      next = next.next;
    }
    String reverse = me.reverse ().toString ().trim ();
    for (int i = 0; i < reverse.length (); i++)
    {
      System.out.println (reverse.charAt (i));
    }

  }



  /**
   * Youíre given the pointer to the head node of a linked list. Change the next
   * pointers of the nodes so that their order is reversed. The head pointer
   * given may be null meaning that the initial list is empty. Method
   * documentation to be filled TODO
   * 
   * @param head
   * @return
   */
  Node Reverse (Node head)
  {
    Node next = head;
    Node prev = null;

    Node current = null;
    while (next != null)
    {
      current = new Node ();

      current.data = next.data;
      current.next = prev;
      prev = current;
      next = next.next;
    }
    return current;
  }



  /**
   * 
   * Youíre given the pointer to the head nodes of two linked lists. Compare the
   * data in the nodes of the linked lists to check if they are equal. The lists
   * are equal only if they have the same number of nodes and corresponding
   * nodes contain the same data. Either head pointer given may be null meaning
   * that the corresponding list is empty.
   * 
   * @param headA
   * @param headB
   * @return
   */
  int CompareLists (Node headA, Node headB)
  {
    while (headA != null && headB != null)
    {
      if (headA.data != headB.data)
      {
        return 0;
      }
      headA = headA.next;
      headB = headB.next;
    }
    if ((headA == null && headB != null) || (headA != null && headB == null))
    {
      return 0;
    }
    return 1;
  }



  /**
   * Youíre given the pointer to the head nodes of two sorted linked lists. The
   * data in both lists will be sorted in ascending order. Change the next
   * pointers to obtain a single, merged linked list which also has data in
   * ascending order. Either head pointer given may be null meaning that the
   * corresponding list is empty.
   * 
   * Input Format You have to complete the Node* MergeLists(Node* headA, Node*
   * headB) method which takes two arguments - the heads of the two sorted
   * linked lists to merge. You should NOT read any input from stdin/console.
   * 
   * Output Format Change the next pointer of individual nodes so that nodes
   * from both lists are merged into a single list. Then return the head of this
   * merged list. Do NOT print anything to stdout/console. Method documentation
   * to be filled TODO
   * 
   * @param headA
   * @param headB
   * @return
   */
  Node MergeLists (Node headA, Node headB)
  {
    // This is a "method-only" submission.
    // You only need to complete this method
    Node mergedHead = new Node ();
    Node head = mergedHead;
    while (headA != null || headB != null)
    {
      

      if (headA != null && headB != null)
      {

        if (headA.data < headB.data)
        {
          mergedHead.data = headA.data;
          headA = headA.next;
        }
        else
        {
          mergedHead.data = headB.data;
          headB = headB.next;
        }
      }
      else
        if (headA != null && headB == null)
        {
          mergedHead.data = headA.data;
          headA = headA.next;
        }
        else
        {
          mergedHead.data = headB.data;
          headB = headB.next;
        }

      mergedHead.next = new Node();
      mergedHead = mergedHead.next;
    }
    return head;
  }
  // --------------------------------------------------------------------------
  // Any other separator such as "Utility methods", etc.
  // --------------------------------------------------------------------------
}
