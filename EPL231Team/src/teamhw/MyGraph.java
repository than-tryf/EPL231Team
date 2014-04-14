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

	public void addToGraph(MyVertex v,MyNode<String> category) {
		boolean flag = true;
		int indx=0,i;
		for (i = 0; i < g.size(); i++) {
			if (g.get(i).name.equals(v.name)) {
				flag = false;
				indx = i;
			}
		}
		if (flag) {
			g.add(v);
			indx = g.size()-1;
			g.get(indx).categories.add(category);
		} else {
			g.get(indx).categories.add(category);
		}
		
	}

	public void printGraph() {
		for (int i = 0; i < g.size(); i++) {
			System.out.println(g.get(i).id);
		}
	}
	
	public void printCategoriesOfNode(int node){
		for(int i=0;i<g.get(node).categories.size();i++)
			System.out.println(g.get(node).categories.get(i).data1);
	}

}
