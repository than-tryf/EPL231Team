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
	static MyCategory cat_list; // i lista me ta arxeia ana katigoria kaixristi
	static MyGraph g; // o grafos
	static MyVertex ver; // o komvos tou grafou
	static MyNode<String> katigoria; // komvos katigoria pou mpainei ston komvo
										// tou grafou
	static int d; // to d pou tou dinoume
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
			/**
			 * To while pio kato dimiourgei tous komvous tou grafou kai tous
			 * topothetei sto arraylist pou antiprosopeuei to grafo mas
			 */
			while ((s = br.readLine()) != null) {
				sbuf = s.split("[\t]+");
				ver = new MyVertex(Integer.parseInt(sbuf[1]),
						Integer.parseInt(sbuf[2]), sbuf[0]);
				katigoria = new MyNode<String>(sbuf[3], sbuf[4]);
				g.addToGraph(ver, katigoria);
			}
			g.createEdges(d); // dimiourgia ton akmon vasi tou d
			// g.printGraph();
			// g.printCategoriesOfNode(0);
			System.out.println("Arxikos grafos: ");
			g.printAdj(0);
			g.userLogOut("USER_1", d); // kano logout ton USER_1
			System.out.println("Telikos grafos: ");
			g.printAdj(0);
			cat_list.createCategoryList(g); // dimiourgia tis listas me tis
											// katigories
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
