package teamhw;

import java.util.ArrayList;

public class CategoryNode {
	public String katigoria;
	public ArrayList<MyNode<String>> vertex;

	
	public CategoryNode(String cat) {
		// TODO Auto-generated constructor stub
		
		katigoria = cat;
		vertex = new ArrayList<MyNode<String>>();
		
	}

}
