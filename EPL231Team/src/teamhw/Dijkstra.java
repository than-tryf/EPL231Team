package teamhw;

import java.util.ArrayList;

/**
 * Class that finds the shortest path given a graph
 * 
 * @author thanasis
 * 
 */

// Magos
public class Dijkstra {
	ArrayList<MyNode<Integer>> d;// pinakas me ta distances.
	ArrayList<Boolean> v;// pinakas visited
	ArrayList<MyNode<Integer>> sp;// pinakas pou dinei to shortest path
	MyGraph gr;

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
		gr = new MyGraph();

		for (int i = 0; i < graph.g.size(); i++) {
			d.add(new MyNode<Integer>(graph.g.get(i).id, Integer.MAX_VALUE - 1));
			v.add(Boolean.FALSE);
			// gr.g.add(graph.g.get(i));

		}
		gr = graph;
	}

	public void calculateDijkstra(String usr, String cat) {
		int count = 1;
		int index = 0;
		int dis_u, dis_u_v;
		int w_u_v;
		int strt = index;
		int min_cat;
		int me;
		// Find in which position in the array is the starting user
		for (int i = 0; i < gr.g.size(); i++) {
			if (usr.equals(gr.g.get(i).name)) {
				index = i;
				strt = index;
				break;
			}
		}

		// System.out.println("Max Integer = "+Integer.MIN_VALUE);

		// Arxikopoiisi algorithmou
		d.get(index).data2 = 0;
		v.set(index, true);
		System.out.println("Arxikopoiimenos pinakas distance Dijkstra: ");
		for (int i = 0; i < d.size(); i++) {
			System.out.println(d.get(i).data1 + " " + d.get(i).data2);
		}
		/*
		 * / --------- for (int i = 0; i < v.size(); i++) { if (d.get(i).data2
		 * == Integer.MAX_VALUE - 1) { v.set(i, true); count++; } }
		 */
		while (count < gr.g.size()) {

			for (int j = 0; j < gr.g.get(index).edges.size(); j++) { // problem
				me = matchEdge(gr.g.get(index).edges.get(j).data1);
				// System.out.println("*************************");
				if (!v.get(me)) {
					if (d.get(index).data2 < Integer.MAX_VALUE - 1) {
						dis_u_v = d.get(me).data2;
						// System.out.println("Distance ("+me+","+index+")"+dis_u_v);
						dis_u = d.get(index).data2;
						// System.out.println(dis_u);
						w_u_v = gr.g.get(index).edges.get(j).data2;
						// System.out.println(w_u_v);
						if (dis_u_v > dis_u + w_u_v) {
							d.get(me).data2 = dis_u + w_u_v;
							// System.out.println("I am here. dis(u,v) = "+d.get(me).data2);
						}
						// System.out.println("**************");

					}
				}
			}
			index = findMinIndex();
			// System.out.println(index + " " + d.get(index).data2);
			v.set(index, true);
			count++;
		}

		System.out.println("Elaxistes apostasis apo ton " + usr);
		for (int i = 0; i < d.size(); i++) {
			System.out.println(d.get(i).data1 + " " + d.get(i).data2);
		}

		initVisitedArray(strt);
		min_cat = findMinCat(cat);
		if (min_cat >= 0) {
			System.out.println("Arxeia katigorias: " + cat
					+ " Me elaxisti apostasi apo ton xristi: " + usr);
			printUserFiles(min_cat, cat);
		} else {
			System.out.println("I katigoria " + cat + " einai ektos grafou!");
		}

	}

	public void printUserFiles(int mc, String cat) {
		String category;
		String user;
		String fname;
		int distance = d.get(mc).data2;
		for (int i = 0; i < gr.g.get(mc).categories.size(); i++) {
			category = gr.g.get(mc).categories.get(i).data1;
			if (category != null) {
				if (category.equals(cat)) {
					fname = gr.g.get(mc).categories.get(i).data2;
					user = gr.g.get(mc).name;
					System.out.println("User: " + user + " File: " + fname
							+ " Distance: " + distance);
				}
			}
		}
	}

	/**
	 * 
	 */

	public void initVisitedArray(int start) {
		v = new ArrayList<Boolean>();
		for (int i = 0; i < gr.g.size(); i++) {
			v.add(Boolean.FALSE);
		}
		v.set(start, true);

	}

	/**
	 * 
	 * @param usrid
	 * @return
	 */

	public int matchEdge(int usrid) {
		int matchedEdge = -1;
		for (int i = 0; i < gr.g.size(); i++) {
			if (usrid == gr.g.get(i).id) {
				matchedEdge = i;
				break;
			}
		}

		return matchedEdge;

	}

	public int findMinIndex() {
		int minIndex = 0;
		int minDist = Integer.MAX_VALUE;
		// int minIndex = findMaxDist();
		// int minDist = d.get(minIndex).data2;
		boolean visited;
		int distance;
		int i;
		for (i = 0; i < d.size(); i++) {
			visited = v.get(i);
			distance = d.get(i).data2;
			if (!visited && (distance < minDist)) {
				minIndex = i;
				minDist = distance;
			}
			// System.out.println("Current min = "+minIndex+" "+d.get(minIndex).data2);
		}
		// System.out.println(minIndex+" "+d.get(minIndex).data2);
		return minIndex;
	}

	public int findMaxDist() {
		int maxIndex = 0;
		int maxDist = Integer.MIN_VALUE;
		boolean visited;
		int distance;
		for (int i = 0; i < d.size(); i++) {
			visited = v.get(i);
			distance = d.get(i).data2;
			if (!visited && (distance > maxDist)) {
				maxIndex = i;
				maxDist = distance;
			}
		}
		return maxIndex;
	}

	public int findMinCat(String category) {
		int minCat = findMaxDist();
		// int minDis = d.get(minCat).data2;
		// boolean visited;
		boolean found = false;
		// int distance;
		int count = 1;
		String ctg;
		while (count < d.size()) {
			minCat = findMinIndex();
			for (int i = 0; i < gr.g.get(minCat).categories.size(); i++) {
				ctg = gr.g.get(minCat).categories.get(i).data1;
				if (ctg != null) {
					if (category.equals(ctg)) {
						found = true;
						break;
					}
				}
			}
			if (found)
				break;
			v.set(minCat, true);
			count++;
			minCat = findMaxDist();
		}
		if (!found || !(d.get(minCat).data2 < (Integer.MAX_VALUE - 1)))
			minCat = -1;
		return minCat;
	}
}
