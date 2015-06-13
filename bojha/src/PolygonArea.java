import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class PolygonArea {

		public static void main(String[] args) {
			Scanner scanner = null;
			try {
				scanner = new Scanner(System.in);
				int noOfTestCases = Integer.parseInt(scanner.nextLine());
				List<Integer> areas = new ArrayList<Integer>();
				for (int i = 0; i < noOfTestCases; i++) {
					int noOfPoints = Integer.parseInt(scanner.nextLine());
					ArrayList<Point> pointList = new ArrayList<Point>();
					for (int j = 0; j < noOfPoints; j++) {
						
						String nextEntry = scanner.nextLine();
						String[] values = nextEntry.split(" ");
						Point point = new Point(Integer.parseInt(values[0]),Integer.parseInt(values[1]));
						pointList.add(point);
					}
					areas.add(getArea(execute(pointList)));
				}
				
				for (int i = 0; i <areas.size(); i++) {
					System.out.println(areas.get(i));
				}
				
			}catch(Throwable th) {
				
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
		
		
		private static int getArea(ArrayList<Point> points) {
			float area = 0;
			int size = points.size();
			for (int i = 0; i < size; i++) {
				
					area += points.get(i).x * points.get((i + 1)%size).y;				
					area -= points.get((i+1)%size).x * points.get(i).y;
				
			}
			area=Math.abs(area/2);
			if ((area - (int)area) > 0.5){
				return Math.round(area);
			}
			return (int)area;
		}
		
		private static ArrayList<Point> execute (ArrayList<Point> points)
		  {
		    ArrayList<Point> xSorted = (ArrayList<Point>)points.clone ();
		    PolygonArea m = new PolygonArea();
		    Collections.sort (xSorted, m.new XCompare ());

		    int n = xSorted.size ();

		    Point[] lUpper = new Point[n];

		    lUpper[0] = xSorted.get (0);
		    lUpper[1] = xSorted.get (1);

		    int lUpperSize = 2;

		    for (int i = 2; i < n; i++)
		    {
		      lUpper[lUpperSize] = xSorted.get (i);
		      lUpperSize++;

		      while (lUpperSize > 2 && !rightTurn (lUpper[lUpperSize - 3], lUpper[lUpperSize - 2], lUpper[lUpperSize - 1]))
		      {
		        // Remove the middle point of the three last
		        lUpper[lUpperSize - 2] = lUpper[lUpperSize - 1];
		        lUpperSize--;
		      }
		    }

		    Point[] lLower = new Point[n];

		    lLower[0] = xSorted.get (n - 1);
		    lLower[1] = xSorted.get (n - 2);

		    int lLowerSize = 2;

		    for (int i = n - 3; i >= 0; i--)
		    {
		      lLower[lLowerSize] = xSorted.get (i);
		      lLowerSize++;

		      while (lLowerSize > 2 && !rightTurn (lLower[lLowerSize - 3], lLower[lLowerSize - 2], lLower[lLowerSize - 1]))
		      {
		        // Remove the middle point of the three last
		        lLower[lLowerSize - 2] = lLower[lLowerSize - 1];
		        lLowerSize--;
		      }
		    }

		    ArrayList<Point> result = new ArrayList<Point> ();

		    for (int i = 0; i < lUpperSize; i++)
		    {
		      result.add (lUpper[i]);
		    }

		    for (int i = 1; i < lLowerSize - 1; i++)
		    {
		      result.add (lLower[i]);
		    }

		    return result;
		  }



		  private static boolean rightTurn (Point a, Point b, Point c)
		  {
		    return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x) > 0;
		  }








		  private class XCompare implements Comparator<Point>
		  {

		    @Override
		    public int compare (Point o1, Point o2)
		    {
//		      return (new Integer (o1.x)).compareTo (new Integer (o2.x));
		    	if (o1.x > o2.x) {
		    		return 1;
		    	} else if (o1.x < o2.x) {
		    		return -1;
		    	}else if (o1.y > o2.y) {
		    		return 1;
		    	}else if (o1.y < o2.y) {
		    		return -1;
		    	}
		    	return 0;
		    }
		  }
}
