package teamhw;

import java.util.ArrayList;

/**
 * 
 * @author root
 */
public class MyVertex {

	int x; // x sintetagmeni
	int y; // y sintetagmeni
	boolean loggedin; // true an o user einai sindedemenos false an oxi
	String name; // username
	int id; // id tou user
	ArrayList<MyNode<Integer>> edges; // pinakas me tis akmes kai ta vari gia
										// kathe user
	ArrayList<MyNode<String>> categories; // pinakas me tis katigories kai ta
											// arxeia gia kathe user

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
