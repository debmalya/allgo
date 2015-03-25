package dj.graph;

import java.util.ArrayList;
import java.util.List;

public class DJGraph {

	private List<Integer>[] edges = null;
	
	private int noOfVertices;
	
	public DJGraph(int n) {
		noOfVertices = n;
		edges = new ArrayList[noOfVertices];
	}

	public void addEdge(int v,int w) {
		if (edges[v] == null) {
			edges[v] = new ArrayList<Integer>();
		}
		edges[v].add(w);
	}
}
