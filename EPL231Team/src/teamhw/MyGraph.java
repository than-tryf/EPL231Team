package teamhw;

import java.util.ArrayList;

/**
 * 
 * @author root
 */
public class MyGraph {

	ArrayList<MyVertex> g;

	public MyGraph() {
		g = new ArrayList<MyVertex>();
	}

	/**
	 * Pairnei san orisma enan komvo grafou pou dimiourgisame Elegxei an o user
	 * iparxei idi ston grafo(ArrayList) An iparxei tote apla prosthetei ta
	 * arxeia tou ston komvo tou allios prosthetei ton neo xristi ston ArrayList
	 * kai prosthetei ta arxeia tou
	 * 
	 * @param v
	 * @param category
	 */
	public void addToGraph(MyVertex v, MyNode<String> category) {
		boolean flag = true;
		int indx = 0, i;
		for (i = 0; i < g.size(); i++) {
			if (g.get(i).name.equals(v.name)) {
				flag = false;
				indx = i;
			}
		}
		if (flag) {
			g.add(v);
			indx = g.size() - 1;
			g.get(indx).categories.add(category);
		} else {
			g.get(indx).categories.add(category);
		}

	}

	/**
	 * Methodos pou kanei logout ton xristi USER_i An iparxei o xristis sto
	 * grafo kanoume to attribute tou komvou tou xristi loggedin = false
	 * epanarxikopoioume ta ArrayLists me tis akmes kathe xristi kai ta
	 * ksanadimiourgoume xoris tous xristes pou kanan logout
	 * 
	 * @param usr
	 * @param d
	 */

	public void userLogOut(String usr, int d) {
		int i, index = 0;
		boolean flag = false;

		for (i = 0; i < g.size(); i++) {
			if (usr.equals(g.get(i).name)) {
				flag = true;
				index = i;
				// break;
			}
		}
		if (flag) {
			g.get(index).loggedin = false;
			initEdges();
			createEdges(d);
		} else {
			System.out
					.println("Could not find the specified user to log him out!");
		}
	}

	/**
	 * Epistrefei true an o xristis einai sindedemenos allios false
	 * 
	 * @param ver
	 * @return
	 */
	public boolean userLogedin(MyVertex ver) {
		if (ver.loggedin) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Epanarxikopoiisi olon ton ArrayList ton akmon ton xriston tou grafou
	 */
	public void initEdges() {
		int i, j;
		for (i = 0; i < g.size(); i++) {
			for (j = 0; j < g.get(i).edges.size(); j++) {
				g.get(i).edges = new ArrayList<MyNode<Integer>>();
			}
		}
	}

	/**
	 * Dimiourgia akmon metaksi 2 xriston an i apostasi tous einai mikroteri apo
	 * to d kai an kai oi 2 xristes einai sindedemenoi
	 * 
	 * @param d
	 */
	public void createEdges(int d) {
		int i, j, weight;
		for (i = 0; i < g.size() - 1; i++) {
			for (j = i + 1; j < g.size(); j++) {
				weight = calculateDistance(g.get(i), g.get(j));
				if ((weight < d) && userLogedin(g.get(i))
						&& userLogedin(g.get(j))) {
					g.get(i).edges
							.add(new MyNode<Integer>(g.get(j).id, weight));
					g.get(j).edges
							.add(new MyNode<Integer>(g.get(i).id, weight));
				}
			}

		}
	}

	/**
	 * Ektipose tou komvous me tous opoious sindeetai enas xristis sto grafo
	 * 
	 * @param node
	 */
	public void printAdj(int node) {
		int i;
		for (i = 0; i < g.get(node).edges.size(); i++) {
			System.out.println(g.get(node).edges.get(i).data1 + " "
					+ g.get(node).edges.get(i).data2);
		}

	}

	/**
	 * Ektipose to id ton xriston pou einai ston grafo
	 */
	public void printGraph() {
		for (int i = 0; i < g.size(); i++) {
			System.out.println(g.get(i).id);
		}
	}

	public void printCategoriesOfNode(int node) {
		for (int i = 0; i < g.get(node).categories.size(); i++)
			System.out.println(g.get(node).categories.get(i).data1);
	}

	/**
	 * Ipologismos tis apostasis metaksi 2 xriston vasi ton sintetagmenon tous
	 * 
	 * @param z
	 * @return
	 */
	public int square(int z) {
		return z * z;
	}

	public int calculateDistance(MyVertex v1, MyVertex v2) {
		int xd, yd, dis;

		xd = square(v1.x - v2.x);
		yd = square(v1.y - v2.y);
		dis = (int) Math.sqrt(yd + xd);

		return dis;

	}

}
