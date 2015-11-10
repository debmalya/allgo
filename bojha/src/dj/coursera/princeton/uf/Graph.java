/**
 * 
 */
package dj.coursera.princeton.uf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author debmalyajash
 *
 */
public class Graph {
	private int value;

	private int numberOfVertices;

	private List<Integer> adjacencyList;

	private Map<Integer, List<Integer>> verticesMap;

	private int numberOfEdges;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void addEdge(int v, int w) {
		List<Integer> edges = verticesMap.get(v);
		if (edges == null) {
			edges = new ArrayList<Integer>();
		}
		edges.add(w);
		verticesMap.put(v, edges);
	}

	/**
	 * Vertices adjacent to v.
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return verticesMap.get(v);
	}

	/**
	 * Create an empty graph with V vertices.
	 * 
	 * @param v
	 */
	public Graph(int v) {
		verticesMap = new HashMap<Integer, List<Integer>>(v);
		numberOfVertices = v;
	}

	/**
	 * Number of edges.
	 * 
	 * @return
	 */
	public int E() {
		numberOfEdges = 0;
		verticesMap.forEach((key, value) -> numberOfEdges += value.size());
		return numberOfEdges;
	}
	
	

}
