import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;



public class FallSafeIterator
{

  public FallSafeIterator ()
  {
    // TODO Auto-generated constructor stub
  }



  /**
   * @param args
   */
  public static void main (String[] args)
  {
    Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer> ();

    for (int i = 0; i < 10; i++)
    {
      Integer random = (int)(Math.random ()*10000);
      map.put(random,random);
    }

    Set<Entry<Integer, Integer>> mapSet = map.entrySet ();
    Iterator<Entry<Integer, Integer>> mapIterator = mapSet.iterator ();
    
    while (mapIterator.hasNext ()) {
      Entry<Integer, Integer> nextEntry = mapIterator.next ();
      mapIterator.remove ();
    }
    
    System.out.println ("it's ok to do modification and iterate");
    
    
    map = new HashMap<Integer, Integer> ();

    for (int i = 0; i < 10; i++)
    {
      Integer random = (int)(Math.random ()*10000);
      map.put(random,random);
    }

    mapSet = map.entrySet ();
    mapIterator = mapSet.iterator ();
    
    while (mapIterator.hasNext ()) {
      Entry<Integer, Integer> nextEntry = mapIterator.next ();
      mapIterator.remove ();
    }
    
    System.out.println ("it's  ok to do modification and iterate");
    
  }

}
