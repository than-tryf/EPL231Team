package teamhw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author root
 */
public class MainProg {

	static String fname, s;
	static File f;
	static FileReader fr;
	static BufferedReader br;
	static String sbuf[]; // pairnei [USER_18, 828, 319, Annet_Artani,
							// file342.mp3]
	static MyCategory cat_list;
	static MyGraph g;
	static MyVertex ver;
	static MyNode<String> katigoria;
	static int d;
	static Scanner in;

	public static void main(String[] args) {
		try {
			fname = "./HW3InputFile.txt";
			f = new File(fname);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			br.readLine();
			g = new MyGraph();
			cat_list = new MyCategory();
			in = new Scanner(System.in);
			long start, end;

			System.out.print("Dose to d: ");
			d = in.nextInt();

			start = System.currentTimeMillis();
			while ((s = br.readLine()) != null) {
				sbuf = s.split("[\t]+");
				// System.out.println(sbuf[4]);
				ver = new MyVertex(Integer.parseInt(sbuf[1]),
						Integer.parseInt(sbuf[2]), sbuf[0]);
				katigoria = new MyNode<String>(sbuf[3], sbuf[4]);
				g.addToGraph(ver, katigoria);
			}
			g.createEdges(d);
			// g.printGraph();
			// g.printCategoriesOfNode(0);
			System.out.println("Arxikos grafos: ");
			g.printAdj(0);
			g.userLogOut("USER_1", d);
			System.out.println("Telikos grafos: ");
			g.printAdj(0);
			cat_list.createCategoryList(g);
			// cat_list.printLists();
			end = System.currentTimeMillis();
			System.out.println("Spend time = " + (end - start) + "Milsec");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found...!");
		} catch (IOException ex) {
			System.out.println("Inout/output error!");
		}

	}

}
