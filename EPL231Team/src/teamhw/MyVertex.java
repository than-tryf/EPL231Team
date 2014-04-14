package teamhw;

import java.util.ArrayList;

/**
 * 
 * @author root
 */
public class MyVertex {

	int x;
	int y;
	boolean loggedin;
	String name;
	int id;
	ArrayList<MyNode<Integer>> edges;
	ArrayList<MyNode<String>> categories;

	MyVertex(int x1, int y1, String n) {
		x = x1;
		y = y1;
		name = n;
		loggedin = true;
		id = Integer.parseInt(n.substring(5));
		edges = new ArrayList<MyNode<Integer>>();
		categories = new ArrayList<MyNode<String>>();

	}

}
