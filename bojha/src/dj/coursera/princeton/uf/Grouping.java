/**
 * 
 */
package dj.coursera.princeton.uf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class Grouping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Recreation club assigned Miss Poi Poi to arrange trip for the members
	 * during Christmas. She did the survey. Every member mentioned name of
	 * their desired place. All those options are collected as a String array.
	 * 
	 * In this array, index is the member id (starts from 1) and the value is
	 * the name of the place. Now Miss Poi Poi has to group members whose desired place is
	 * same. Members should be arranged accoring to the places appeared in the array.
	 * She wants to assign this easy task to you. Could you write a code to
	 * help her?
	 * 
	 * Example: input
	 * ["San Francisco","San Francisco","Melbourne","Singapore","Paris"
	 * ,"Melbourne","Paris","London"] 
	 * 
	 * output {1,2},{3,6},{4},{5,7},{8}
	 * 
	 * Member 1 and 2 want to go "San Francisco". 
	 * Member 3 and 6 want to go "Melbourne".
	 * Member 4 want to go place "Singapore". 
	 * Member 5 and 7 want to go "Paris". 
	 * Member 8 want to go "London".
	 * 
	 * @param args
	 *            an String array.
	 * @return String
	 */	
	public static String group(String[] args) {
		LinkedHashMap<String, List<Integer>> o = new LinkedHashMap<>();
		
		for (int i = 0; i < args.length; i++) {
			List<Integer> v = o.get(args[i]);
			if (v == null) {
				v = new ArrayList<>();
			}
			v.add(i + 1);
			o.put(args[i], v);
		}

		Collection<List<Integer>> v = o.values();
		StringBuilder sb = new StringBuilder();
		for (List<Integer> e : v) {
			sb.append(e.toString().replace("[", "{").replace("]", "}").replace(" ", ""));
			sb.append(",");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

}
