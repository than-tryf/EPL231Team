package teamhw;

import java.util.ArrayList;

public class MyCategory {

	ArrayList<CategoryNode> kat;
	CategoryNode cnode;

	public MyCategory() {
		// TODO Auto-generated constructor stub
		kat = new ArrayList<CategoryNode>();
	}

	public void createCategoryList(MyGraph graph) {
		int i, j, k, index = 0;
		String cname, cuser, cfile;

		boolean flag = true;
		for (i = 0; i < graph.g.size(); i++) {
			
			for (j = 0; j < graph.g.get(i).categories.size(); j++) {
				flag=true;
				cname = graph.g.get(i).categories.get(j).data1;

				for (k = 0; k < kat.size(); k++) {
					if (cname.equals(kat.get(k).katigoria)) {
						flag = false;
						index = k;

					}

				}

				cuser = graph.g.get(i).name;
				cfile = graph.g.get(i).categories.get(j).data2;
				if (flag) {
					cnode = new CategoryNode(cname);
					kat.add(cnode);
					index = kat.size() - 1;
					kat.get(index).vertex.add(new MyNode<String>(cuser, cfile));
					//index = 0 ;
				} else {
					kat.get(index).vertex.add(new MyNode<String>(cuser, cfile));
					//index =0;
				}

			}
		}
	}

	public void printLists() {
		int i, j;
		String cuser, cfile;
		for (i = 0; i < kat.size(); i++) {
			System.out.println();
			System.out.println(kat.get(i).katigoria);
			System.out.println("----------------------------");
			for (j = 0; j < kat.get(i).vertex.size(); j++) {
				cuser = kat.get(i).vertex.get(j).data1;
				cfile = kat.get(i).vertex.get(j).data2;
				System.out.println(cuser + "\t" + cfile);
			}
		}
	}

}
