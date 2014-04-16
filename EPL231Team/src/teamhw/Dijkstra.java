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
		gr = graph;

		for (int i = 0; i < graph.g.size(); i++) {
			d.add(new MyNode<Integer>(graph.g.get(i).id, Integer.MAX_VALUE));
			v.add(Boolean.FALSE);
		}
	}

	public void calculateDijkstra(String usr, String cat) {
		int count = 0;
		int index = 0;
		int dis_u, dis_u_v;
		int w_u_v;

		// Find in which position in the array is the user
		for (int i = 0; i < gr.g.size(); i++) {
			if (usr.equals(gr.g.get(i).name)) {
				index = i;
				break;
			}
		}

		// Arxikopoiisi algorithmou
		d.get(index).data2 = 0;
		v.set(index, true);

		while (count < gr.g.size()) {
			for (int j = 0; j < gr.g.get(index).edges.size(); j++) { // problem
																		// edges.get(j);
				dis_u_v = d.get(j).data2;
				dis_u = d.get(index).data2;
				w_u_v = gr.g.get(index).edges.get(j).data2;
				if (dis_u_v > dis_u + w_u_v) {
					dis_u_v = dis_u + w_u_v;
				}
			}

			index = findMinIndex();
			v.set(index, true);
			count++;
		}
		findMinCat(cat);

	}

	/**
	 * 
	 */
	public int findMinIndex() {
		int indexmin = findMaxIndex();
		int min_dis = d.get(indexmin).data2;
		boolean visited;
		int distance;
		
		for (int i = 0; i < d.size(); i++){ // for each vertex, if it’s in tree and 
			visited = v.get(i);
			distance = d.get(i).data2;
			
			if (!visited && (distance < min_dis)){ // smaller than old one
				min_dis = distance;
				indexmin = i; // update minimum
			}
		}
		return indexmin; // return index of minimum
	}
	
	public int findMaxIndex(){

		int maxDis = Integer.MIN_VALUE;
		int indexmax = 0;
		boolean visited;
		int distance;

		for(int i = 0 ; i<d.size();i++){
			visited = v.get(i);
			distance = d.get(i).data2;
			if(!visited && (distance > maxDis)){
				maxDis = distance;
				indexmax = i;
			}
		}

		return indexmax;
		
	}
	
	
	/**
	 * This method will check the category which we are searching for
	 * in the smallest path. If we find we stop, otherwise we continue
	 * to the second smallest path until we get the category.
	 * If not found, means our path (node) is not connected. 
	 * @param category
	 * @return
	 */
	// Find the category which are in the smallest node.
	public int findMinCat(String category){
		// TODO To be completed soon...
		
		int mincat = 1;//
		return mincat;
	}
}


