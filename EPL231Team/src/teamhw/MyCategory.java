package teamhw;

import java.util.ArrayList;

/**
 * 
 * @author atryfo03
 * 
 */
public class MyCategory {

	ArrayList<CategoryNode> kat;
	CategoryNode cnode;

	public MyCategory() {
		// TODO Auto-generated constructor stub
		kat = new ArrayList<CategoryNode>();
	}

	/**
	 * dimiourgia listas me katigories apo ton grafo
	 * 
	 * @param graph
	 */
	public void createCategoryList(MyGraph graph) {
		int i, j, k, index = 0;
		String cname, cuser, cfile;

		boolean flag = true;
		for (i = 0; i < graph.g.size(); i++) {

			for (j = 0; j < graph.g.get(i).categories.size(); j++) {
				flag = true;
				cname = graph.g.get(i).categories.get(j).data1;
				if (cname != null) {
					for (k = 0; k < kat.size(); k++) {
						if (cname.equals(kat.get(k).katigoria)) {
							flag = false;
							index = k;

						}

					}
				}

				cuser = graph.g.get(i).name;
				cfile = graph.g.get(i).categories.get(j).data2;
				if (flag) {
					cnode = new CategoryNode(cname);
					kat.add(cnode);
					index = kat.size() - 1;
					kat.get(index).vertex.add(new MyNode<String>(cuser, cfile));
					// index = 0 ;
				} else {
					kat.get(index).vertex.add(new MyNode<String>(cuser, cfile));
					// index =0;
				}

			}
		}
	}

	/**
	 * Ektiposi katigorion kai xriston me ta arxeia gia kathe katigria
	 */
	public void printLists() {
		int i, j;
		String cuser, cfile;
		for (i = 0; i < kat.size(); i++) {
			if (kat.get(i).katigoria != null) {
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

	public void printData(String category) {

		boolean flag = false;

		for (int i = 0; i < kat.size(); i++) {

			if (kat.get(i).katigoria.equals(category)) {
				flag = true;

				for (int g = 0; g < kat.get(i).vertex.size(); g++) {
					System.out.println(kat.get(i).vertex.get(g).data1 + "  "
							+ kat.get(i).vertex.get(g).data2);

				}// for g

			}// if statment

			if (flag == true)
				return;

		}

	}// printData

}
