package teamhw;

import java.util.ArrayList;

/**
 * Class that finds the sortest path given a graph
 * 
 * @author thanasis
 * 
 */
public class Dijkstra {
	ArrayList<MyNode<Integer>> d;// pinakas me ta distances.
	ArrayList<Boolean> v;// pinakas visited
	ArrayList<MyNode<Integer>> sp;// pinakas pou dinei to shortest path

	/**
	 * Arxikopoiisi ton pinakon!
	 * 
	 * @param graph
	 */

	public Dijkstra(MyGraph graph) {
		// TODO Auto-generated constructor stub
		d = new ArrayList<MyNode<Integer>>();
		v = new ArrayList<Boolean>();
		sp = new ArrayList<MyNode<Integer>>();
		for (int i = 0; i < graph.g.size(); i++) {
			d.add(new MyNode<Integer>(graph.g.get(i).id, Integer.MAX_VALUE));
			v.add(Boolean.FALSE);
		}
	}

	public void calculateDijkstra() {

	}

	/**
	 * 
	 */

}
